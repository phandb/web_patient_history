<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>

<html>
<head>
	<title>View Patient</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-patient-style.css">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div id ="wrapper">
		<div id="header">
			<h2>Patient Medical History</h2>
		</div>
	
	
	<div id="container">
	
		<h3>Patient: ${THE_PATIENT.firstName } ${THE_PATIENT.middleName } ${THE_PATIENT.lastName } </h3>
		<h4>List of Medications</h5>
		
			<table >
				<tr>
					<th>Prescription Name</th>
					<th>Strength</th>
					<th>Dosage</th>
					<th>Action</th>
					
				</tr>
				
				<c:forEach var="tempPrescription" items="${PRESCRIPTION_LIST}">
					<tr>
					
					<!-- set up an update link for each patient--->
					<c:url var ="updateLink" value = "PrescriptionControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="patientId" value="${tempPrescription.presId}" />
					</c:url>
					
					<!-- set up a view link for each patient--->
					<c:url var ="viewLink" value = "PrescriptionControllerServlet">
						<c:param name="command" value="UPDATE_PRES"/>
						<c:param name="patientId" value="${tempPrescription.presId}" />
					</c:url>
					
					<!-- set up a link to delete a patient -->
					<c:url var ="deleteLink" value = "PrescriptionControllerServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="patientId" value="${tempPrescription.presId}" />
					</c:url>
					
						<td> ${tempPrescription.presName} </td>
						<td> ${tempPrescription.presStrength} </td>
						<td> ${tempPrescription.presDosage} </td>
						
						<td> 
							<a href = "${updateLink}">Update</a>|
							<a href = "${viewLink}">View</a> |
							<a href = "${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this patient?'))) return false">
							Delete</a>
						 </td>
					</tr>
				</c:forEach>
			</table>
			<div>
		<!-- Add new button: Add Patient -->
			<input type="button" value = "Add Prescription"
					onclick="window.location.href='add-patient-form.jsp'; return false;"
					class="add-patient-button"/>  <!-- -Style -->
			</div>
		<div style="clear:both;"></div>
		<p> <a href = "PatientControllerServlet">Back to the List</a></p>
	</div>
	
</div>


</body>


</html>