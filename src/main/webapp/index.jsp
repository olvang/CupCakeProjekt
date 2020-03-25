<%@ page import="FunctionLayer.TopAndBottoms" %>
<%@ page import="FunctionLayer.LogicFacade" %>
<%@ page import="FunctionLayer.Bottom" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="FunctionLayer.Topping" %>
<%@ page import="PresentationLayer.ShowFrontPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<html>
<head>
    <title>Olsker Cupcakes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>

<%
    new ShowFrontPage().execute(request, response);
%>
<jsp:include page="WEB-INF/includes/header.jsp" />
<div class="outer">
    <div class="container pagecontainer main border rounded ">
        <h1 class="title">Velkommen ombord! </h1>
        <c:choose>
            <c:when test="${requestScope.orderMessage != null}">
                <div class="alert alert-success text-center alert-dismissible fade show" role="alert">
                        ${requestScope.orderMessage}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:when>
            <c:when test="${requestScope.adminalert != null}">
                <div class="alert alert-danger text-center alert-dismissible fade show" role="alert">
                        ${requestScope.adminalert}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:when>
        </c:choose>

        <h2 class="subtitle">Øens bedste cupcakes. Vælg og bestil her:</h2>

        <div class="container">
            <form name="addToOrder" action="FrontController" method="POST" id="addToOrder">
                <input type="hidden" name="target" value="addToOrder">
                <div class="form-row align-items-center">
                    <div class="col-lg-4 my-1">

                        <label class="mr-md-3" for="bottom">Bund</label>
                        <select class="custom-select mb-4" id="bottom" name="bottom">
                            <option selected disabled>Vælg...</option>
                            <c:forEach var="bottom" items="${requestScope.bottoms}">
                                <option value="${bottom.name}">${bottom.name}: ${bottom.price} kr.</option>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="col-lg-4 my-1">

                        <label class="mr-md-3" for="topping">Topping</label>
                        <select class="custom-select mb-4" id="topping" name="topping">
                            <option selected disabled>Vælg...</option>
                            <c:forEach var="topping" items="${requestScope.toppings}">
                                <option value="${topping.name}">${topping.name}: ${topping.price} kr.</option>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="col-lg-4 my-1">
                        <label class="mr-md-3" for="quantity">Antal</label>
                        <input class="form-control mb-4" type="number" id="quantity" name="quantity">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 my-1">
                        <input type="submit" class="btn btn-primary button addtobasket fade show" value="Føj til kurv">
                        <c:choose>
                            <c:when test="${requestScope.msg != null}">
                                <div class="alert alert-primary addtobasket">${requestScope.msg}</div>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="WEB-INF/includes/footer.jsp"></jsp:include>

</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
