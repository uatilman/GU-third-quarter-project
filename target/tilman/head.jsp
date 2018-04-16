<%--
  Created by IntelliJ IDEA.
  User: uatil
  Date: 12.04.2018
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="padding-site">
    <div class="header">
        <a href="${pageContext.request.contextPath}/" class="logo">
            <img src="img/logo.png" alt="logo">
            <div>Result: <%= request.getAttribute("date") %></div>
        </a>
        <jsp:include page="menu.jsp"/>
    </div>
</header>