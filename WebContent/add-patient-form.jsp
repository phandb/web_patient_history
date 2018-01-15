<!DOCTYPE html>

<html>
<head>
	<title>Add New Patient</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-patient-style.css">
</head>
<body>

<div id ="wrapper">
		<div id="header">
			<h2>Patient Medical History</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Patient</h3>
		<form action="PatientControllerServlet" method="POST">
			<input type="hidden" name="command" value="ADD" />
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName"/></td>
					</tr>
					<tr>
						<td><label>Middle Name:</label></td>
						<td><input type="text" name="middleName"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName"/></td>
					</tr>
					<tr>
						<td><label>Gender:</label></td>
						<td><input type="text" name="gender"/></td>
					</tr>
					<tr>
						<td><label>DOB:</label></td>
						<td><input type="text" name="date_of_birth"/></td>
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