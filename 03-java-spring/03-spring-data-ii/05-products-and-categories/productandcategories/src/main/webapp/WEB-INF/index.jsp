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
    <title>Products and Categories</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col-12">
				<h2 class="mb-4 mt-5">Products</h2>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Category Count</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
						<tr>
							<td><a href="/products/${product.id}">${product.name}<a/></td>
							<td>${product.description}</td>
							<td>${product.price}</td>
							<td>${product.categories.size()} categories</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<h2 class="mb-4">Categories</h2>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Product Count</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${categories}" var="category">
						<tr>
							<td><a href="categories/${category.id}">${category.name}</a></td>
							<td>${category.products.size()} products</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>