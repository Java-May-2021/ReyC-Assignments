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
    <title>Languages Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="row m-5">
			<div class="col">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Creator</th>
							<th scope="col">Version</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${languages}" var="language">
						<tr>
							<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            				<td><c:out value="${language.creator}"/></td>
            				<td><c:out value="${language.currentVersion}"/></td>
            				<td><a href="/languages/${language.id}/delete">Delete</a> | <a href="/languages/${language.id}/edit">Edit</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form:form action="/languages" method="POST" modelAttribute="language">
				    <div class="row mb-3">
				        <form:errors path="name" class="text-danger"/>
				        <form:label path="name" class="col-2 col-form-label">Name</form:label>
				        <div class="col-10">
				        	<form:input path="name" class="form-control"/>
				        </div>
				    </div>
				    <div class="row mb-3">
				        <form:errors path="creator" class="text-danger"/>
				        <form:label path="creator" class="col-2 col-form-label">Creator</form:label>
				        <div class="col-10">
				        	<form:input path="creator" class="form-control"/>
				        </div>
				    </div>
				    <div class="row mb-3">
				        <form:errors path="currentVersion" class="text-danger"/>
				        <form:label path="currentVersion" class="col-2 col-form-label">Version</form:label>
				        <div class="col-10">
				        	<form:input path="currentVersion" class="form-control"/>
				        </div>
				    </div>
				    <div class="text-end">
				    	<input type="submit" class="btn btn-primary" value="Submit"/>
				    </div>
				</form:form> 
			</div>
		</div>
	</div>
</body>
</html>