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
    <title>People and Licenses</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">License#</th>
							<th scope="col">State</th>
							<th scope="col">Expiration Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${people}" var="person">
						<tr>
							<td>${person.firstName}</td>
							<td>${person.lastName}</td>
            				<td>${person.license.getNumberAsString()}</td>
            				<td>${person.license.getState()}</td>
            				<td>${person.license.getExpirationDateFormatted()}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>