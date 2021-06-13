<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" 
    	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
    	integrity="undefined" 
    	crossorigin="anonymous">
    <title>People and Licenses</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col">
				<h1 class="mb-4">${person.firstName} ${person.lastName}</h1>
				<p>License Number: ${person.license.getNumberAsString()}</p>
				<p>State: ${person.license.getState()}</p>
				<p>Expiration Date: ${person.license.getExpirationDateFormatted()}</p>
			</div>
		</div>
	</div>
</body>
</html>