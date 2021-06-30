package com.ImAbinash.hrms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ImAbinash.hrms.model.Passport;
import com.ImAbinash.hrms.services.PassportService;

@RestController
public class PassportController {

	
	@Autowired
	PassportService ps;
	
	
	@PostMapping("/passport")
	public String uplaodImage(@RequestParam MultipartFile file, @RequestParam String passportNumber) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		return ps.savePassportDetails(file, passportNumber);
	}

	@GetMapping("/passport/{id}")
	public Passport getPassportById(@PathVariable int id) {
		return ps.getPassportDetailsById(id);
	}
	
	
	@PutMapping("/passport/{id}")
	public Passport updatePassportDetailsById(@PathVariable int id, @RequestParam MultipartFile file, @RequestParam String passportNumber) throws IOException {
		
		return ps.updatePassportById(id, file, passportNumber);
	}
	
	
	
	
}
