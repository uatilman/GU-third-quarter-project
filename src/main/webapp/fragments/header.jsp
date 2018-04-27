<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="padding-site">
    <div class="header">
        <a href="${pageContext.request.contextPath}/" class="logo">
            <img src="img/logo.png" alt="logo">
            <%--<div>Result: <%= request.getAttribute("date") %>--%>
            <%--</div>--%>
        </a>
        <nav>
            <ul class="menu">
                <%--продумать как вставить в меню class="active-link" более изящно--%>

                <c:forEach var="menuItem" items="${menu}">
                    <li>
                        <a
                                <c:if test="${param.menuname.equals(menuItem.name)}">
                                    class="active-link"
                                </c:if>
                                href="<c:out value="${menuItem.path}"/>">
                            <c:out value="${menuItem.name}"/>
                        </a>
                    </li>
                </c:forEach>


                <%--<li><a class="active-link" <%= request.getattribute("main-active-link") %>href="${pagecontext.request.contextpath}/">home</a></li>--%>
                <%--<li><a class="active-link" <%= request.getattribute("catalog-active-link") %>href="catalog">catalog</a></li>--%>
                <%--<li><a class="active-link" <%= request.getattribute("product-active-link") %>href="product">product</a></li>--%>
                <%--<li><a class="active-link" <%= request.getattribute("cart-active-link") %>href="cart">cart</a></li>--%>
                <%--<li><a class="active-link" <%= request.getattribute("ordertable-active-link") %>href="ordertable">order</a></li>--%>
                <%--<li><a class="active-link" href="contacts.jsp">contact</a>--%>
                <%--<li><a class="active-link" <%= request.getattribute("tests-active-link") %> href="tests">tests</a>--%>
                </li>
            </ul>
        </nav>
        <%--<jsp:include page="menu.jsp"/>--%>
    </div>
</header>