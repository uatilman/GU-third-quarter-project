<%--
  Created by IntelliJ IDEA.
  User: uatil
  Date: 12.04.2018
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <ul class="menu">
        <%--продумать как вставить в меню class="active-link" в зависимости от выбранной страницы--%>
        <li><a href="${pageContext.request.contextPath}/">HOME</a></li>
        <li><a href="catalog">CATALOG</a></li>
        <li><a href="product">PRODUCT</a></li>
        <li><a href="cart">CART</a></li>
        <li><a href="order">ORDER</a></li>
        <li><a href="contacts.jsp">CONTACT</a>
        <li><a href="tests">TESTS</a>
        </li>
    </ul>
</nav>