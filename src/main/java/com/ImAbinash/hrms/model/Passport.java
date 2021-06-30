package com.ImAbinash.hrms.model;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="update_passport_by_id",query = "Update Passport p SET p.passportNumber= :pNo , p.passportImage= :pImage , p.updatedDate = :pUdate WHERE id= :id")
})
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "passport_number")
	private String passportNumber;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "passport_image", length=500000)
	private byte[] passportImage;

	@Column(name="updated_date")
	public String updatedDate;
	
	@Column(name="created_date")
	public String createdDate;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public byte[] getPassportImage() {
		return passportImage;
	}

	public void setPassportImage(byte[] passportImage) {
		this.passportImage = passportImage;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", " + (passportNumber != null ? "passportNumber=" + passportNumber + ", " : "")
				+ (passportImage != null ? "passportImage=" + Arrays.toString(passportImage) : "") + "]";
	}
	
	
}
