<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
    <title>New Student</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col-8">
				<h1 class="mb-4">New Student</h1>
				<form:form action="/students/new" method="POST" modelAttribute="student">
					<div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="firstName">First Name:</form:label>
				        <form:errors path="firstName"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="firstName"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="lastName">Last Name:</form:label>
				        <form:errors path="lastName"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="lastName"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="age">Age:</form:label>
				        <form:errors path="age"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="age"/>
				        </div>
				    </div>
				    <div class="text-end">
				    	<button class="btn btn-primary">Add Student</button>
				    </div>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>