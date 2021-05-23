<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Counter Assignment</title>
</head>
<body>
	<p>You have the websites <c:out value="${counter}"/> times.</p>
	<p><a href="/my_server">Test another visit to http://my_server?</a></p>
	<p><a href="/my_server/countPlusTwo">Test another visit to http://my_server/countPlusTwo?</a></p>
	<p><a href="/my_server/reset"><button>Reset Count</button></a></p>
</body>