<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Hello <c:out value="${firstName}"/> <c:out value="${lastName}"/></title>
</head>
<body>
    <h1>Hello <c:out value="${firstName}"/> <c:out value="${lastName}"/></h1>
    <p>Welcome to SpringBoot!</p>
</body>
</html>