<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <title></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Your Gold: <span><c:out value="${gold}" /></span></h2>
			<div class="col-4">
				<form method="POST" action="/process">
					<h4>Farm</h4>
					<h6>(earns 10-20 gold)</h6>
					<input name="source" type="hidden" value="farm">
					<input type="submit" class="btn btn-secondary" value="Find Gold!">
				</form>
			</div>
			<div class="col-4">
				<form method="POST" action="/process">
					<h4>Cave</h4>
					<h6>(earns 5-10 gold)</h6>
					<input name="source" type="hidden" value="cave">
					<input type="submit" class="btn btn-secondary" value="Find Gold!">
				</form>
			</div>
			<div class="col-4">
				<form method="POST" action="/process">
					<h4>House</h4>
					<h6>(earns 2-5 gold)</h6>
					<input name="source" type="hidden" value="house">
					<input type="submit" class="btn btn-secondary" value="Find Gold!">
				</form>
			</div>
			<div class="col-4 mt-3">
				<form method="POST" action="/process">
					<h4>Casino</h4>
					<h6>(earns/takes 0-50 gold)</h6>
					<input name="source" type="hidden" value="casino">
					<input type="submit" class="btn btn-secondary" value="Find Gold!">
				</form>
			</div>
			<div class="col-4 mt-3">
				<form method="POST" action="/process">
					<h4>Spa</h4>
					<h6>(takes 5-20 gold)</h6>
					<input name="source" type="hidden" value="spa">
					<input type="submit" class="btn btn-secondary" value="Find Gold!">
				</form>
			</div>
		</div>
		<div class="row mt-5">
			<h2>Activities:</h2>
			<div class="col" id="activity">
				<c:forEach var="activity" items="${activities}">
					<p class="${activity.contains("lost")? "red" : "green" }">>
						<c:out value="${activity}" />
					</p>
				</c:forEach>
			</div>
		</div>
		<div class="row">
			<div class="col text-end">
				<a href="/reset" class="btn btn-danger mt-5 text-center">Reset</a>
			</div>
		</div>
	</div>
</body>
</html>