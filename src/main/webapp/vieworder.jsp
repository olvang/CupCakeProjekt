<%@ page import="PresentationLayer.ViewOrder" %><%--
  Created by IntelliJ IDEA.
  User: Oliver
  Date: 16/03/2020
  Time: 16.00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (request.getParameter("o") == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
    } else {
        new ViewOrder().execute(request, response);
    }
%>

<html lang="en">
<html>

<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcakes - Min Ordre</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/fc-3.3.0/fh-3.1.6/r-2.2.3/datatables.min.css" />

    <script src="https://kit.fontawesome.com/c97c9bd36e.js" crossorigin="anonymous"></script>
</head>

<body class="d-flex flex-column">
<jsp:include page="WEB-INF/includes/header.jsp"/>
<div class="outer">
    <div class="container pagecontainer main border rounded mb-2 px-2">
        <div class="row">
            <table class="mt-2">
                <td>
                    <a href="myorders.jsp">
                        <div class="col-1">
                            <a href="myorders.jsp">
                                <button type="button" class="btn btn-lg button">Tilbage</button>
                            </a>
                        </div>
                    </a>
                </td>
                <td>
                    <h2>Ordre ${requestScope.order.orderId}</h2>
                </td>
            </table>
        </div>

        <div class="pagecontainer">
            <table class="outerTable table-bordered">
                <!-- TODO: Den her opfører sig pænere på lave opløsninger end den øverste. Byg ForEachLoop omkring den her-->
                <c:forEach var="cupcake" items="${requestScope.orderlines}" varStatus="count">
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
                                <div class="d-flex flex-row justify-content-end align-items-center " style="height: 100px;">
                                    <div class="p-5">
                                        <h5>${cupcake.price} kr.</h5>
                                    </div>
                                    <div class="p-4">
                                        <h6>x${cupcake.amount}</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    </c:forEach>
                    <td>

                        <div class="d-flex flex-row justify-content-end align-items-center" style="height: 50px;">
                            <div class="p-4 ">
                                <h6><b>Antal Cupcakes:</b> ${cupcakeTotalAmount}</h6>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="pagecontainer mt-1 mt-4">
            <table class="outerTable table-bordered">
                <td>
                    <div class="row">
                        <div class="col-lg-6 pl-5 pt-3 pb-2">
                            <h5><b>Bestillingsdato:</b> ${requestScope.order.pickupDate}</h5>
                        </div>
                        <div class="col-lg-6 pl-5 pt-3 pb-2">
                            <h5><b> Afhentingsdato:</b> ${requestScope.order.orderDate}</h5>
                        </div>
                    </div>
                </td>
            </table>
        </div>

        <div class="pagecontainer mt-1 orderOverview mt-4">
            <div class="row">
                <div class="col-lg-6">
                    <table class="outerTable table-bordered">
                        <td>
                            <div class="p-4 orderHeaderBorder">
                                <h3>Ordreoversigt</h3>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <tr>
                                        <td class="pl-4 pb-0" style="border-bottom:1pt solid black">
                                            <p class="ml-2 mt-2 orderprice" style="float:left;"><b>Total:</b></p>
                                            <p class="mr-2 mt-2 orderprice"
                                               style="float:right;">${requestScope.order.price} kr.</p>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                    </table>
                </div>
            </div>
        </div>

    </div>

    <jsp:include page="WEB-INF/includes/footer.jsp"></jsp:include>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/fc-3.3.0/fh-3.1.6/r-2.2.3/datatables.min.js"></script>
</body></html>

