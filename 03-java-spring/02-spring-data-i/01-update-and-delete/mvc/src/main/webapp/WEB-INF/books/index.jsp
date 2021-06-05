<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <title></title>
</head>
<body>
	<div class="container">
		<h1 class="text-center pt-3">All Books</h1>
		<hr>
		<table class="table table-bordered table-striped">
		    <thead>
		        <tr>
		            <th scope="col">Title</th>
		            <th scope="col">Description</th>
		            <th scope="col">Language</th>
		            <th scope="col">No. of Pages</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${books}" var="book" varStatus="loop">
		        <tr>
		            <td><c:out value="${book.title}"/></td>
		            <td><c:out value="${book.description}"/></td>
		            <td><c:out value="${book.language}"/></td>
		            <td><c:out value="${book.numberOfPages}"/></td>
		            <td><a href="/books/delete/${loop.index}">Delete</a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/books/new">New Book</a>
	</div>
</body>
</html>