package com.ImAbinash.hrms.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ImAbinash.hrms.model.Passport;
import com.ImAbinash.hrms.repository.PassportRepository;
import com.ImAbinash.hrms.utility.AppUtility;

@Service
public class PassportService {
	
	
	@Autowired
	AppUtility appUtility;
	
	@Autowired
	PassportRepository pr;
	
	
	public String savePassportDetails(MultipartFile file,String passportNumber) throws IOException {
		
		Passport passport = new Passport();
		
		passport.setCreatedDate(appUtility.getTodaysDateInUTCFormat());
		passport.setUpdatedDate(appUtility.getTodaysDateInUTCFormat());
		passport.setPassportNumber(passportNumber);
		passport.setPassportImage(appUtility.compressBytes(file.getBytes()));
		
		return pr.savePassport(passport);
	}
	
	
	public Passport getPassportDetailsById(int id) {
		Passport passport =  pr.findById(id);
		byte[] passportImage = appUtility.decompressBytes(passport.getPassportImage());
		passport.setPassportImage(passportImage);
		return passport;
	}
	
	public Passport updatePassportById(int id,MultipartFile file,String passportNumber) throws IOException {
		Passport passportModel = new Passport();
		passportModel.setId(id);
		passportModel.setUpdatedDate(appUtility.getTodaysDateInUTCFormat());
		passportModel.setPassportNumber(passportNumber);
		passportModel.setPassportImage(appUtility.compressBytes(file.getBytes()));
		
		return pr.updatePassportById(passportModel);
		
	}
	
	
	
	
	
	
}
