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
    <title>Songs Dashboard</title>
</head>
<body>
	<div class="container p-5">
		<div class="row mb-5">
			<div class="col d-flex justify-content-between align-items-center">
				<a href="/songs/new">Add New</a>
				<a href="/search/topTen">Top Songs</a>
				<form action="/songs/search" class="d-flex justify-content-between">
      				<input type="text" name="artist" class="form-control mx-1">
					<input type="submit" value="Search Artists" class="btn btn-primary">
				</form> 
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Rating</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${songs}" var="song">
						<tr>
							<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            				<td><c:out value="${song.rating}"/></td>
            				<td><a href="/songs/${song.id}/delete">Delete</a> | <a href="/songs/${song.id}/edit">Edit</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>