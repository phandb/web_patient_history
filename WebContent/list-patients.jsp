<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
	<title>Patient Tracker App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<!-- link type="text/css" rel="stylesheet" href="css/add-patient-style.css"-->
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
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add new button: Add Patient -->
			<input type="button" value = "Add Patient"
					onclick="window.location.href='add-patient-form.jsp'; return false;"
					class="add-patient-button"/>  <!-- -Style -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					
					<th>Action</th>
					
				</tr>
				
				<c:forEach var="tempPatient" items="${PATIENT_LIST}">
					<tr>
					<!-- set up a link for each patient--->
					<c:url var ="updateLink" value = "PatientControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>
					
					<!-- set up a link to delete a patient -->
					<c:url var ="deleteLink" value = "PatientControllerServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>
						<td> ${tempPatient.firstName} </td>
						<td> ${tempPatient.middleName} </td>
						<td> ${tempPatient.lastName} </td>
						
						<td> 
							<a href = "${updateLink}">Update</a>
							|
							<a href = "${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this patient?'))) return false">
							Delete</a>
						 </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
	</div>

</body>

</html>