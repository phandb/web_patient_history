package com.javaEE.patient.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PrescriptionDbUtil {
private  DataSource dataSource;
	
	public PrescriptionDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	
	public List<Prescriptions> getPrescription(String thePatientId) throws Exception {
		//Create a list of Prescription
		List<Prescriptions> prescriptions = new ArrayList();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int patientId;
		int patient_id;
		try {
			//convert student id to int
			patientId = Integer.parseInt(thePatientId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql statement
			String sql = "SELECT *   "
							+ " FROM medications "
							+ " INNER JOIN patients "
							+ " ON (medications.patient_id = patients.patient_id) ";
			//medications.patient_id, medication_name, strength, dosage
			
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			 // myStmt.setInt(1, patientId);
								
			//execute statement
			 
			myRs = myStmt.executeQuery(sql);
			
			//retrieve data from result set row
			while (myRs.next()){
				//patient_id = myRs.getInt("medications.patient_id");
				if (patientId==myRs.getInt("medications.patient_id")) {
					String presName = myRs.getString("medication_name");
					String presStrength = myRs.getString("strength");
					String presDosage = myRs.getString("dosage");
					String patient_Name = (myRs.getString("patients.first_name")+" "+
										myRs.getString("patients.middle_name")+" " +
										myRs.getString("patients.last_name"));
					
					//create new prescription object
					Prescriptions tempPrescription = new Prescriptions(patientId, patient_Name, presName, presStrength, presDosage);
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
	


}
