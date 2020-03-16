<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="https://kit.fontawesome.com/c97c9bd36e.js" crossorigin="anonymous"></script>


<div class="container" style="padding-left: 0px;padding-right: 0px;">

    <img src="images/Header5.png" class="img-fluid" alt="Responsive image">

    <nav class="navbar navbar-light mt-2 pagecontainer">
        <a href="index.jsp" class="navbar-text">Forside</a>
        <div class="form-inline my-4 my-lg-0">
            <c:choose>
                <c:when test="${sessionScope.email == null}">
                    ${"<a href='login.jsp' class= 'navbar-text mr-sm-2'>Login / Registrer</a>"}
                </c:when>
                <c:otherwise>
                   <p class='navbar-brand my-2 my-sm-0'> ${sessionScope.email}</p>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.cupcakeAmount == null}">
                    <a class= "navbar-brand my-2 my-sm-0" href="basket.jsp">
                  <i style="" class="fa fa-shopping-cart fa-stack-lg"></i>
                    </a>
                </c:when>
                <c:otherwise>
                    <a class= "navbar-brand my-2 my-sm-0" href="basket.jsp">
                <span class="fa-stack fa-lg has-badge" data-count="${sessionScope.cupcakeAmount}">
                  <i class="fa fa-circle fa-stack-lg fa-inverse"></i>
                  <i style="" class="fa fa-shopping-cart fa-stack-lg"></i>
                </span>
                    </a>
                </c:otherwise>
            </c:choose>


        </div>

    </nav>

</div>
