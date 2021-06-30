package com.ImAbinash.hrms.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.stereotype.Service;

@Service
public class AppUtility {

	private static final String UTC_Formated_String = "dd-MM-yyyy'T'HH:mm:ss";

	public String getUTCStandardDateTime(String date) {

		DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(UTC_Formated_String);

		// Instance with given offset
		OffsetDateTime odtInstanceAtOffset = OffsetDateTime.parse(date, DATE_TIME_FORMATTER);

		// Instance in UTC
		OffsetDateTime odtInstanceAtUTC = odtInstanceAtOffset.withOffsetSameInstant(ZoneOffset.UTC);

		// Formatting to string
		String dateStringInUTC = odtInstanceAtUTC.format(DATE_TIME_FORMATTER);

		System.out.println(odtInstanceAtOffset);
		System.out.println(odtInstanceAtUTC);
		System.out.println(dateStringInUTC);

		// Convert OffsetDateTime to instant which is in UTC
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

	// compress the image bytes before storing it in the database

	public byte[] compressBytes(byte[] data) {

		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();

	}

	// uncompress the image bytes before returning it to the angular application

	public byte[] decompressBytes(byte[] data) {

		Inflater inflater = new Inflater();

		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		try {

			while (!inflater.finished()) {

				int count = inflater.inflate(buffer);

				outputStream.write(buffer, 0, count);

			}

			outputStream.close();

		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}

		return outputStream.toByteArray();

	}
}
