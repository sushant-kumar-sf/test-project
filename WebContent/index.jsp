<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File uploading</title>
</head>
<body>
<h2>File uploading example form :-</h2>
	<form action="form_submission" method="post" enctype="multipart/form-data">
		<label for="sushant_File">Choose your file to upload</label>
		<input type="file" name="sushant_File" /><br>
		
		<label for="first_name">Enter your First name</label>
		<input type="text" name="first_name" /><br>
		
		<label for="last_name">Enter your last name</label>
		<input type="text" name="last_name" /><br>
		<input type="submit" value="submit"/>
		
	</form>

</body>
</html>