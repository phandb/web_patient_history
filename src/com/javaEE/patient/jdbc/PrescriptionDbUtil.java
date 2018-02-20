package com.javaEE.patient.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PrescriptionDbUtil {
	private  DataSource dataSource;
	public int patientId;
	public PrescriptionDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
/***********************************************************************************************/	
	public List<Prescriptions> getPrescriptionList(String thePatientId) throws Exception {
		
		//Create a list of Prescription
		List<Prescriptions> prescriptions = new ArrayList();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int patientId;
		//int patient_id;
		try {
			
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql statement that load all medications for all patients
			String sql = "SELECT *   "
							+ " FROM medications "
							+ " INNER JOIN patients "
							+ " ON (medications.patient_id = patients.patient_id) ";
					
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			
			//execute statement
			 
			myRs = myStmt.executeQuery(sql);
			
			//retrieve data from result set row
			//convert patient id to int
			patientId = Integer.parseInt(thePatientId);
			this.patientId = patientId;
			while (myRs.next()){
				//Get medications for selected patient only
				if (patientId==myRs.getInt("medications.patient_id")) {
					int presId = myRs.getInt("medication_id");
					String presName = myRs.getString("medication_name");
					String presStrength = myRs.getString("strength");
					String presDosage = myRs.getString("dosage");
					String patient_Name = (myRs.getString("patients.first_name")+" "+
										myRs.getString("patients.middle_name")+" " +
										myRs.getString("patients.last_name"));
					
					//create new prescription object
					Prescriptions tempPrescription = new Prescriptions(presId, patientId,  patient_Name, presName, presStrength, presDosage);
					
					// Add it to the list of prescription
					prescriptions.add(tempPrescription);
				}
			}
			 
			
				//throw new Exception("No Prescription for patient: "+ patientId);
				 return prescriptions;
			
		}
		finally {
			//clean up database connection
			close(myConn, myStmt, myRs);
		}
	}
/*********************************************************************************/
	private  void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs !=null) {
				myRs.close();
			}
			if (myStmt !=null) {
				myStmt.close();
			}
			if (myConn !=null) {
				myConn.close(); //does not really close it.  Just put back in connection pool
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}

/************************************************************************************/
	public void deleteSelectedPrescription(String thePrescriptionId) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			//convert string prescription id to int
			int pres_id = Integer.parseInt(thePrescriptionId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//Create SQL delete statement
			String sql = "DELETE FROM medications WHERE medication_id = ?";
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set parameter for place holder
			myStmt.setInt(1, pres_id);
			
			//execute SQL statement
			myStmt.execute();
			
			
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

/*************************************************************************************/
	public void addPrescription(Prescriptions thePrescription) throws Exception{
		Connection myConn = null;
		PreparedStatement  myStmt = null;
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create SQL insert statement
			String sql = "INSERT INTO medications "
					+ "(medication_name, strength, dosage, patient_id) "
					+ "VALUES (?, ?, ?, ?)";
			
		      
			
			myStmt = myConn.prepareStatement(sql);
			
			//set parameter values for the prescription
			myStmt.setString(1, thePrescription.getPresName());
			myStmt.setString(2, thePrescription.getPresStrength());
			myStmt.setString(3, thePrescription.getPresDosage());
			myStmt.setInt(4, thePrescription.getPatientId());
			
			//execute sql 
			myStmt.execute();
			
		}
		finally {
			//clean up JDBC object
			close(myConn, myStmt, null);
		}
		
	}

/***************************************************************************************************************/
	public Prescriptions getPrescription(String thePrescriptionId, String selectedPatientId) throws Exception {
		//This method to load or get specific prescription data for update 
		//Define a prescription object
		Prescriptions thePrescription = null;
		
		//Connection to database parameters
		Connection myConn = null;
		PreparedStatement  myStmt = null;
		ResultSet myRs = null;
		int prescriptionId;
		int patientId;
		
		try {
			//convert student id to int
			prescriptionId = Integer.parseInt(thePrescriptionId);
			patientId = Integer.parseInt(selectedPatientId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to get selected patient
			String sql = "SELECT * FROM medications WHERE medication_id=? AND patient_id=?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, prescriptionId);
			myStmt.setInt(2, patientId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result set row
			if (myRs.next()){
				String presName = myRs.getString("medication_name");
				String presStrength = myRs.getString("strength");
				String presDosage = myRs.getString("dosage");
				int patient_id = Integer.parseInt(myRs.getString("patient_id"));
				int pres_id = Integer.parseInt(myRs.getString("medication_id"));
				
				//create new patient object
				thePrescription = new Prescriptions(patient_id, pres_id,presName, presStrength, presDosage);
			}
			else {
				throw new Exception("Could not find prescription id: "+ prescriptionId);
			}
		
		return thePrescription;
		}
		finally {
			//clean up database connection
			close(myConn, myStmt, myRs);
		}
	}

/***************************************************************************************************/
	public void updatePrescription(Prescriptions thePrescription) throws Exception {
		//This method will update specific medication respect to data from the update prescription form

		Connection myConn = null;
		PreparedStatement  myStmt = null;
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "UPDATE medications " // need a white space at the end for concatenation
						+ " SET medication_name=?, strength=?, dosage=? " // need a white space at the end for concatenation
						+ " WHERE medication_id = ? AND patient_id=?";
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set parameters associated with the "?" in the sql statement
			myStmt.setString(1, thePrescription.getPresName());
			myStmt.setString(2, thePrescription.getPresStrength());
			myStmt.setString(3, thePrescription.getPresDosage());
			myStmt.setInt(4, thePrescription.getPresId());
			myStmt.setInt(5, thePrescription.getPatientId());
			
			//execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}
	
/*********************************************************************************************/

}
