package com.javaEE.patient.jdbc;

import java.util.List;

public class Prescriptions {
	private int presId;
	private int patientId;
	private String presName;
	private String presStrength;
	private String presDosage;
	private String patientName;
	/**
	 * @param presId
	 * @param patientId
	 * @param presName
	 * @param presStrength
	 * @param presDosage
	 */
	public Prescriptions(int presId, int patientId, String patientName, String presName, String presStrength, String presDosage) {
		//super();
		this.presId = presId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.presName = presName;
		this.presStrength = presStrength;
		this.presDosage = presDosage;
	}
	/**
	 * @param patientId
	 * @param presName
	 * @param presStrength
	 * @param presDosage
	 */
	public Prescriptions(int patientId, String patientName, String presName, String presStrength, String presDosage) {
		//super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.presName = presName;
		this.presStrength = presStrength;
		this.presDosage = presDosage;
		
	}
	
	
	/**
	 * @param presId
	 * @param presName
	 * @param presStrength
	 * @param presDosage
	 */
	public Prescriptions(int patientId, int presId, String presName, String presStrength, String presDosage) {
		//super();
		this.patientId = patientId;
		this.presId = presId;
		this.presName = presName;
		this.presStrength = presStrength;
		this.presDosage = presDosage;
	}
	
	/**
	 * @param presName
	 * @param presStrength
	 * @param presDosage
	 */
	public Prescriptions(int patientId, String presName, String presStrength, String presDosage) {
		//super();
		this.presName = presName;
		this.presStrength = presStrength;
		this.presDosage = presDosage;
	}
	public int getPresId() {
		return presId;
	}
	public void setPresId(int presId) {
		this.presId = presId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPresName() {
		return presName;
	}
	public void setPresName(String presName) {
		this.presName = presName;
	}
	public String getPresStrength() {
		return presStrength;
	}
	public void setPresStrength(String presStrength) {
		this.presStrength = presStrength;
	}
	public String getPresDosage() {
		return presDosage;
	}
	public void setPresDosage(String presDosage) {
		this.presDosage = presDosage;
	}
	
	
}
