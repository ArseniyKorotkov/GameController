<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Buttons</title>
</head>
<body>


    <form action="save_button_settings" method="post">
        <table>
            <tr>

                <td>.</td>

                <td>
                    <select name="button_up">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>

                <td>.</td>

                <td>
                    <select name="button_a">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>

                <td>
                    <select name="button_b">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>

                <td>
                    <select name="button_c">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    <select name="button_left">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>

                <td>.</td>

                <td>
                    <select name="button_right">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>

                <td>.</td>
                <td>.</td>
                <td>.</td>
            </tr>

            <tr>
                <td>.</td>

                <td>
                    <select name="button_down">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>

                <td>.</td>

                <td>
                    <select name="button_d">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="button_e">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="button_f">
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}</option>
                            <c:if test="${key_button.isUsed()}">
                                <h1>
                                    (used player ${key_button.userId.get()})
                                </h1>
                            </c:if>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">SAVE</button>
                </td>
            </tr>
        </table>
    </form>


</body>
</html>