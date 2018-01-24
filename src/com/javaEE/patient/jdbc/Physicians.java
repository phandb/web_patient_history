package com.javaEE.patient.jdbc;

public class Physicians {
	private int physId;
	private String physName;
	private String physSpecialty;
	private String physAddress;
	private String physPhone;
	/**
	 * @param physId
	 * @param physName
	 * @param physSpecialty
	 * @param physAddress
	 * @param physPhone
	 */
	public Physicians(int physId, String physName, String physSpecialty, String physAddress, String physPhone) {
		super();
		this.physId = physId;
		this.physName = physName;
		this.physSpecialty = physSpecialty;
		this.physAddress = physAddress;
		this.physPhone = physPhone;
	}
	/**
	 * @param physName
	 * @param physSpecialty
	 * @param physAddress
	 * @param physPhone
	 */
	public Physicians(String physName, String physSpecialty, String physAddress, String physPhone) {
		super();
		this.physName = physName;
		this.physSpecialty = physSpecialty;
		this.physAddress = physAddress;
		this.physPhone = physPhone;
	}
	public int getPhysId() {
		return physId;
	}
	public void setPhysId(int physId) {
		this.physId = physId;
	}
	public String getPhysName() {
		return physName;
	}
	public void setPhysName(String physName) {
		this.physName = physName;
	}
	public String getPhysSpecialty() {
		return physSpecialty;
	}
	public void setPhysSpecialty(String physSpecialty) {
		this.physSpecialty = physSpecialty;
	}
	public String getPhysAddress() {
		return physAddress;
	}
	public void setPhysAddress(String physAddress) {
		this.physAddress = physAddress;
	}
	public String getPhysPhone() {
		return physPhone;
	}
	public void setPhysPhone(String physPhone) {
		this.physPhone = physPhone;
	}
}
