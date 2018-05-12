<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="products" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/tags.tld" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/head.jsp">
    <jsp:param name="title" value="Tests"/>
</jsp:include>

<body>
<script src="js/prism.js"></script>
<div class="container">
    <%--// c передачей переменной см. урок 4  27.47--%>
    <%--// xhtml jsf 42:48 - end--%>
    <%--экспорт в эксель 1:26--%>
    <jsp:include page="fragments/header.jsp">
        <jsp:param name="menuname" value="TESTS"/>
    </jsp:include>

    <main class="content">
        <div class="padding-site">
            <h1>Test page</h1>

            <div class="product product-in-home-page">
                <c:forEach var="item" items="${productsAttribute}">
                    <div class="item">
                        <img class="item-product-img" src="<c:out value="${item.imgUrl}"/>" alt="product 1 image">
                        <div class="product-hover">
                            <a class="product-link" href="#"><img src="img/arrow.png" alt="orderTable button image"></a>
                            <h3><c:out value="${item.name}"/></h3>
                            <p><c:out value="${item.description}"/></p>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <%--<h2>Использование Сервлета для создания списка продуктов</h2>--%>
            <%--<pre><code class="language-java">--%>
                <%--//JAVA--%>
                <%--@WebServlet(urlPatterns = {"/tests", "/header"})--%>
                <%--public class TestServlet extends HttpServlet {--%>

                    <%--@Override--%>
                    <%--protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {--%>
                        <%--req.setAttribute("date", new Date());--%>
                        <%--req.setAttribute("productsAttribute", Product.getTestProductList());--%>
                        <%--req.getRequestDispatcher("tests.jsp").forward(req, resp);--%>
                    <%--}--%>
                <%--}--%>

                <%--//JSP--%>
                <%--&lt;div class="product product-in-home-page"&gt;--%>
                    <%--&lt;c:forEach var="productS" items="&dollar;{productsAttribute}"&gt;--%>
                        <%--&lt;div class="item"&gt;--%>
                            <%--&lt;img class="item-product-img" src="&lt;c:out value="&dollar;{productS.imgUrl}"/&gt;" alt="product 1 image"&gt;--%>
                            <%--&lt;div class="product-hover"&gt;--%>
                                <%--&lt;a class="product-link" href="#"&gt;&lt;img src="img/arrow.png" alt="orderTable button image"&gt;&lt;/a&gt;--%>
                                <%--&lt;h3&gt;&lt;c:out value="&dollar;{productS}"/&gt;&lt;/h3&gt;--%>
                                <%--&lt;p&gt;&lt;c:out value="&dollar;{productS.description}"/&gt;&lt;/p&gt;--%>
                            <%--&lt;/div&gt;--%>
                        <%--&lt;/div&gt;--%>
                    <%--&lt;/c:forEach&gt;--%>
                <%--&lt;/div&gt;--%>
            <%--</code></pre>--%>

            <%--<div class="product product-in-home-page">--%>
                <%--<c:forEach var="productS" items="${productsAttribute}">--%>
                    <%--<div class="item">--%>
                        <%--<img class="item-product-img" src="<c:out value="${productS.imgUrl}"/>" alt="product 1 image">--%>
                        <%--<div class="product-hover">--%>
                            <%--<a class="product-link" href="#"><img src="img/arrow.png" alt="orderTable button image"></a>--%>
                            <%--<h3><c:out value="${productS}"/></h3>--%>
                            <%--<p><c:out value="${productS.description}"/></p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</c:forEach>--%>
            <%--</div>--%>

            <%--<h2>Использование Java Bean для создания списка продуктов</h2>--%>
            <%--<pre><code class="language-java">--%>
                <%--//JAVA--%>
                <%--public class ProductsView {--%>
                    <%--private List&lt;Product&gt; products;--%>

                    <%--public ProductsView() {--%>
                        <%--this.products = new ArrayList&lt;Product&gt;();--%>
                        <%--products.add(new Product("Fishnet Chair0", "The majesty of Mountains — Ugmonk style.","img/product-1.jpg"));--%>
                        <%--products.add(new Product("Fishnet Chair1", "The majesty of Mountains — Ugmonk style.","img/product-3.jpg"));--%>
                        <%--products.add(new Product("Fishnet Chair2", "The majesty of Mountains — Ugmonk style.","img/product10.jpg"));--%>
                        <%--products.add(new Product("Fishnet Chair3", "The majesty of Mountains — Ugmonk style.","img/product1.jpg"));--%>
                    <%--}--%>

                    <%--public List&lt;Product&gt; getProducts() {--%>
                        <%--return products;--%>
                    <%--}--%>

                    <%--public void setProducts(List&lt;Product&gt; products) {--%>
                        <%--this.products = products;--%>
                    <%--}--%>
                <%--}--%>

                <%--//JSP--%>
                <%--&lt;jsp:useBean id="producrList" class="ru.tilman.gb.ee.ProductsView" scope="request"/&gt;--%>
                <%--&lt;products:forEach items="&dollar;{producrList.products}" var="product"&gt;--%>
                    <%--&lt;div class="item"&gt;--%>
                        <%--&lt;img class="item-product-img" src="&dollar;{product.imgUrl}" alt="product 1 image"&gt;--%>
                        <%--&lt;div class="product-hover"&gt;--%>
                            <%--&lt;a class="product-link" href="#"&gt;&lt;img src="img/arrow.png" alt="orderTable button image"&gt;&lt;/a&gt;--%>
                            <%--&lt;h3&gt;&dollar;{product}&lt;/h3&gt;--%>
                            <%--&lt;p&gt;&dollar;{product.description}&lt;/p&gt;--%>
                        <%--&lt;/div&gt;--%>
                    <%--&lt;/div&gt;--%>
                <%--&lt;/products:forEach&gt;--%>
            <%--</code></pre>--%>
            <%--<p>RESULT:</p>--%>
            <%--<div class="product product-in-home-page">--%>
                <%--<jsp:useBean id="producrList" class="ru.tilman.gb.ee.controllers.products.ProductsController" scope="request"/>--%>
                <%--<products:forEach items="${producrList.products}" var="product">--%>
                    <%--<div class="item">--%>
                        <%--<img class="item-product-img" src="${product.imgUrl}" alt="product 1 image">--%>
                        <%--<div class="product-hover">--%>
                            <%--<a class="product-link" href="#"><img src="img/arrow.png" alt="orderTable button image"></a>--%>
                            <%--<h3>${product}</h3>--%>
                            <%--<p>${product.description}</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</products:forEach>--%>
            <%--</div>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<h2>Создание собственного тега</h2>--%>
            <%--<m:test-tag basic="я значение basic атрибута"/>--%>
            <%--<br>--%>
            <%--<br>--%>

            <%--<h3>Изучаю pageContext</h3>--%>
            <%--<ol>--%>
                <%--<li>${pageContext.request.contextPath}</li>--%>
                <%--<li>${pageContext.request.localAddr}</li>--%>
                <%--<li>${pageContext.request.getAttribute("url")}</li>--%>
                <%--<li>${pageContext.request.getContextPath()}</li>--%>
                <%--<li>${pageContext.request.getPathInfo()}</li>--%>
                <%--<li>${pageContext.request.getRequestURI()}</li>--%>
                <%--<li>${pageContext.request.getRequestURL()}</li>--%>
                <%--<li>${pageContext.request.getServletPath()}</li>--%>
            <%--</ol>--%>
            <%--<br>--%>
            <%--<br>--%>
            <%--<h3>Сервлеты</h3>--%>
            <%--<pre><code class="language-java">--%>
                <%--//Java:--%>
                <%--req.setAttribute("date", new Date());--%>
                <%--//JSP:--%>
                <%--&lt;%= request.getAttribute("date") %&gt;--%>
            <%--</code></pre>--%>
            <%--<br>--%>
            <%--<p>Result: <%= request.getAttribute("date") %>--%>
            <%--</p>--%>
            <%--<br>--%>

            <%--<h3>Скриплеты ​</h3>--%>
            <%--<pre><code class="language-java">--%>
                <%--//JSP:--%>
                <%--&lt;%=new java.util.Date()%&gt;--%>
                <%--//or--%>
                <%--//JSP:--%>
                <%--&lt;jsp:expression&gt;new java.util.Date()&lt;/jsp:expression&gt;--%>
            <%--</code></pre>--%>
            <%--<p>Result: <%=new java.util.Date()%>--%>
            <%--</p>--%>
            <%--<p>or</p>--%>
            <%--<p>Result:--%>
                <%--<jsp:expression>new java.util.Date()</jsp:expression>--%>
            <%--</p>--%>
            <%--<pre><code class="language-java">--%>
                <%--//JSP:--%>
                <%--&lt;%--%>
                    <%--int a = 5;--%>
                    <%--int b = 6;--%>
                    <%--out.println(a + b);--%>
                <%--%&gt;--%>
                <%--//TODO this variant don`t work--%>
                <%--//JSP:--%>
                <%--&lt;jsp:scriptlet&gt;&lt;/jsp:scriptlet&gt;--%>
            <%--</code></pre>--%>
            <%--<p>Result: <%--%>
                <%--int a = 5;--%>
                <%--int b = 6;--%>
                <%--out.println(a + b);--%>
            <%--%></p>--%>
            <%--<pre><code class="language-java">--%>
                <%--//JSP:--%>
               <%--&lt;%!--%>
                    <%--public int calc(int a, int b) {--%>
                        <%--return a + b;--%>
                    <%--}--%>
                <%--%&gt;--%>
                <%--&lt;% out.println(calc(10,5)); %&gt;--%>
                <%--//TODO this variant don`t work--%>
                <%--//JSP:--%>
                <%--&lt;jsp:declaration%gt;&lt;/jsp:declaration&gt;--%>

            <%--</code></pre>--%>
            <%--<p>Result:--%>
                <%--<%!--%>
                    <%--public int calc(int a, int b) {--%>
                        <%--return a + b;--%>
                    <%--}--%>
                <%--%>--%>
                <%--<% out.println(calc(10, 5)); %>--%>
            <%--</p>--%>

            <%--<h4>Директивы</h4>--%>

            <%--<pre><code class="language-java"></code></pre>--%>
            <%--<pre><code class="language-java"></code></pre>--%>
            <%--<pre><code class="language-java"></code></pre>--%>
            <%--<pre><code class="language-java"></code></pre>--%>

            <%--&lt; &gt;--%>
            <%--&lt; &gt;--%>
            <%--&lt; &gt;--%>
            <%--&lt; &gt;--%>
        </div>
    </main>
    <jsp:include page="fragments/footer.jsp"/>

</div>
</body>
</html>
