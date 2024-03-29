package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Citizens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "citizenId", nullable = false)
	private int citizenId;
	private String name;
	private String dob;
	private String emailid;
	private String mobileno;
	private String gender;
	private String address;
	@Column(name = "adhar_number")
	private String adharNumber;
	public int getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(int citizenId) {
		this.citizenId = citizenId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	@Override
	public String toString() {
		return "Citizens [citizenId=" + citizenId + ", name=" + name + ", dob=" + dob + ", emailid=" + emailid
				+ ",mobileno=" + mobileno + ", gender=" + gender + ", address=" + address
				+ ", adharNumber=" + adharNumber + "]";
	}}
