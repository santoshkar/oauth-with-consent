package com.brane.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brane.patientservice.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient findByPhoneNumber(String phoneNumber);
}

