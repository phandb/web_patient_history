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
 * Servlet implementation class PrescriptionControllerServlet
 */
@WebServlet("/PrescriptionControllerServlet")
public class PrescriptionControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrescriptionDbUtil prescriptionDbUtil;
	
	@Resource(name="jdbc/web_patient_history")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		//create our patient db util and pass in the connection pool/datasource
		try {
			prescriptionDbUtil = new PrescriptionDbUtil(dataSource);
			
		}catch (Exception e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//read the command parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default the listing presciption
			if (theCommand ==null) {
				theCommand = "LIST";
			}
			//otherwise route to the appropriate command
			
			switch(theCommand) {
			case "VIEW" :
				listPrescriptions(request, response);
				break;
			}
		//list the prescription in MVC fashion
		listPrescriptions(request, response);
		
		}catch (Exception e){
			throw new ServletException(e);
		}
		
	}
		
		
		
		
	

	private void listPrescriptions(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//read patient id from form data
		String thePatientId = request.getParameter("patientId");

		//get prescription from db util
		List<Prescriptions> prescriptions = prescriptionDbUtil.getPrescription(thePatientId);
		//Patient selectedPatient = new Patient();
		
		//add prescription to the request
		request.setAttribute("PRESCRIPTION_LIST",  prescriptions);
		//String selectedFirstName = (String)request.getSession().getAttribute("SELECTED_PATIENT");
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-patient-form.jsp");
		dispatcher.forward(request, response);
		
	}

}
