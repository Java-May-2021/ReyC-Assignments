<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <title>Dojo Survey Assignment</title>
</head>
<body>
	<div class="container">
		<div class="row" id="result">
			<h3>Submitted Info</h3>
			<div class="col-6">
				<p>Name:</p>
				<p>Dojo Location:</p>
				<p>Favorite Language:</p>
				<p>Comment:</p>
			</div>
			<div class="col-6">
				<p><c:out value="${name}" /></p>
				<p><c:out value="${location}" /></p>
				<p><c:out value="${language}" /></p>
				<p><c:out value="${comment}" /></p>
			</div>
			<a href="/" class="btn btn-success">Go Back</a>
		</div>
	</div>
</body>
</html>