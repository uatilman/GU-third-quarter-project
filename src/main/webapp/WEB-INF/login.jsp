<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/head.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>
<body class="login-body">

    <div class="login">
        <form method="post" action="j_security_check">
            <input placeholder="login" type="text" name="j_username">
            <br>
            <input placeholder="password" type="password" name="j_password">
            <br>
            <input class="login-button" type="submit" value="login">
        </form>
    </div>

</body>
</html>
