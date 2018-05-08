<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="${pageContext.request.contextPath}/fragments/head.jsp">
    <jsp:param name="title" value="Error"/>
</jsp:include>
<body>
<div class="container">
    <jsp:include page="${pageContext.request.contextPath}/fragments/header.jsp"/>
    <main class="content">
        <div class="padding-site">
            <div class="error">
                <img src="${pageContext.request.contextPath}/img/404.jpg">
            </div>

        </div>

    </main>
    <jsp:include page="${pageContext.request.contextPath}/fragments/footer.jsp"/>

</div>
</body>
</html>
