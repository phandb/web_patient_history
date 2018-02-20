<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
	String stringPatientId = (String)request.getAttribute("SelectedPatientId");
%>
<!DOCTYPE html>

<html>
<head>
	<title>Add New Prescription</title>
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
		<h3>Add Prescription</h3>
		
		<form class ="form-horizontal" action="PrescriptionControllerServlet" method="POST">
			<input type="hidden" name="command" value="ADD" />
			<input type="hidden" name="presId" value="${THE_PRESCRIPTION.presId }" />
			<input type="hidden" name="patientId" value="${THE_PRESCRIPTION.patientId }" />
			
			
			<div class="form-group">
			
			    <label for="inputPresName" class="control-label col-sm-2">Prescription Name</label>
			    <div class="col-sm-4">
			      <input type="text" name ="presName"  class="form-control" id="inputPresName" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputStrength" class="control-label col-sm-2">Strength</label>
			    <div class="col-sm-4">
			      <input type="text" name ="presStrength"  class="form-control" id="inputStrength" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPresDosage" class="control-label col-sm-2">Dosage</label>
			    <div class="col-sm-4">
			      <input type="text" name ="presDosage"  class="form-control" id="inputPresDosage" >
			    </div>
			  </div>
			  <!-- - 
			  <div class="form-group">
			    <label for="inputPatientId" class="control-label col-sm-2">Patient ID</label>
			    <div class="col-sm-4">
			    
			      <input type="text" name ="patient_Id" value="${stringPatientId}"   class="form-control" id="inputPatientId">
			    </div>   
			  </div>
			  
			   -->
			   
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
		<p> <a href = "view-patient-form.jsp">Back to the List</a></p>
	</div>
	
	</div>


</body>


</html>