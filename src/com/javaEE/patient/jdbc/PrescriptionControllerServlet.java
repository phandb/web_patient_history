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
	public String selectedPatientId;
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
				theCommand = "VIEW";
			}
			//otherwise route to the appropriate command
			
			switch(theCommand) {
			case "VIEW" :
				listPrescriptions(request, response);
				break;
			case "LOAD":
				loadPresciptions(request, response);
				break;
			case "UPDATE":
				updatePrescriptions(request, response);
				break;
			case "DELETE":
				deletePrescriptions(request, response);
				break;
			default:
				listPrescriptions(request, response);
			}
		//list the prescription in MVC fashion
		listPrescriptions(request, response);
		
		}catch (Exception e){
			throw new ServletException(e);
		}
		
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			//read the command ADD parameter
			String theCommand = request.getParameter("command");
			
			//otherwise route to the appropriate method
			switch(theCommand) {
			case "ADD":
			// call addPrescription method to handle prescription parameters
				addPrescription(request, response);
				break;
			default:
				listPrescriptions(request, response);
			}
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}
		
	

	private void addPrescription(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read data from add-prescription form for specified patient
		//use request.getParameter(String s) to read data form
		//Make sure patient ID is included
		String presName = request.getParameter("presName");
		String presStrength = request.getParameter("presStrength");
		String presDosage = request.getParameter("presDosage");
		int patient_id = Integer.parseInt(request.getParameter("patient_Id"));
		
		//create new prescription object
		Prescriptions thePrescription = new Prescriptions(patient_id, presName, presStrength, presDosage);
		
		//Now add new prescription to database by invoking a method on prescriptionDbUtil
		prescriptionDbUtil.addPrescription(thePrescription);
		
		//send back Redirect to avoid multiple-browser load issue
		//send to controller with command VIEW
		response.sendRedirect(request.getContextPath() + "/PrescriptionControllerServlet?command=VIEW");
		
	}

	private void deletePrescriptions(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read the prescription id from the form data
		String thePrescriptionId = request.getParameter("presId");
				
		//delete prescreiption from the database
		prescriptionDbUtil.deletePrescription(thePrescriptionId);
				
		//send them back to the list of prescription page
		listPrescriptions(request, response);
		
	}

	private void updatePrescriptions(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//this method is trigger by update button in prescription update form
		// read prescription info from the form data
		int patient_id = Integer.parseInt(request.getParameter("patientId"));
		int pres_id = Integer.parseInt(request.getParameter("presId"));
		String presName = request.getParameter("presName");
		String presStrength = request.getParameter("presStrength");
		String presDosage = request.getParameter("presDosage");
		
				
		//Create new prescription object
		Prescriptions thePrescription = new Prescriptions(patient_id, pres_id, presName, presStrength, presDosage);
				
		//perform update on the database
		prescriptionDbUtil.updatePrescription(thePrescription);
				
		//send back to list patient page
		listPrescriptions(request, response);
				
		
	}

	private void loadPresciptions(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//read prescription id from form data
		String thePrescriptionId = request.getParameter("prescriptionId");
		String selectedPatientId = request.getParameter("selectedPatientId");
				
		// get prescription from db util
		Prescriptions thePrescription = prescriptionDbUtil.getPrescription(thePrescriptionId, selectedPatientId);
				
		//place prescription in the request attribute
		request.setAttribute("THE_PRESCRIPTION",thePrescription);
				
		//sent to jsp page: update-prescription-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-prescription-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listPrescriptions(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//read patient id from form data
		String selectedPatientId = request.getParameter("patientId");
		this.selectedPatientId=selectedPatientId;
		//get prescription from db util
		List<Prescriptions> prescriptions = prescriptionDbUtil.getPrescriptionList(selectedPatientId);
		//Patient selectedPatient = new Patient();
		
		//add prescription to the request
		request.setAttribute("PRESCRIPTION_LIST",  prescriptions);
		//request.session.setAttribute("PRESCRIPTION_LIST", prescriptions);
		//String selectedFirstName = (String)request.getSession().getAttribute("SELECTED_PATIENT");
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-patient-form.jsp");
		dispatcher.forward(request, response);
		
	}

}
