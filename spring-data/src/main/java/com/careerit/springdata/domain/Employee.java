package com.careerit.springdata.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
public class Employee extends  BaseEntity{

    @Id
    private UUID id;
    private String name;
    private String email;
    private String mobile;
    private double salary;

    public UUID getId() {
        return id;
    }

    @PrePersist
    public void prePersist(){
        super.prePersist();
        this.id = UUID.randomUUID();
      }


}
