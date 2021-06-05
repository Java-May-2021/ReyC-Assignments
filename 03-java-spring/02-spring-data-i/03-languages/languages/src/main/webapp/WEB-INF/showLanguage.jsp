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
    <title>Languages Details</title>
</head>
<body>
	<div class="container p-5">
		<div class="row text-end mb-5">
			<div class="col">
				<a href="/languages">Dashboard</a>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<h1><c:out value="${language.name}"/></h1>
				<br>
				<p><c:out value="${language.creator}"/></p>
				<br>
				<p><c:out value="${language.currentVersion}"/></p>
				<br>
				<p><a href="/languages/${language.id}/edit">Edit</a></p>
				<br>
				<p><a href="/languages/${language.id}/delete">Delete</a></p>
			</div>
		</div>
	</div>
</body>
</html>