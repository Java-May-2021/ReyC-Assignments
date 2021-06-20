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
    <title>New Product</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col-8">
				<h1 class="mb-4">New Product</h1>
				<form:form action="/products/new" method="POST" modelAttribute="product">
					<div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="name">Name</form:label>
				        <form:errors path="name"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="name"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="description">Description</form:label>
				        <form:errors path="description"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="description"/>
				        </div>
				    </div>
				    <div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="price">Price</form:label>
				        <form:errors path="price"/>
				        <div class="col-8">
				        	<form:input class="form-control" path="price"/>
				        </div>
				    </div>
				    <div class="text-end">
				    	<button class="btn btn-success">Create Product</button>
				    </div>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>