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
		<div class="row">
			<div class="col d-flex justify-content-between align-items-start">
				<h1 class="mb-5">Welcome, ${user.firstName}!</h1>
				<a href="/logout" class="btn btn-secondary">Logout</a>
			</div>
		</div>	
		<div class="row mb-3">
			<div class="col-12">
				<p>Here are some of the events in your state:</p>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Date</th>
							<th scope="col">Location</th>
							<th scope="col">Host</th>
							<th scope="col">Action/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userStates}" var="event">
						<tr>
							<td><a href="/events/${event.id}">${event.name}</a></td>
							<td><fmt:formatDate type="date" dateStyle="long" value="${event.date}"/></td>
							<td>${event.city}</td>
							<td>${event.creator.firstName}</td>
							<td>
							<c:choose>
								<c:when test="${event.creator.id == user.id}">
									<a href="/events/${event.id}/edit">Edit</a> | <a href="/events/${event.id}/delete">Delete</a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${event.eventAttendees.contains(user)}">
											<span>Joining</span> | <a href="/events/${event.id}/cancel">Cancel</a>
										</c:when>
										<c:otherwise>
											<a href="/events/${event.id}/join">Join</a>							
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12">
				<p>Here are some of the events in other states:</p>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Date</th>
							<th scope="col">Location</th>
							<th scope="col">State</th>
							<th scope="col">Host</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${otherStates}" var="event">
						<tr>
							<td><a href="/events/${event.id}">${event.name}</a></td>
							<td><fmt:formatDate type = "date" dateStyle = "long" value = "${event.date}"/></td>
							<td>${event.city}</td>
							<td>${event.city}</td>
							<td>${event.creator.firstName}</td>
							<td>
							<c:choose>
								<c:when test="${event.creator.id == user.id}">
									<a href="">Edit</a> | <a href="">Delete</a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${event.eventAttendees.contains(user)}">
											<span>Joining</span> | <a href="/events/${event.id}/cancel">Cancel</a>
										</c:when>
										<c:otherwise>
											<a href="/events/${event.id}/join">Join</a>							
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-6">
				<h2 class="mb-4">Create an Event</h2>
				<form:form method="POST" action="/events" modelAttribute="event">
			        <form:hidden value="${user.id}" path="creator"/>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="name"/>
			        	<form:label class="col-4 col-form-label" path="name">Name</form:label>
			            <div class="col-8">
			            	<form:input class="form-control" path="name"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			        	<form:errors class="text-danger" path="date"/>
			        	<form:label class="col-4 col-form-label" path="date">Date</form:label>
			            <div class="col-8">
			            	<form:input type="date" class="form-control" path="date"/>
			            </div>
			        </div>
			        <div class="row mb-4">
				        	<form:errors class="text-danger" path="city"/>
				        	<form:label class="col-4 col-form-label" path="city">Location</form:label>
				            <div class="col-8">
				            	<div class="row">
					            	<div class="col-9">
					            		<form:input class="form-control" path="city"/>
					            	</div>
					            	<div class="col-3">
						            	<form:select class="form-control" path="state">
						            		<c:forEach items="${states}" var="state">
												<form:option value="${state}">${state}</form:option>
											</c:forEach>
						            	</form:select>
						            </div>
					            </div>
				            </div>
				        </div>
			         <div class="text-end">
				    	<input type="submit" class="btn btn-success" value="Create"/>
				    </div>
		    	</form:form>
			</div>
		</div>
	</div>
</body>
</html>