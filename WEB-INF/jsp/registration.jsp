<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Buttons</title>
</head>
<body>


    <form action="/controller/check_regis">

            <label for="name"> Name:
                <input type="text" name="userName" id="userNameId" required>
            </label>

            <br>

            <label for="pass"> Password:
                <input type="password" name="userPass" id="userPassId" required>
             </label>

            <br>

            <button type="submit">SAVE</button>


    </form>


</body>
</html>