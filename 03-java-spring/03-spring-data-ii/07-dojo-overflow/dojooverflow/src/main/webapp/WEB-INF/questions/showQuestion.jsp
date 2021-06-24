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
    <title>Question Profile</title>
</head>
<body>
	<div class="container d-flex vh-100 justify-content-center align-items-center">
		<div class="row">
			<div class="col-12">
				<h2 class="mb-1">${question.question}</h2>
				<h4 class="mb-4">
					Tags:
					<c:forEach items="${question.tags}" var="tag">
						<span class="btn btn-primary">${tag.subject}</span>
					</c:forEach>
				</h4>
			</div>
			<div class="col">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Answers</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${question.answers}" var="answer">
						<tr>
							<td>${answer.answer}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<h4 class="mb-2">Add your answer:</h4>
				<form:form action="/questions/answers" method="POST" modelAttribute="newAnswer">
					<div class="row mb-4">
				        <form:label class="col-4 col-form-label" path="answer">Answer:</form:label>
				        <form:errors path="answer"/>
				        <div class="col-8">
				        	<form:textarea class="form-control" path="answer"></form:textarea>
				        </div>
				        <form:hidden path="question" value="${question.id}"/>
				    </div>
				    <div class="text-end">
				    	<button class="btn btn-success">Answer it!</button>
				    </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>