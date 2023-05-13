package com.careerit.springdata.repo;

import com.careerit.springdata.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @BeforeEach
    void init(){
        employeeRepo.deleteAll();
    }
    @Test
    void addEmployeeTest(){
        Employee employee = getEmployee();
        employeeRepo.save(employee);
    }
    @Test
    void getAllEmployees(){
        List<Employee> employees = getEmployeesWithDeletedStatus();
        employeeRepo.saveAll(employees);
        List<Employee> empList = employeeRepo.findAll();
        empList.forEach(System.out::println);

    }

    public Employee getEmployee() {
      Employee employee = new Employee();
      employee.setName("Krish");
      employee.setEmail("krish.t@gmail.com");
      employee.setMobile("9876543210");
      employee.setSalary(100000);
      return employee;
    }
    public List<Employee> getEmployees(){
       Employee employee1 = new Employee();
      employee1.setName("Krish");
      employee1.setEmail("krish.t@gmail.com");
      employee1.setMobile("9876543210");
      employee1.setSalary(100000);
      Employee employee2 = new Employee();
      employee2.setName("Manoj");
      employee2.setEmail("manoj.pvn@gmail.com");
      employee2.setMobile("9876543210");
      employee2.setSalary(200000);
      return List.of(employee1,employee2);
    }

  public List<Employee> getEmployeesWithDeletedStatus(){
    Employee employee1 = new Employee();
    employee1.setName("Krish");
    employee1.setEmail("krish.t@gmail.com");
    employee1.setMobile("9876543210");
    employee1.setSalary(100000);
    Employee employee2 = new Employee();
    employee2.setName("Manoj");
    employee2.setEmail("manoj.pvn@gmail.com");
    employee2.setMobile("9876543210");
    employee2.setSalary(200000);

    Employee employee3 = new Employee();
    employee3.setName("Charan");
    employee3.setEmail("charan.k@gmail.com");
    employee3.setMobile("9876543210");
    employee3.setSalary(300000);
    employee3.setDeleted(true);
    return List.of(employee1,employee2,employee3);
  }
}
