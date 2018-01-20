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
	
	
	<div id="container">
		<h3>Update Patient</h3>
		<form class="form-horizontal" action="PatientControllerServlet" method="GET">
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="patientId" value="${THE_PATIENT.id }" />
			
			
			  <div class="form-group">
			    <label for="inputFirstName" class="col-sm-2 control-label">First Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="firstName" value ="${THE_PATIENT.firstName }" class="form-control" id="inputFirstName" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputMiddleName" class="col-sm-2 control-label">Middle Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="middleName" value ="${THE_PATIENT.middleName }" class="form-control" id="inputMiddleName" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputLastName" class="col-sm-2 control-label">Last Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="lastName" value ="${THE_PATIENT.lastName }" class="form-control" id="inputLastName" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputAddress" class="col-sm-2 control-label">Address</label>
			    <div class="col-sm-4">
			      <input type="text" name ="address" value ="${THE_PATIENT.address }" class="form-control" id="inputAddress" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputGender" class="col-sm-2 control-label">Gender</label>
			    <div class="col-sm-1">
			      <input type="text" name ="gender" value ="${THE_PATIENT.gender }" class="form-control" id="inputGender" >
			    </div>
			  </div>
			  
				
				<div class="form-group">
			    <label for="inputDOB" class="col-sm-2 control-label">DOB</label>
			    <div class="col-sm-1">
			      <input type="text" name ="birthDate" value ="${THE_PATIENT.birthDate }" class="form-control" id="inputDOB" >
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-6">
			      <button type="submit" class="btn btn-outline-primary btn-lg">Update</button>
			    </div>
			  </div>
			  
			

		</form>
		<div style="clear:both;"></div>
		<p> <a href = "PatientControllerServlet">Back to the List</a></p>
	</div>
	
</div>


</body>


</html>