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
    <title>Show Product</title>
</head>
<body>
	<div class="container d-flex vh-100 justify-content-center align-items-center">
		<div class="row">
			<h1 class="mb-4">${product.name}</h1>
			<div class="col">
				<h3 class="mb-4">Categories</h3>
				<ul>
					<c:forEach items="${product.categories}" var="category">
						<li>${category.name}</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<form action="/categories/add/${product.id}">
					<div class="row mb-4">
				        <label for="category" class="col-5 col-form-label">Add Category</label>
				        <div class="col-7">
				        	<select id="category" name="categoryId" class="form-control">
				        		<c:forEach items="${categories}" var="category">
						        	<option value="${category.id}">${category.name}</option>
						        </c:forEach>
				        	</select>
				        </div>
				    </div>
				    <div class="text-end">
				    	<button class="btn btn-success">Add Category</button>
				    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>