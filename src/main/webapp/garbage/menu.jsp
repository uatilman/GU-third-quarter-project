<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav>
    <ul class="menu">
        <%--продумать как вставить в меню class="active-link" более изящно--%>

        <%--<c:forEach var="menuItem" items="${menu}">--%>
            <%--<li>--%>
                <%--<a class="active-link"--%>
                   <%--href="<c:out value="${menuItem.path}"/>">--%>
                    <%--<c:out value="${menuItem.name}"/>--%>
                <%--</a>--%>
            <%--</li>--%>
        <%--</c:forEach>--%>


        <li><a class="active-link" <%= request.getAttribute("main-active-link") %>href="${pageContext.request.contextPath}/">HOME</a></li>
        <li><a class="active-link" <%= request.getAttribute("catalog-active-link") %>href="catalog">CATALOG</a></li>
        <li><a class="active-link" <%= request.getAttribute("product-active-link") %>href="product">PRODUCT</a></li>
        <li><a class="active-link" <%= request.getAttribute("cart-active-link") %>href="cart">CART</a></li>
        <li><a class="active-link" <%= request.getAttribute("orderTable-active-link") %>href="orderTable">ORDER</a></li>
        <li><a class="active-link" href="../contacts.jsp">CONTACT</a>
        <li><a class="active-link" <%= request.getAttribute("tests-active-link") %> href="tests">TESTS</a>
        </li>
    </ul>
</nav>