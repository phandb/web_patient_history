<!DOCTYPE html>

<html>
<head>
	<title>Update Prescription</title>
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
		<h3>Update Prescription</h3>
		<form class="form-horizontal" action="PrescriptionControllerServlet" method="GET">
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="presId" value="${THE_PRESCRIPTION.presId }" />
			<input type="hidden" name="patientId" value="${THE_PRESCRIPTION.patientId }" />
			
			
			  <div class="form-group">
			    <label for="inputPresName" class="col-sm-2 control-label">Prescription Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="presName" value ="${THE_PRESCRIPTION.presName }" class="form-control" id="inputPresName" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputStrength" class="col-sm-2 control-label">Strength</label>
			    <div class="col-sm-4">
			      <input type="text" name ="presStrength" value ="${THE_PRESCRIPTION.presStrength }" class="form-control" id="inputStrength" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputDosage" class="col-sm-2 control-label">Dosage</label>
			    <div class="col-sm-4">
			      <input type="text" name ="presDosage" value ="${THE_PRESCRIPTION.presDosage }" class="form-control" id="inputDosage" >
			    </div>
			  </div>
			  
			  
				
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-6">
			      <button type="submit" class="btn btn-outline-primary btn-lg">Update</button>
			    </div>
			  </div>
			  
			

		</form>
		<div style="clear:both;"></div>
		<p> <a href = "PrescriptionControllerServlet">Back to the List</a></p>
	</div>
	
</div>


</body>


</html>