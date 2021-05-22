<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="js/alert.js"></script>
    <title>Display Date</title>
</head>
<body onload="showTime()">
	<div>
		<h1 id="time"><c:out value="${currentTime}"/></h1>
	</div>
</body>
</html>