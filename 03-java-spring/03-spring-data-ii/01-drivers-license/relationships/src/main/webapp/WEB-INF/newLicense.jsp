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
    <title>New License</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col-8">
				<h2 class="mb-4">New License</h2>
				<form:form action="/licenses/new" method="POST" modelAttribute="license">
					<div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="person">Person</form:label>
				        <form:errors path="person"/>
				        <div class="col-8">
				        	<form:select class="form-control" path="person">
				        		<c:forEach items="${ people }" var="person">
						        	<form:option value="${ person.id }">${ person.firstName } ${ person.lastName }</form:option>
						        </c:forEach>
				        	</form:select>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="state">State</form:label>
				        <form:errors path="state"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="state"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="expirationDate">Expiration Date</form:label>
				        <form:errors path="expirationDate"/>
				        <div class="col-8">
				        	<form:input type="date" class="form-control" path="expirationDate"/>
				        </div>
				    </div>
				    <div class="text-end">
				    	<button class="btn btn-success">Add License</button>
				    </div>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>