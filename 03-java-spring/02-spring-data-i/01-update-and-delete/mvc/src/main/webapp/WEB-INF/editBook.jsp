<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<h1 class="mb-3 text-center">Edit Book</h1>
		<form:form action="/books/edit/${id}" method="post" modelAttribute="book">
		    <form:errors path="title" class="text-danger"/>
		    <div class="form-group form-row text-center">
		    	<form:label path="title" class="col-4 col-form-label">Title</form:label>
		        <div class="col-8">
		        	<form:input path="title" class="form-control"/>
		        </div>
		    </div>
		    <form:errors path="description" class="text-danger"/>
		    <div class="form-group form-row text-center">
		    	<form:label path="description" class="col-4 col-form-label">Description</form:label>
		        <div class="col-8">
		        	<form:textarea path="description" class="form-control"/>
		        </div>
		    </div>
		    <form:errors path="language" class="text-danger"/>
		    <div class="form-group form-row text-center">
		    	<form:label path="language" class="col-4 col-form-label">Language</form:label>
		        <div class="col-8"><form:input path="language" class="form-control"/></div>
		    </div>
		    <form:errors path="numberOfPages" class="text-danger"/>
		    <div class="form-group form-row text-center">
		    	<form:label path="numberOfPages" class="col-4 col-form-label">Pages</form:label>     
		        <div class="col-8"><form:input type="number" path="numberOfPages" class="form-control"/></div>
		    </div>
		    <div class="text-right"><input type="submit" value="Submit" class="btn btn-info"/></div>
		</form:form>
	</div>
</body>
</html>