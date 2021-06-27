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
	<div class="container-fluid p-5">
		<nav class="text-end mb-5">
			<div>
				<a href="/events" class="btn btn-info">Dashboard</a>
			<a href="/logout" class="btn btn-secondary">Logout</a>
			</div>
		</nav>
		<div class="row d-flex justify-content-center">
			<div class="col">
				<h1>${event.name}</h1>
				<p>Host: ${event.creator.firstName} ${event.creator.lastName}</p>
				<p>Date: <fmt:formatDate type = "date" dateStyle = "long" value = "${event.date}"/></p>
				<p>Location: ${event.city}, ${event.state}</p>
				<p>People who are attending the event: ${event.eventAttendees.size()}</p>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${event.eventAttendees}" var="attendee">
						<tr>
							<td>${attendee.firstName} ${attendee.lastName}</td>
							<td>${attendee.city}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<h1>Message Wall</h1>
				<div class="border p-3">
					<c:forEach items="${event.messages}" var="message">
						<p>${message.author.firstName} says: ${message.content}</p>
						<hr>
					</c:forEach>
				</div>
				<form action="/events/${event.id}/message"" method="POST">
					<div class="mb-3">
			        	<p class="text-danger">${error}</p>
			        	<label class="form-label" for="content">Add Comment:</label>
			            <textarea class="form-control" name="content" id="content"></textarea>
			        </div>
			        <div class="text-end">
				    	<input type="submit" class="btn btn-success" value="Submit"/>
				    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>