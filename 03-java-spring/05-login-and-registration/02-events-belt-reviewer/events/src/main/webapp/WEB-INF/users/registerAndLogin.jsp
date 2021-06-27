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
    <title>Registration and Login Page</title>
</head>
<body>
	<div class="container-fluid d-flex vh-100 justify-content-center align-items-center">
		<div class="row justify-content-between">
			<div class="col-12">
				<h1 class="mb-5">Welcome!</h1>	
			</div>
			<div class="col-6 border rounded p-3">
				<h1 class="mb-2">Register</h1>
			    <form:form method="POST" action="/register" modelAttribute="user">
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="firstName"/>
			        	<form:label class="col-4 col-form-label" path="firstName">First Name</form:label>
			            <div class="col-8">
			            	<form:input class="form-control" path="firstName"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="lastName"/>
			        	<form:label class="col-4 col-form-label" path="lastName">Last Name</form:label>
			            <div class="col-8">
			            	<form:input class="form-control" path="lastName"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="email"/>
			        	<form:label class="col-4 col-form-label" path="email">Email</form:label>
			            <div class="col-8">
			            	<form:input type="email" class="form-control" path="email"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="city"/>
			        	<form:label class="col-4 col-form-label" path="city">Location</form:label>
			            <div class="col-8">
			            	<div class="row">
				            	<div class="col-9">
				            		<form:input class="form-control" path="city"/>
				            	</div>
				            	<div class="col-3">
					            	<form:select class="form-control" path="state">
					            		<c:forEach items="${ states }" var="state">
											<form:option value="${ state }">${state}</form:option>
										</c:forEach>
					            	</form:select>
					            </div>
				            </div>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="password"/>
			        	<form:label class="col-4 col-form-label" path="password">Password</form:label>
			            <div class="col-8">
			            	<form:password class="form-control" path="password"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="passwordConfirmation"/>
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
			<div class="col-5 h-50 border rounded  p-3">
				<h1 class="mb-2">Login</h1>
    
			    <p class="text-danger"><c:out value="${error}"/></p>
			    
			    <form method="POST" action="/login">
			        <div class="row mb-4">
			        	<label type="email" for="loginEmail" class="col-4 col-form-label">Email</label>
			            <div class="col-8">
			            	<input type="text" id="loginEmail" name="email" class="form-control"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			            <label for="loginPassword" class="col-4 col-form-label">Password</label>
			            <div class="col-8">
			            	<input type="password" id="loginPassword" name="password" class="form-control"/>
			            </div>
			        </div>
			        <div class="text-end">
				    	<input type="submit" class="btn btn-success" value="Login!"/>
				    </div>
			    </form>
			</div>
		</div>
	</div>
</body>
</html>