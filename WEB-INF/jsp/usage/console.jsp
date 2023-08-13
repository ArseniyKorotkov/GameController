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
                    <button type="submit" name="button_name" value="button_up"
                    style="width:360px;height:360px;background-color:${sessionScope.color_up}">
                        <h1>${sessionScope.button_up_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_up}
                        style="width:42px;height:42px"
                        name="check_up">
                    </td>
                </td>

                <td>.</td>
                <td>.</td>

                <td>
                    <button type="submit" name="button_name" value="button_a"
                    style="width:360px;height:360px;background-color:${sessionScope.color_a}">
                        <h1>${sessionScope.button_a_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_a}
                        style="width:42px;height:42px"
                        name="check_a">
                    </td>

                </td>

                <td>
                    <button type="submit" name="button_name" value="button_b"
                    style="width:360px;height:360px;background-color:${sessionScope.color_b}">
                        <h1>${sessionScope.button_b_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_b}
                        style="width:42px;height:42px"
                        name="check_b">
                    </td>
                </td>

                <td>
                    <button type="submit" name="button_name" value="button_c"
                    style="width:360px;height:360px;background-color:${sessionScope.color_c}">
                        <h1>${sessionScope.button_c_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_c}
                        style="width:42px;height:42px"
                        name="check_c">
                    </td>
                </td>
            </tr>


            <tr>
                <td>
                    <button type="submit" name="button_name" value="button_left"
                    style="width:360px;height:360px;background-color:${sessionScope.color_left}">
                        <h1>${sessionScope.button_left_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_left}
                        style="width:42px;height:42px"
                        name="check_left">
                    </td>
                </td>

                <td>
                    <button type="submit" name="button_name" value="button_down"
                    style="width:360px;height:360px;background-color:${sessionScope.color_down}">
                        <h1>${sessionScope.button_down_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_down}
                        style="width:42px;height:42px"
                        name="check_down">
                    </td>
                </td>

                <td>
                     <button type="submit" name="button_name" value="button_right"
                     style="width:360px;height:360px;background-color:${sessionScope.color_right}">
                        <h1>${sessionScope.button_right_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_right}
                        style="width:42px;height:42px"
                        name="check_right">
                    </td>
                </td>

                <td>
                    <button type="submit"  name="button_name" value="button_d"
                    style="width:360px;height:360px;background-color:${sessionScope.color_d}">
                        <h1>${sessionScope.button_d_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_d}
                        style="width:42px;height:42px"
                        name="check_d">
                    </td>
                </td>

                <td>
                    <button type="submit"  name="button_name" value="button_e"
                    style="width:360px;height:360px;background-color:${sessionScope.color_e}">
                        <h1>${sessionScope.button_e_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_e}
                        style="width:42px;height:42px"
                        name="check_e">
                    </td>
                </td>

                <td>
                    <button type="submit" name="button_name" value="button_f"
                    style="width:360px;height:360px;background-color:${sessionScope.color_f}">
                        <h1>${sessionScope.button_f_value}</h1>
                    </button>

                    <td>
                        <input type="checkBox"
                        ${requestScope.check_f}
                        style="width:42px;height:42px"
                        name="check_f">
                    </td>
                </td>
            </tr>

        </table>
    </form>

    <table>
        <tr><td>.</td></tr>
        <tr><td>.</td></tr>
        <tr><td>.</td></tr>
        <tr><td>.</td></tr>
        <tr>
            <td>
                <form action="menu">
                    <button type="submit" style="width:180px;height:60px">BACK</button>
                </form>
            </td>
        </tr>
    </table>

</body>
</html>