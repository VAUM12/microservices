package com.eazybytes.loans.entity;

import jakarta.persistence.EntityListeners;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    private String createdBy;
    private String updatedBy;
    private Date createdDate;
    private Date updatedDate;
}
