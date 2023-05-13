package com.careerit.springdata.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "passport")
@Getter
@Setter
public class Passport extends  BaseEntity {

    @Id
    private UUID id;
    private String number;
    private String fullName;
    private LocalDate issuedDate;
    private LocalDate expiryDate;
    @OneToOne(mappedBy = "passport")
    private Student student;
    public UUID getId() {
        return id;
    }
    @PrePersist
    public void prePersist(){
        super.prePersist();
        this.id = UUID.randomUUID();
    }

}
