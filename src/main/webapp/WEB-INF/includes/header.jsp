<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="https://kit.fontawesome.com/c97c9bd36e.js" crossorigin="anonymous"></script>


<div class="container" style="padding-left: 0px;padding-right: 0px;">

    <img src="images/Header5.png" class="img-fluid headerimg" alt="Responsive image">

    <nav class="navbar navbar-light mt-2 pagecontainer desktopnav">
        <a href="index.jsp" class="navbar-text">Forside</a>
        <div class="form-inline my-0">
            <c:choose>
                <c:when test="${sessionScope.email == null}">
                    ${"<a href='login.jsp' class= 'navbar-text mr-sm-2'>Login / Registrer</a>"}
                </c:when>
                <c:otherwise>

                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${sessionScope.email}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="myorders.jsp">Mine ordre</a>
                        <div class="dropdown-divider"></div>
                        <c:choose>
                            <c:when test="${sessionScope.role}">
                                <a class="dropdown-item" href="FrontController?target=AdminDashboard">Dashboard</a>
                                <a class="dropdown-item" href="FrontController?target=getAllOrders">Ordre</a>
                                <a class="dropdown-item" href="FrontController?target=getAllCustomers">Kunder</a>
                                <div class="dropdown-divider"></div>
                            </c:when>
                        </c:choose>

                        <a class="dropdown-item" href="FrontController?target=logout">Logout</a>
                    </div>
                </div>
                    <p class="navbar-text my-0">${sessionScope.balance} kr.</p>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.cupcakeAmount == null}">
                    <a class= "navbar-brand my-0 my-sm-0" href="basket.jsp">
                <span class="fa-stack fa-lg has-badge" data-count="0">
                  <i class="fa fa-circle fa-stack-lg fa-inverse"></i>
                  <i style="" class="fa fa-shopping-cart fa-stack-lg"></i>
                </span>
                    </a>
                </c:when>
                <c:otherwise>
                    <a class= "navbar-brand my-0 my-sm-0" href="basket.jsp">
                <span class="fa-stack fa-lg has-badge" data-count="${sessionScope.cupcakeAmount}">
                  <i class="fa fa-circle fa-stack-lg fa-inverse"></i>
                  <i style="" class="fa fa-shopping-cart fa-stack-lg"></i>
                </span>
                    </a>
                </c:otherwise>
            </c:choose>

        </div>

    </nav>

    <!-- on phone screen -->
    <nav class="navbar navbar-expand-lg navbar-light mt-2 pagecontainer phonenav" >
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a href="index.jsp" class="navbar-brand">Forside</a>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <c:choose>
                    <c:when test="${sessionScope.email == null}">
                        <li class="nav-item">
                                ${"<a href='login.jsp' class= 'navbar-text mr-sm-2'>Login / Registrer</a>"}
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <p>${sessionScope.email}</p>
                        </li>
                        <li class="nav-item">
                            <a class="nav-item" href="myorders.jsp">Mine ordre</a>
                        </li>
                            <c:choose>
                                <c:when test="${sessionScope.role}">
                                <li class="nav-item">
                                    <a class="nav-item" href="FrontController?target=AdminDashboard">Dashboard</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-item" href="FrontController?target=getAllOrders">Ordre</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-item" href="FrontController?target=getAllCustomers">Kunder</a>
                                </li>
                                </c:when>
                            </c:choose>
                        <li class="nav-item">
                            <a class="dropdown-item" href="FrontController?target=logout">Logout</a>
                        </li>

                    <li class="nav-item">
                        <p class="navbar-text my-0">${sessionScope.balance} kr.</p>
                    </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

            <c:choose>
                <c:when test="${sessionScope.cupcakeAmount == null}">
                    <a class= "navbar-brand my-0 my-sm-0" href="basket.jsp">
                <span class="fa-stack fa-lg has-badge" data-count="0">
                  <i class="fa fa-circle fa-stack-lg fa-inverse"></i>
                  <i style="" class="fa fa-shopping-cart fa-stack-lg"></i>
                </span>
                    </a>
                </c:when>
                <c:otherwise>
                    <a class= "navbar-brand my-0 my-sm-0" href="basket.jsp">
                <span class="fa-stack fa-lg has-badge" data-count="${sessionScope.cupcakeAmount}">
                  <i class="fa fa-circle fa-stack-lg fa-inverse"></i>
                  <i style="" class="fa fa-shopping-cart fa-stack-lg"></i>
                </span>
                    </a>
                </c:otherwise>
            </c:choose>

    </nav>

</div>
