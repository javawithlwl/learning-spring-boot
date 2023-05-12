package com.careerit.cbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(unique = true,name = "email")
    private String email;
    @Column(name = "mobile",unique = true)
    private String mobile;

    @PrePersist
    public void prePersists(){
        if(id==null) {
            this.id = ThreadLocalRandom.current().nextLong(100000, 9999999);
        }
    }
}
