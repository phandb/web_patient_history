<!DOCTYPE html>

<html>
<head>
	<title>Update Patient</title>
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
	</div>
	
	<div id="container">
		<h3>Update Patient</h3>
		<form action="PatientControllerServlet" method="GET">
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="patientId" value="${THE_PATIENT.id }" />
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName"
						value ="${THE_PATIENT.firstName }"/></td>
					</tr>
					<tr>
						<td><label>Middle Name:</label></td>
						<td><input type="text" name="middleName"
						value ="${THE_PATIENT.middleName }"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName"
						value ="${THE_PATIENT.lastName }"/></td>
					</tr>
					<tr>
						<td><label>Gender:</label></td>
						<td><input type="text" name="gender"
						value ="${THE_PATIENT.gender }"/></td>
					</tr>
					<tr>
						<td><label>DOB:</label></td>
						<td><input type="text" name="birthDate"
						value ="${THE_PATIENT.birthDate }"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>


		</form>
		<div style="clear:both;"></div>
		<p> <a href = "PatientControllerServlet">Back to the List</a></p>
		</div>
	
	</div>


</body>


</html>