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
    <title>New Contact</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col-8">
				<h1 class="mb-4">New Contact</h1>
				<form:form action="/contacts/new" method="POST" modelAttribute="contact">
					<div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="student">Student:</form:label>
				        <form:errors path="student"/>
				        <div class="col-8">
				        	<form:select class="form-control" path="student">
				        		<c:forEach items="${students}" var="student">
				        			<form:option value="${student.id}">${student.firstName} ${student.lastName}</form:option>
				        		</c:forEach>
				        	</form:select>
				        </div>
				    </div>
					<div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="address">Address:</form:label>
				        <form:errors path="address"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="address"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="city">City:</form:label>
				        <form:errors path="city"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="city"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="state">State:</form:label>
				        <form:errors path="state"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="state"/>
				        </div>
				    </div>
				    <div class="text-end">
				    	<button class="btn btn-primary">Add Contact</button>
				    </div>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>