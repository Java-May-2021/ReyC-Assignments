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
    <title>Edit Song</title>
</head>
<body>
	<div class="container">
		<div class="row m-5 text-end">
			<div class="col">
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-10">
				<form:form action="" method="POST" modelAttribute="song">
				    <div class="row mb-4">
				        <form:errors path="title" class="text-danger"/>
				        <form:label path="title" class="col-4 col-form-label">Title</form:label>
				        <div class="col-8">
				        	<form:input path="title" class="form-control"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:errors path="artist" class="text-danger"/>
				        <form:label path="artist" class="col-4 col-form-label">Artist</form:label>
				        <div class="col-8">
				        	<form:input path="artist" class="form-control"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label path="rating" class="col-4 col-form-label">Rating (1-10)</form:label>
				        <div class="col-8">
				        	<form:select path="rating" class="form-control">
				        		<form:options items="${ratingList}"/>
				        	</form:select>
				        </div>
				    </div>
				    <div class="text-end">
				    	<input type="submit" class="btn btn-primary" value="Update Song"/>
				    </div>
				</form:form> 
			</div>
		</div>
	</div>
</body>
</html>