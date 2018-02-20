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
		<!-- div id="header"-->
			<div class="container">
				<div class="row">
					<div class="col"></div>
					
					<div id="header" class="col-5"><h2>Patient Medical Management</h2></div>
					<div class="col"></div>
				</div>
			</div>
		<!-- /div-->
	
	
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col-5">
			<c:set var="selectedPatient" value="${PRESCRIPTION_LIST.get(0)}" scope="session"></c:set>
			<h4>Patient:  ${selectedPatient.patientName }</h4>	
			<!-- h4>patient_ID: ${selectedPatient.patientId }</h4  --->
			<c:choose>
			<c:when test="${selectedPatient = null }">
				<h4>No prescription for this patient</h4>
			</c:when >
			<c:otherwise >
				
			<div>
		<!-- Add new button: Add Prescription -->
			<input type="button" value = "Add Prescription" 
					onclick="window.location.href='add-prescription-form.jsp'; return false;"
					class="add-patient-button"/>  <!-- -Style -->
			</div>
				
			<h4>List of Medications </h4>
			<table class="table table-sm table-bordered table-striped">
				<tr>
					<!-- h scope="col">Patient ID</th>
					<th scope="col">Pres ID</th  --->
					<th scope="col">Prescription Name</th>
					<th scope="col">Strength</th>
					<th scope="col">Dosage</th>
					<th scope="col">Action</th>
					
				</tr>
				
				<c:forEach var="tempPrescription" items="${PRESCRIPTION_LIST}">
				<tbody>
					<tr>
					
						<!-- set up an update link for each prescription--->
						<c:url var ="updateLink" value = "PrescriptionControllerServlet">
							<c:param name="command" value="LOAD"/>
							<c:param name="prescriptionId" value="${tempPrescription.presId}" />
							<c:param name="selectedPatientId" value="${tempPrescription.patientId}"/>
						</c:url>
						
						<!-- set up a view link for each prescription--->
						<c:url var ="viewLink" value = "PrescriptionControllerServlet">
							<c:param name="command" value="UPDATE"/>
							<c:param name="prescriptionId" value="${tempPrescription.presId}" />
							<c:param name="selectedPatientId" value="${tempPrescription.patientId}"/>
						</c:url>
						
						<!-- set up a link to delete a prescription -->
						<c:url var ="deleteLink" value = "PrescriptionControllerServlet">
							<c:param name="command" value="DELETE"/>
							<c:param name="prescriptionId" value="${tempPrescription.presId}" />
							<c:param name="selectedPatientId" value="${tempPrescription.patientId}"/>
						</c:url>
						<!-- - 
							<td> ${tempPrescription.patientId} </td>
							<td> ${tempPrescription.presId} </td>  
							-->
							<td> ${tempPrescription.presName} </td>
							<td> ${tempPrescription.presStrength} </td>
							<td> ${tempPrescription.presDosage} </td>
							
							<td> 
								<a href = "${updateLink}">Update</a>|
								<a href = "${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this medication?'))) return false">
								Delete</a>
							 </td>
					</tr>
					</tbody>
					
				</c:forEach>
			</table>
			</c:otherwise>
			</c:choose>
			
			
		<!-- -End of prescription table--------->
		
		<div style="clear:both;"></div>
		<p> <a href = "PatientControllerServlet">Back to Patient List</a></p>
			</div>
			<div class="col"></div>
		
			
		</div>
	</div>
</div>


</body>


</html>