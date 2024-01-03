package com.brane.patientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brane.patientservice.exception.PatientNotFoundException;
import com.brane.patientservice.model.Patient;
import com.brane.patientservice.repository.PatientRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;
	
    public Patient findPatientById(Long id) throws PatientNotFoundException {
		Optional<Patient> optionalObject = patientRepository.findById(id);
		if (optionalObject.isPresent())
			return optionalObject.get();
		else
			throw new PatientNotFoundException("Patient with this id does not exist");
	}
	
	public List<Patient> findAllPatients() {
		return patientRepository.findAll();
	}
	
	public Patient findByPhoneNumber(String phoneNumber) {
		return patientRepository.findByPhoneNumber(phoneNumber);
	}
	
}
