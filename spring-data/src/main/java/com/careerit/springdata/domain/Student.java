package com.careerit.springdata.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
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

    @OneToMany(mappedBy = "student")
    private Set<Address> addresses=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> courses=new HashSet<>();

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
