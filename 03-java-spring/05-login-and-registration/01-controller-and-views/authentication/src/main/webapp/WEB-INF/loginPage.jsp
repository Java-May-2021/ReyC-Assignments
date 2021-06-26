<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
    <title>Login Page</title>
</head>
<body>
    <div class="container">
		<div class="row d-flex vh-100 justify-content-center align-items-center">
			<div class="col-10">
				<h1>Login</h1>
    
			    <p><c:out value="${error}" /></p>
			    
			    <form method="POST" action="/login">
			        <div class="row mb-4">
			        	<label type="email" for="email" class="col-4 col-form-label">Email</label>
			            <div class="col-8">
			            	<input type="text" id="email" name="email" class="form-control"/>
			            </div>
			        </div>
			        <div class="row mb-4">
			            <label for="password" class="col-4 col-form-label">Password</label>
			            <div class="col-8">
			            	<input type="password" id="password" name="password" class="form-control"/>
			            </div>
			        </div>
			        <div class="text-end">
				    	<input type="submit" class="btn btn-success" value="Login!"/>
				    </div>
			    </form>
			</div>
		</div>
	</div>
</body>
</html>