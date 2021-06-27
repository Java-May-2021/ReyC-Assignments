<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
  
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
    <title>Events</title>
</head>
<body>
	<div class="container-fluid d-flex vh-100 justify-content-center align-items-center">
		<div class="row">
			<div class="col">
				<h2 class="mb-4">${event.name}</h2>
				<form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
			        <form:hidden value="${user.id}" path="creator"/>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="name"/>
			        	<form:label class="col-4 col-form-label" path="name">Name</form:label>
			            <div class="col-8">
			            	<form:input class="form-control" path="name"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="date"/>
			        	<form:label class="col-4 col-form-label" path="date">Date</form:label>
			            <div class="col-8">
			            	<form:input type="date" class="form-control" path="date"/>
			            </div>
			        </div>
			        <div class="row mb-4">
				        	<form:errors class="text-danger" path="city"/>
				        	<form:label class="col-4 col-form-label" path="city">Location</form:label>
				            <div class="col-8">
				            	<div class="row">
					            	<div class="col-8">
					            		<form:input class="form-control" path="city"/>
					            	</div>
					            	<div class="col-4">
						            	<form:select class="form-control" path="state">
						            		<c:forEach items="${states}" var="state">
												<form:option value="${state}">${state}</form:option>
											</c:forEach>
						            	</form:select>
						            </div>
					            </div>
				            </div>
				        </div>
			         <div class="text-end">
				    	<input type="submit" class="btn btn-success" value="Update"/>
				    </div>
		    	</form:form>
			</div>
		</div>
	</div>
</body>
</html>