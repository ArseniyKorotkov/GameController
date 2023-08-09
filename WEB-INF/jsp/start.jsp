<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Buttons</title>
</head>
<body>


    <c:choose>

        <c:when test="${sessionScope.user == null}">

            <form action="/controller/check_enter" method="post">

                <table>
                    <tr>
                        <td>Name:</td>
                        <td>
                            <label for="name">
                                <input type="text" name="userName" id="userNameId" required>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td>Password:</td>
                        <td>
                            <label for="pass">
                                <input type="password" name="userPass" id="userPassId" required>
                            </label>
                        </td>
                    </tr>
                </table>

                <p> ${sessionScope.pass_statement} </p>

                <button type="submit">LOGIN</button>

            </form>


            <tr>
                <form action="/controller/regis" method="post">
                    <button type="submit">REGISTRATION</button>
                </form>
            </tr>

        </c:when>

        <c:when test="${sessionScope.user != null}">

            <p>User '${sessionScope.user.name}' in system </p>

            <table>

                <tr>
                    <td>
                        <form action="/controller/menu" method="get">
                            <button type="submit">MENU</button>
                        </form>
                    </td>

                    <td>
                        <form action="/controller/logout" method="post">
                            <button type="submit">LOGOUT</button>
                        </form>
                    </td>
                </tr>
            </table>

        </c:when>

    </c:choose>


</body>
</html>