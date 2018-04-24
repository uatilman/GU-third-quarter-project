
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="fragments/head.jsp">
    <jsp:param name="title" value="Order"/>
</jsp:include>
<body>
<div class="container">
    <jsp:include page="fragments/header.jsp">
        <jsp:param name="menuname" value="ORDER"/>
    </jsp:include>    <main class="content">
        <div class="padding-site">
            <p>orderTable page</p>
        </div>
    </main>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>

