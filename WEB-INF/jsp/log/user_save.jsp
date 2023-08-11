<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Buttons</title>
</head>
<body>

    <c:if test="${!requestScope.installed_users.isEmpty()}">
        <form action="user_save" method="get">
            <table>

                <tr>
                    <td>
                        Users:
                    </td>

                    <td>
                        Save:
                    </td>

                    <td>
                        Like master:
                    </td>

                    <td>
                        Delete application:
                    </td>


                </tr>

                <c:forEach var="user" items="${requestScope.installed_users}">
                    <tr>
                        <td>
                            ${user}
                        </td>

                        <td>
                            <input type="checkBox" name="${user}_save">
                        </td>

                        <td>
                            <input type="checkBox" name="${user}_master">
                        </td>

                        <td>
                            <input type="checkBox" name="${user}_delete">
                        </td>

                    </tr>
                </c:forEach>
            </table>


            <button type="submit">APPLY</button>

        </form>
    </c:if>

    <c:if test="${requestScope.installed_users.isEmpty()}">
        No registration requests
    </c:if>



</body>
</html>