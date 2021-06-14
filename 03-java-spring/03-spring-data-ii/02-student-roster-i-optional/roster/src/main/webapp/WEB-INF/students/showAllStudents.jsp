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
    <title>Students</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col">
				<table class="table table-bordered table-striped">
					<h1 class="mb-4">All Students</h1>
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Age</th>
							<th scope="col">Address</th>
							<th scope="col">City</th>
							<th scope="col">State</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${students}" var="student">
						<tr>
							<td>${student.firstName} ${student.lastName}</td>
							<td>${student.age}</td>
            				<td>${student.contact.address}</td>
            				<td>${student.contact.city}</td>
            				<td>${student.contact.state}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>