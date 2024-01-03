package com.brane.patientservice.exception;

public class PatientNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = -4198678282808337558L;

	public PatientNotFoundException() {
		super();
	}

	public PatientNotFoundException(String message) {
		super(message);
	}
}
