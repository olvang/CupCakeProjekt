<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://kit.fontawesome.com/c97c9bd36e.js" crossorigin="anonymous"></script>


<div class="container" style="padding-left: 0px;padding-right: 0px;">

    <img src="images/Header5.png" class="img-fluid" alt="Responsive image">

    <nav class="navbar navbar-light mt-2 pagecontainer">
        <a href="index.jsp" class="navbar-text">Forside</a>

        <c:choose>
            <c:if test="${sessionScope.email != null}">
                <p>${sessionScope.email}</p>
            </c:if>

        </c:choose>
        <div class="form-inline my-4 my-lg-0">
            <a href="login.html" class= "navbar-text mr-sm-2">login / registre</a>

            <a class= "navbar-brand my-2 my-sm-0" href="basket.html">
                <i class="fas fa-shopping-cart fa-lg"></i>
            </a>

        </div>

    </nav>

</div>
