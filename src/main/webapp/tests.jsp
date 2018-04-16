<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tests</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="prism.css">

    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
            integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
            crossorigin="anonymous"></script>

</head>
<body>
<script src="prism.js"></script>
<div class="container">
    <jsp:include page="head.jsp"/>
    <main class="content">
        <div class="padding-site">
            <h2>Test page</h2>
            <br>
            <br>
            <h3>Сервлеты</h3>
            <pre><code class="language-java">
                //Java:
                req.setAttribute("date", new Date());
                //JSP:
                &lt;%= request.getAttribute("date") %&gt;
            </code></pre>
            <br>
            <p>Result: <%= request.getAttribute("date") %>
            </p>
            <br>

            <h3>Скриплеты ​</h3>
            <pre><code class="language-java">
                //JSP:
                &lt;%=new java.util.Date()%&gt;
                //or
                //JSP:
                &lt;jsp:expression&gt;new java.util.Date()&lt;/jsp:expression&gt;
            </code></pre>
            <p>Result: <%=new java.util.Date()%>
            </p>
            <p>or</p>
            <p>Result:
                <jsp:expression>new java.util.Date()</jsp:expression>
            </p>
            <pre><code class="language-java">
                //JSP:
                &lt;%
                    int a = 5;
                    int b = 6;
                    out.println(a + b);
                %&gt;
                //TODO this variant don`t work
                //JSP:
                &lt;jsp:scriptlet&gt;&lt;/jsp:scriptlet&gt;
            </code></pre>
            <p>Result: <%
                int a = 5;
                int b = 6;
                out.println(a + b);
            %></p>
            <pre><code class="language-java">
                //JSP:
               &lt;%!
                    public int calc(int a, int b) {
                        return a + b;
                    }
                %&gt;
                &lt;% out.println(calc(10,5)); %&gt;
                //TODO this variant don`t work
                //JSP:
                &lt;jsp:declaration%gt;&lt;/jsp:declaration&gt;

            </code></pre>
            <p>Result:
                <%!
                    public int calc(int a, int b) {
                        return a + b;
                    }
                %>
                <% out.println(calc(10, 5)); %>
            </p>

            <h4>Директивы</h4>

            <pre><code class="language-java"></code></pre>
            <pre><code class="language-java"></code></pre>
            <pre><code class="language-java"></code></pre>
            <pre><code class="language-java"></code></pre>
            <pre><code class="language-java"></code></pre>
            &lt; &gt;
            &lt; &gt;
            &lt; &gt;
            &lt; &gt;
            &lt; &gt;
        </div>
    </main>
    <jsp:include page="footer.jsp"/>

</div>
</body>
</html>
