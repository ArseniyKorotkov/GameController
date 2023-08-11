<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Buttons</title>
</head>
<body>

    <form action="console" method="get">
        <button type="submit">CONSOLE</button>
    </form>

    <form action="console_settings" method="post">
        <button type="submit">CONSOLE SETTINGS</button>
    </form>

    <c:if test="${sessionScope.user.isMaster()}">
        <form action="registration_requests" method="get">
            <button type="submit">MASTER`S SETTINGS</button>
        </form>
    </c:if>

    <form action="control">
        <button type="submit">BACK</button>
    </form>






</body>
</html>