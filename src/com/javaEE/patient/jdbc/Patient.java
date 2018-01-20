
package com.javaEE.patient.jdbc;

public class Patient {
	private int id;
	private int address_id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String gender;
	private String birthDate;
	/**
	 * @param id
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param gender
	 * @param birthDate
	 */
	public Patient(int id, String firstName, String middleName, String lastName,String address, String gender, String birthDate) {
		//super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param address
	 * @param gender
	 * @param birthDate
	 */
	public Patient(String firstName, String middleName, String lastName, String address, String gender, String birthDate) {
		//super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAddress_id() {
		return address_id;
	}
	
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "Patients [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", gender=" + gender + ", birthDate=" + birthDate + "]";
	}
	
	
	

}
