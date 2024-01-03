package com.brane.patientservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	@GetMapping("/message")
	public String sayHello() {
		return "Hello Patient Application";
	}
	
}
