<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Buttons</title>
</head>
<body>

    <form action="/controller/console" method="get">
        <table>
            <tr>
                <td>.</td>
                <td>.</td>

                <td>
                    <button type="submit" background="navy" name="button_name" value="button_up"
                    style="width:360px;height:360px;background-color:${sessionScope.color_up}">
                        UP
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_up}
                        style="width:42px;height:42px"
                        name="check_up">
                    </td>
                </td>

                <td>.</td>
                <td>.</td>

                <td>
                    <button type="submit" name="button_name" value="button_a"
                    style="width:360px;height:360px;background-color:${sessionScope.color_a}">
                        BUTTON_A
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_a}
                        style="width:42px;height:42px"
                        name="check_a">
                    </td>

                </td>

                <td>
                    <button type="submit" name="button_name" value="button_b"
                    style="width:360px;height:360px;background-color:${sessionScope.color_b}">
                        BUTTON_B
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_b}
                        style="width:42px;height:42px"
                        name="check_b">
                    </td>
                </td>

                <td>
                    <button type="submit" name="button_name" value="button_c"
                    style="width:360px;height:360px;background-color:${sessionScope.color_c}">
                        BUTTON_C
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_c}
                        style="width:42px;height:42px"
                        name="check_c">
                    </td>
                </td>
            </tr>


            <tr>
                <td>
                    <button type="submit" name="button_name" value="button_left"
                    style="width:360px;height:360px;background-color:${sessionScope.color_left}">
                        LEFT
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_left}
                        style="width:42px;height:42px"
                        name="check_left">
                    </td>
                </td>

                <td>
                    <button type="submit" name="button_name" value="button_down"
                    style="width:360px;height:360px;background-color:${sessionScope.color_down}">
                        DOWN
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_down}
                        style="width:42px;height:42px"
                        name="check_down">
                    </td>
                </td>

                <td>
                     <button type="submit" name="button_name" value="button_right"
                     style="width:360px;height:360px;background-color:${sessionScope.color_right}">
                        RIGHT
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_right}
                        style="width:42px;height:42px"
                        name="check_right">
                    </td>
                </td>

                <td>
                    <button type="submit"  name="button_name" value="button_d"
                    style="width:360px;height:360px;background-color:${sessionScope.color_d}">
                        BUTTON_D
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_d}
                        style="width:42px;height:42px"
                        name="check_d">
                    </td>
                </td>

                <td>
                    <button type="submit"  name="button_name" value="button_e"
                    style="width:360px;height:360px;background-color:${sessionScope.color_e}">
                        BUTTON_E
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_e}
                        style="width:42px;height:42px"
                        name="check_e">
                    </td>
                </td>

                <td>
                    <button type="submit" name="button_name" value="button_f"
                    style="width:360px;height:360px;background-color:${sessionScope.color_f}">
                        BUTTON_F
                    </button>

                    <td>
                        <input type="checkBox"
                        ${sessionScope.check_f}
                        style="width:42px;height:42px"
                        name="check_f">
                    </td>
                </td>
            </tr>
        </table>
     </form>

</body>
</html>