package com.brane.patientservice.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Patient extends BaseEntity {
    private String fullName;
    private String phoneNumber;
}

