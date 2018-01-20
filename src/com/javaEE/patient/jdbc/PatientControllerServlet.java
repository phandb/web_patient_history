package com.javaEE.patient.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PatientControllerServlet
 */
@WebServlet("/PatientControllerServlet")
public class PatientControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PatientDbUtil patientDbUtil;
	
	@Resource(name="jdbc/web_patient_history")  //Must be the same name defined in context.xml 
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		//create our patient db util and pass in the connection pool/datasource
		try {
			patientDbUtil = new PatientDbUtil(dataSource);
			
		}catch (Exception e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//@Override doGet and doPost methods
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing patients
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			//otherwise route to the appropriate method
			switch(theCommand) {
			case "LIST":
				listPatients(request, response);
				break;
			case "LOAD":
				loadPatients(request, response);
				break;
			case "UPDATE":
				updatePatients(request, response);
				break;
			case "DELETE":
				deletePatients(request, response);
				break;
			default:
				listPatients(request, response);
			}
			//List the patient in MVC fashion
			listPatients(request, response);
			
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
	
	private void deletePatients(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read the patient id from the form data
		String thePatientId = request.getParameter("patientId");
		
		//delete patient from the database
		patientDbUtil.deletePatient(thePatientId);
		
		//send them back to the list patients page
		listPatients(request, response);
		
	}

	private void updatePatients(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read patient info from the form data
		int id = Integer.parseInt(request.getParameter("patientId"));
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthDate");
		
		//Create new patient object
		Patient thePatient = new Patient(id,firstName, middleName, lastName, address, gender, birthDate);
		
		//perform update on the database
		patientDbUtil.updatePatient(thePatient);
		
		//send back to list patient page
		listPatients(request, response);
		
	}

	private void loadPatients(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read patient id from form data
		String thePatientId = request.getParameter("patientId");
		
		// get patients from db util
		Patient thePatient = patientDbUtil.getPatient(thePatientId);
		
		//place patient in the request attribute
		request.setAttribute("THE_PATIENT",thePatient);
		
		//sent to jsp page: update-patient-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-patient-form.jsp");
		dispatcher.forward(request, response);
		
		
	}
	private void addPatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read patient info from form data
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthDate");
		
		//Create new patient object
		Patient thePatient = new Patient(firstName, middleName, lastName,address, gender, birthDate);
		
		//add the new patient to the database
		patientDbUtil.addPatient(thePatient);
		
		//send back to list patient page
		//send back Redirect to avoid multiple-browser reload issue
		response.sendRedirect(request.getContextPath() + "/PatientControllerServlet?command=LIST");
		//listPatients(request, response);
		
	}

	private void listPatients(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get patients from db util
		List<Patient> patients = patientDbUtil.getPatients();
		
		//add patients to the request
		request.setAttribute("PATIENT_LIST", patients);
		
		//send to JSP page view
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-patients.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			
			
			//otherwise route to the appropriate method
			switch(theCommand) {
			case "ADD":
				addPatient(request, response);
				break;
			
			default:
				listPatients(request, response);
			}
			
			
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	

}

