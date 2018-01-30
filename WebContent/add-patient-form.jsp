<!DOCTYPE html>

<html>
<head>
	<title>Add New Patient</title>
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
			<h2>Patient Medical Management</h2>
		</div>
	
	
	<div id="container">
		<h3>Add Patient</h3>
		<form class ="form-horizontal" action="PatientControllerServlet" method="POST">
			<input type="hidden" name="command" value="ADD" />
			<div class="form-group">
			    <label for="inputFirstName" class="control-label col-sm-2">First Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="firstName"  class="form-control" id="inputFirstName" placeholder="First Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputMiddleName" class="control-label col-sm-2">Middle Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="middleName"  class="form-control" id="inputMiddleName" placeholder="Middle Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputLastName" class="control-label col-sm-2">Last Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="lastName"  class="form-control" id="inputLastName" placeholder="Last Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputAddress" class="control-label col-sm-2">Address</label>
			    <div class="col-sm-4">
			      <input type="text" name ="address"  class="form-control" id="inputAddress" placeholder="Address">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputGender" class="control-label col-sm-2">Gender</label>
			    <div class="col-sm-1">
			      <input type="text" name ="gender"  class="form-control" id="inputGender" placeholder="Gender">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputDOB" class="control-label col-sm-2">DOB</label>
			    <div class="col-sm-1">
			      <input type="text" name ="birthDate"  class="form-control" id="inputDOB" placeholder="2018-01-20">
			    </div>
			  </div>
			  
			  <!-- div class="form-group">
			      <label for="inputGender" class="col-sm-2">Gender</label>
			      <div class="col-sm-6">
				      <select id="inputGender" class="custom-select custom-select-lg col-sm-2" name ="gender" >
				        <option selected>Male</option>
				        <option>Female</option>
				      </select>
				      
			      </div-->
			   
				
				
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-6">
			      <button type="submit" class="btn btn-outline-primary btn-lg">Add</button>
			    </div>
			  </div>

		</form>
		<div style="clear:both;"></div>
		<p> <a href = "PatientControllerServlet">Back to the List</a></p>
	</div>
	
	</div>


</body>


</html>