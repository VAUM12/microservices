package com.easybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter@ToString
@MappedSuperclass
public class BaseEntity {
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false )
    private LocalDateTime updatedDate;

    @Column(insertable = false )
    private String updatedBy;
}