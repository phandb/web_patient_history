
package com.javaEE.patient.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class PatientDbUtil {
	private DataSource dataSource;
	
	public PatientDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Patient> getPatients() throws Exception {
		//Create a list of patient
		List<Patient> patients = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		//get connection to database
		myConn = dataSource.getConnection();
		
		//create sql statement
		String sql = "SELECT * "
				+ 	" FROM patients "
				+ 	"ORDER BY last_name";
		myStmt = myConn.createStatement();
		
		//execute query
		myRs = myStmt.executeQuery(sql);
		
		//process the result set
		while (myRs.next()) {
			
			//retrieve data from result set row.  Actually get data from table column
			int id = myRs.getInt("patient_id");
			String firstName = myRs.getString("first_name");
			String middleName = myRs.getString("middle_name");
			String lastName = myRs.getString("last_name");
			String address = myRs.getString("address");
			String gender = myRs.getString("gender");
			String birthDate = myRs.getString("date_of_birth");
			
			//create new patient object
			Patient tempPatient = new Patient(id, firstName, middleName, lastName,address, gender, birthDate);
			
			//add it to the list of patients
			patients.add(tempPatient);
		}
		
			return patients;
		}
		finally {
			//close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
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
	
	public void addPatient(Patient thePatient) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
		//get db connection
			myConn = dataSource.getConnection();
			
		// create sql for student
			String sql = "INSERT INTO patients " // need a white space at the end for concatenation
						+	"(first_name, middle_name, last_name, address, gender, date_of_birth) " // need a white space at the end for concatenation
						+ "VALUES (?, ?, ?, ?, ?, ?)";
			 
			myStmt = myConn.prepareStatement(sql);
			
		//set the parameter values for the student
			myStmt.setString(1, thePatient.getFirstName());
			myStmt.setString(2, thePatient.getMiddleName());
			myStmt.setString(3, thePatient.getLastName());
			myStmt.setString(4, thePatient.getAddress());
			myStmt.setString(5, thePatient.getGender());
			myStmt.setString(6, thePatient.getBirthDate());
			
		//execute sql insert
			myStmt.execute();
		}
		finally {
		//clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Patient getPatient(String thePatientId) throws Exception{
		Patient thePatient = null;
		
		Connection myConn = null;
		PreparedStatement  myStmt = null;
		ResultSet myRs = null;
		int patientId;
		try {
			//convert student id to int
			patientId = Integer.parseInt(thePatientId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to get selected patient
			String sql = "SELECT * FROM patients WHERE patient_id=?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, patientId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result set row
			if (myRs.next()){
				String firstName = myRs.getString("first_name");
				String middleName = myRs.getString("middle_name");
				String lastName = myRs.getString("last_name");
				String address = myRs.getString("address");
				String gender = myRs.getString("gender");
				String birthDate = myRs.getString("date_of_birth");
				
				//create new patient object
				thePatient = new Patient(patientId, firstName, middleName, lastName, address,  gender, birthDate);
			}
			else {
				throw new Exception("Could not find patient id: "+ patientId);
			}
		
		return thePatient;
		}
		finally {
			//clean up database connection
			close(myConn, myStmt, myRs);
		}
	}

	public void updatePatient(Patient thePatient) throws Exception {

		
		Connection myConn = null;
		PreparedStatement  myStmt = null;
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "UPDATE patients " // need a white space at the end for concatenation
						+ "SET first_name=?, middle_name=?, last_name=?, address =?, gender=?, date_of_birth=? " // need a white space at the end for concatenation
						+ "WHERE patient_id=?";
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set parameters associated with the "?" in the sql statement
			myStmt.setString(1, thePatient.getFirstName());
			myStmt.setString(2, thePatient.getMiddleName());
			myStmt.setString(3, thePatient.getLastName());
			myStmt.setString(4, thePatient.getAddress());
			myStmt.setString(5, thePatient.getGender());
			myStmt.setString(6, thePatient.getBirthDate());
			myStmt.setInt(7, thePatient.getId());
			
			//execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public void deletePatient(String thePatientId) throws Exception {
		Connection myConn = null;
		PreparedStatement  myStmt = null;
		try {
			// convert student id to int
			int patientId = Integer.parseInt(thePatientId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql delete statement
			String sql = "DELETE FROM patients WHERE patient_id=?";
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, patientId);
						
			//execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}

		
	}

	
}
