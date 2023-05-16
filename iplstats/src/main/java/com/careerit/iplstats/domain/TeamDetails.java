package com.careerit.iplstats.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team_details")
@Getter
@Setter
public class TeamDetails {
    @Id
    private String team;
    private String teamName;
    private String captain;
    @OneToMany(mappedBy = "teamDetails")
    private Set<Player> players = new HashSet<>();
}
