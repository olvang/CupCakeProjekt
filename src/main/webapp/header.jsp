<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">

    <img src="images/Header5.png" class="img-fluid" alt="Responsive image">

    <nav class="navbar navbar-light bg-light mt-1">
        <a href="index.jsp" class="navbar-text">Forside</a>

        <c:choose>
            <c:if test="${sessionScope.email != null}">
                <p>${sessionScope.email}</p>
            </c:if>

        </c:choose>
        <div class="form-inline my-4 my-lg-0">
            <a href="login.html" class= "navbar-text mr-sm-2">login / registre</a>

            <a class= "navbar-brand my-2 my-sm-0" href="basket.html">
                <img border="0" class="img-fluid" src="images/cart.png" >
            </a>

        </div>

    </nav>

</div>
