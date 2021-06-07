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
    <title>Details</title>
</head>
<body>
	<div class="container p-5">
		<div class="row m-5 text-end">
			<div class="col">
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-8">
				<table class="table table-borderless ">
					<tbody>
						<tr>
							<th scope="row">Title</a></th>
            				<td scope="row"><c:out value="${song.title}"/></a></td>
						</tr>
						<tr>
							<th scope="row">Artist</th>
							<td scope="row"><c:out value="${song.artist}"/></td>
						</tr>
						<tr>
							<th scope="row">Rating (1-10)</th>
							<td scope="row"><c:out value="${song.rating}"/></td>
						</tr>
					</tbody>
				</table>
				<p>
					<a href="/songs/{id}/delete">Delete</a> | <a href="/songs/${song.id}/edit">Edit</a>
				<p>
			</div>
		</div>
	</div>
</body>
</html>