<%@ page import="PresentationLayer.ShowBasket" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcakes - Kurv</title>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="style.css">

    <script src="https://kit.fontawesome.com/c97c9bd36e.js" crossorigin="anonymous"></script>
</head>
<body class="d-flex flex-column">
<%
    new ShowBasket().execute(request, response);
%>


<jsp:include page="header.jsp"></jsp:include>
<div class="outer">
    <div class="container pagecontainer main border rounded mb-2">

        <div class="pagecontainer mt-1  mt-4">
            <table class="outerTable table-bordered">
                <form action="FrontController" method="POST">
                    <input type="hidden" name="target" value="updateOrder">
                <c:forEach var="cupcake" items="${sessionScope.order.orderlines}" varStatus="count">
                    <tr class="border_bottomOuter">
                        <td>
                            <div class="row">
                                <div class="col-3">
                                    <table class="innerTable table">
                                        <tr class="border_bottom">
                                            <td>
                                                <h5>Bund:</h5>
                                            </td>
                                            <td class="text-right">
                                                <h5>${cupcake.bottom.name}</h5>
                                            </td>
                                        </tr>
                                        <tr class="border_bottom">
                                            <td>
                                                <h5>Topping:</h5>
                                            </td>
                                            <td class="text-right">
                                                <h5>${cupcake.top.name}</h5>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="col-9 h-100">
                                    <div class="d-flex flex-row justify-content-end align-items-center "
                                         style="height: 100px;">
                                        <div class="p-5">
                                            <h5>${cupcake.price} kr.</h5>
                                        </div>
                                        <div class="p-4">
                                            <h6><input class="form-control" value="${cupcake.amount}" type="number" id="quantity" name="quantity${count.index}" style="width: 65px;"></h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <td>

                    <div class="d-flex flex-row justify-content-end align-items-center" style="height: 50px;">
                        <div class="p-4">
                            <h6 class="mt-2">Antal Cupcakes: ${sessionScope.cupcakeAmount}</h6>
                        </div>
                        <button type="submit" class="btn btn-warning mr-4">Opdater kurv</button>

                    </div>
                </form>
                </td>
            </table>

        </div>
        <div class="pagecontainer mt-4">
            <table class="outerTable table-bordered">
                <td>
                    <!-- TODO find ud af hvordan den her kan centreres på telefon-->
                    <div class="d-flex flex-row justify-content-end align-items-center">
                        <div class="p-4">
                            <label for="datepicker" class="cal-label">Afhentningsdato</label>
                            <input id="datepicker" width="276"/>
                        </div>
                    </div>
                </td>
            </table>
        </div>
        <div class="pagecontainer mt-1 orderOverview">
            <div class="row mb-4 mt-4">
                <div class="col-lg-6">
                    <table class="outerTable table-bordered">
                        <td>
                            <div class="p-4 orderHeaderBorder">
                                <h4>Ordreoversigt</h4>
                            </div>
                            <div>
                                <p class="ml-2 mt-2 pl-3 orderprice" style="float:left;">Total:</p>
                                <p class="mr-2 mt-2 orderprice" style="float:right;">${sessionScope.order.getPrice()} kr.</p>
                            </div>

                        </td>
                    </table>
                </div>
                <div class="col-lg-6">
                    <div class="checkoutbutton">
                        <input type="submit" class="btn btn-primary button" id="pay" value="Betal">
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

<script>
    $('#datepicker').datepicker({
        uiLibrary: 'bootstrap4'
    });
</script>
</body>
</html>
