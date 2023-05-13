package com.careerit.springdata.domain;

import com.careerit.springdata.util.RequestContextProvider;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Column(name = "created_by",nullable = false,updatable = false)
    private String createdBy;
    @Column(name = "updated_by",nullable = false,updatable = true)
    private String updatedBy;
    @Column(name = "created_date",nullable = false,updatable = false)
    private LocalDateTime createdDate;
    @Column(name = "updated_date",nullable = false,updatable = true)
    private LocalDateTime updatedDate;

    @Column(name = "deleted",nullable = false)
    protected  boolean deleted;

    public abstract Object getId();


    @PrePersist
    public void prePersist(){
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
        this.createdBy = RequestContextProvider.getUserName();
        this.updatedBy = RequestContextProvider.getUserName();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = RequestContextProvider.getUserName();
    }


}
