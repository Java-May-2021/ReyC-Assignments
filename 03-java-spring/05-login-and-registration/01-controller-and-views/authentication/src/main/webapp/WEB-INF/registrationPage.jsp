<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" 
    	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
    	integrity="undefined" 
    	crossorigin="anonymous">
    <title>Registration Page</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col-10">
				<h1>Register!</h1>
    
			    <p><form:errors path="user.*"/></p>
			    
			    <form:form method="POST" action="/registration" modelAttribute="user">
			        <div class="row mb-4">
			        	<form:label class="col-4 col-form-label" path="email">Email:</form:label>
			            <div class="col-8">
			            	<form:input type="email" class="form-control" path="email"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:label class="col-4 col-form-label" path="password">Password:</form:label>
			            <div class="col-8">
			            	<form:password class="form-control" path="password"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:label class="col-4 col-form-label" path="passwordConfirmation">Password Confirmation:</form:label>
			            <div class="col-8">
			            	<form:password class="form-control" path="passwordConfirmation"/>
			            </div>
			        </div>
			         <div class="text-end">
				    	<input type="submit" class="btn btn-success" value="Register!"/>
				    </div>
			    </form:form>
			</div>
		</div>
	</div>
</body>
</html>