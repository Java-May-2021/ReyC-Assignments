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
				<h4>Top Ten Songs</h4>
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-8 border p-3">
				<c:forEach items="${topSongs}" var="topSong">
					<p>
						<c:out value="${topSong.rating}"/> -
						<a href="/songs/${topSong.id}"><c:out value="${topSong.title}"/></a> -
						<c:out value="${topSong.artist}"/>		
					</p>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>