package com.javaEE.patient.jdbc;

public class Pharmacies {
	private int pharmId;
	private int patientId;
	private String pharmName;
	private String address;
	private String phone;
	/**
	 * @param pharmId
	 * @param patientId
	 * @param pharmName
	 * @param address
	 * @param phone
	 */
	public Pharmacies(int pharmId, int patientId, String pharmName, String address, String phone) {
		super();
		this.pharmId = pharmId;
		this.patientId = patientId;
		this.pharmName = pharmName;
		this.address = address;
		this.phone = phone;
	}
	/**
	 * @param patientId
	 * @param pharmName
	 * @param address
	 * @param phone
	 */
	public Pharmacies(int patientId, String pharmName, String address, String phone) {
		super();
		this.patientId = patientId;
		this.pharmName = pharmName;
		this.address = address;
		this.phone = phone;
	}
	public int getPharmId() {
		return pharmId;
	}
	public void setPharmId(int pharmId) {
		this.pharmId = pharmId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPharmName() {
		return pharmName;
	}
	public void setPharmName(String pharmName) {
		this.pharmName = pharmName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
