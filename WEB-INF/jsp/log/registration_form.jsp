<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Buttons</title>
</head>
<body>


    <c:if test="${!sessionScope.answer_for_request_log_boolean}">
        <form action="/controller/check_regis">

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

            <br>


            <button type="submit">SAVE</button>

        </form>
    </c:if>

    ${sessionScope.answer_for_request_log}



    <c:if test="${requestScope.verdict}">
        <form action="/controller/control">
          <button type="submit">START PAGE</button>
        </form>
    </c:if>



</body>
</html>