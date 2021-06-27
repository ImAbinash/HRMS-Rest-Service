package com.ImAbinash.hrms.utility;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class AppUtility {

	private static final String UTC_Formated_String="dd-MM-yyyy'T'HH:mm:ss";
	public String getUTCStandardDateTime(String date) {
		
		
		DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
                .ofPattern(UTC_Formated_String);

		//Instance with given offset
		OffsetDateTime odtInstanceAtOffset = OffsetDateTime.parse(date, DATE_TIME_FORMATTER);
		
		//Instance in UTC
		OffsetDateTime odtInstanceAtUTC = odtInstanceAtOffset.withOffsetSameInstant(ZoneOffset.UTC);
		
		//Formatting to string
		String dateStringInUTC = odtInstanceAtUTC.format(DATE_TIME_FORMATTER);
		
		System.out.println(odtInstanceAtOffset);
		System.out.println(odtInstanceAtUTC);
		System.out.println(dateStringInUTC);
		
		//Convert OffsetDateTime to instant which is in UTC
		System.out.println(odtInstanceAtOffset.toInstant());
		return dateStringInUTC;
	}
	
	
	public String getTodaysDateInUTCFormat() {
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat(UTC_Formated_String); 
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dateFormat.format(date);
	}
	public String getUUID() {
		return UUID.randomUUID().toString();
	}
}
