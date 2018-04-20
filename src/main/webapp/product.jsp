<!DOCTYPE html>
<html lang="en">
<jsp:include page="fragments/head.jsp">
    <jsp:param name="title" value="Fishnet Chair"/>
</jsp:include>

<body>
<div class="container">
    <jsp:include page="fragments/header.jsp">
        <jsp:param name="menuname" value="PRODUCT"/>
    </jsp:include>
    <main class="content">
        <div class="padding-site">
            <nav>
                <ul class="submenu product-submenu">
                    <li><a class="active-link" href="#">All</a></li>
                    <li><a href="#">HOME</a></li>
                    <li><a href="#">OFFICE</a></li>
                    <li><a href="#">FURNITURE</a></li>
                    <li><a href="#">MODERN</a></li>
                    <li><a href="#">CLASSIC</a></li>
                </ul>
            </nav>

            <article class="about-product">
                <div class="product-images">
                    <img src="img/slider1.jpg" alt="fishnet chair image">
                    <div class="other-product-color">
                        <a href="#"></a><img src="img/control-blue.jpg" alt="fishnet chair small image blue">
                        <a href="#"></a><img src="img/control-dark-blue.jpg" alt="fishnet chair small image dark blue">
                        <a href="#"></a><img class="active-link" src="img/slider1.jpg"
                                             alt="fishnet chair small image red">
                    </div>
                </div>
                <div class="product-description">
                    <h2>Fishnet Chair</h2>
                    <h4>Hot Deal</h4>
                    <p class="price"> 36.7</p>
                    <a class="order-button" href="#">Order Us <img src="img/arrow_white.png"
                                                                   alt="order button image"></a>
                    <div class="product-description-text">
                        <p>The majesty of&nbsp;Mountains&nbsp;&mdash; Ugmonk style.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do&nbsp;eiusmod tempor
                            incididunt ut
                            labore</p>
                        <p>et&nbsp;dolore magna aliqua. Ut&nbsp;enim ad&nbsp;minim veniam, quis nostrud exercitation
                            ullamco laboris nisi
                            ut&nbsp;aliquip ex&nbsp;ea&nbsp;commodo consequat.</p>
                        <p>Duis aute irure dolor in&nbsp;reprehenderit in&nbsp;voluptate velit esse cillum dolore eu&nbsp;fugiat
                            nulla
                            pariatur. Excepteur sint occaecat cupidatat non proident.</p>
                    </div>
                </div>
            </article>
            <div class="submenu">
                <div class="submenu-left trending related-product">
                    <p>Related Products</p>
                </div>
                <ul class="submenu-right">
                    <li><a href="#">explore all <img src="img/arrow.png" alt="exclusive product image"></a></li>
                </ul>
            </div>
            <div class="product product-in-product-page">
                <a href="#"><img src="img/product10.jpg" alt="product 10 image"></a>
                <a href="#"><img src="img/product11.jpg" alt="product 11 image"></a>
                <a href="#"><img src="img/product12.png" alt="product 12 image"></a>
            </div>
        </div>
    </main>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>