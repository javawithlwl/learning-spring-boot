const columnChart = document.querySelector('#columnChart');
const pieChart = document.querySelector('#pieChart');
const teamNames = document.querySelector('#teamNames');

const baseUrl = "http://localhost:8080";
google.charts.load('current', { 'packages': ['corechart'] });

const getRoleData = async () => {
    const response = await fetch(`${baseUrl}/api/v1/stats/role`);
    const data = await response.json();
    return data;
}

const getTeamData = async () => {
    const response = await fetch(`${baseUrl}/api/v1/stats/team`);
    const data = await response.json();
    return data;
}
const getTeamNames = async () => {
    const response = await fetch(`${baseUrl}/api/v1/stats/team/names`);
    const data = await response.json();
    return data;
}

google.charts.setOnLoadCallback(drawPieChart);
google.charts.setOnLoadCallback(drawColumnChart);

showTeamNames();

function showTeamNames(){
    getTeamNames().then((res) => {
       str =  `<select class="form-select" id="teamNameId" onchange="showPlayers()">
       <option selected value="">Select Team</option>`;
        res.forEach((team) => {
            str += `<option value="${team}">${team}</option>`;
        })
        str += `</select>`;
        teamNames.innerHTML = str;
    })
}
function showPlayers(){
       let str = document.querySelector('#teamNameId').value;
       if(str != ""){
            console.log("Player list of "+str);
       }
}


function drawColumnChart() {
    getTeamData().then((res) => {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Team');
        data.addColumn('number', 'Amount');
        res.forEach((team) => {
            data.addRow([team.team, team.amount]);
        })
        var options = {
            'title': 'Team Amount Details',
            'width': 600,
            'height': 400
        };
        var chart = new google.visualization.ColumnChart(columnChart);
        chart.draw(data, options);
    });
}


// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawPieChart() {

            // Create the data table.
            getRoleData().then((res) => {
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Role');
                data.addColumn('number', 'Amount');
                res.forEach((role) => {
                    data.addRow([role.role, role.totalAmount]);
                })
                var options = {
                    'title': 'Role Count Details',
                    'width': 600,
                    'height': 400
                };

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.PieChart(pieChart);
                chart.draw(data, options);
            })


        }



