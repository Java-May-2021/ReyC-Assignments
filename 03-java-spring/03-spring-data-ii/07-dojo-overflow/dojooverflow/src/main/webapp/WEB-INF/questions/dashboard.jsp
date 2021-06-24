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
    <title>Questions Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col">
				<h1 class="mb-4">Questions Dashboard</h1>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Question</th>
							<th scope="col">Tags</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${questions}" var="question">
						<tr>
							<td><a href="/questions/${question.id}">${question.question}</a></td>
							<td>
							<c:forEach items="${question.tags}" var="tag">
								${tag.subject}
							</c:forEach>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="text-end">
					<a href="/questions/new">New Question</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>