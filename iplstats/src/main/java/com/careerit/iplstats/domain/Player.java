package com.careerit.iplstats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String country;
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "team")
    private TeamDetails teamDetails;
}
