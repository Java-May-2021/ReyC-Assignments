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
			<div class="col-md-10 col-lg-6">
				<form method="POST" action="/submit">
					<div class="row mb-3">
						<label for="name" class="col-4 col-form-label">Your Name:</label>
						<div class="col-8">
							<input type="text" class="form-control" name="name" id="name"/>
						</div>
					</div>
					<div class="row mb-3">
						<label for="location" class="col-4 col-form-label">Dojo Location:</label>
						<div class="col-8">
							<input type="text" class="form-control" name="location" id="location"/>
						</div>
					</div>
					<div class="row mb-3">
						<label for="language" class="col-4 col-form-label">Favorite Language:</label>
						<div class="col-8">
							<select class="form-select" name="language" id="language">
								<option selected disabled>Select a language</option>
								<option value="Python">Python</option>
								<option value="Java">Java</option>
								<option value="JavaScript">JavaScript</option>
							</select>
						</div>
					</div>
					<div class="row mb-3">
						<label for="comment" class="col-4 col-form-label">Comment (optional):</label>
						<div class="col-8">
							<textarea class="form-control" name="comment" id="comment" rows="3"></textarea>
						</div>
					</div>
					<div id="submit">
						<input type="submit" class="btn btn-success" value="Submit">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>