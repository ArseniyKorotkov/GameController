<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.awt.Robot"%>
<%@ page import="java.awt.AWTException"%>
<html>
<head>
    <title>Buttons</title>
</head>
<body>

    <form action="/controller/buttons/butA"  method="post">

        <button type="submit">Я кнопка</button>
    </form>

    <br>
    <br>
    <br>
    <br>

    <form action="/controller/buttons/butS" method="post">
        <h1>     </h1>
        <button type="submit">Я кнопка</button>
    </form>

    <form action="/controller/buttons/butD" method="post">
        <h1>     </h1>
        <button type="submit">Я кнопка</button>
    </form>

    <br>
    <br>
    <br>
    <br>

    <form action="/controller/buttons/butW" method="post">
        <h1>               </h1>
        <button type="submit">Я кнопка</button>
    </form>


</body>
</html>