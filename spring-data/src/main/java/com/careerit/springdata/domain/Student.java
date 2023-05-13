package com.careerit.springdata.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Student extends  BaseEntity{

    @Id
    private UUID id;

    private String name;
    private String email;
    private String mobile;
    private String course;
    private double fee;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;
    @Override
    public UUID getId() {
        return id;
    }
    @PrePersist
    public void prePersist(){
        super.prePersist();
        this.id = UUID.randomUUID();
    }
}
