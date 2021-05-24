<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <title>The Code Assignment</title>
</head>
<body>
	<form method="POST" action="/guess">
    	<p><c:out value="${error}" /></p>
    	<h3>What is the code?</h3>
    	<input type="text" name="guess">
    	<button>Try Code</button>
	</form>
</body>
</html>