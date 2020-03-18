<%@ page import="PresentationLayer.GetAllOrders" %><%--
  Created by IntelliJ IDEA.
  User: gamma
  Date: 18-03-2020
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
    new GetAllOrders().execute(request, response);
%>
<html lang="en">
<html>

<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcakes - Mine Ordre</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/fc-3.3.0/fh-3.1.6/r-2.2.3/datatables.min.css" />

    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/c97c9bd36e.js" crossorigin="anonymous"></script>
</head>

<body class="d-flex flex-column">
<jsp:include page="WEB-INF/includes/header.jsp" />
<div class="outer">
    <div class="container pagecontainer main border rounded mb-2">
        <div class="container flex-fill">
            <div class="form-row">
                <div class="col-lg-12">
                    <h1>Mine Ordre</h1>
                    <div class="container px-5">
                        <table class="table table-bordered table-hover" id="table">
                            <thead class="tablehead">
                            <tr>
                                <th scope="col">Pris</th>
                                <th scope="col">Antal</th>
                                <th scope="col">Afhentingsdato</th>
                                <th scope="col">Ordredato</th>
                                <th scope="col">Kunde</th>
                                <th scope="col">Se</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="order" items="${requestScope.orders}">
                                <tr>
                                    <td>${order.price}</td>
                                    <td>${order.amount}</td>
                                    <td>${order.pickupDate}</td>
                                    <td>${order.orderDate}</td>
                                    <td>${order.customer.email}</td>
                                    <td class="orderviewbutton"><a href="vieworder.jsp?o=${order.orderId}"><i
                                            class="fas fa-eye"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="WEB-INF/includes/footer.jsp"></jsp:include>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/fc-3.3.0/fh-3.1.6/r-2.2.3/datatables.min.js"></script>
<script>
    $(document).ready(function() {
        var table = $('#table').DataTable({
            "ordering": true,
            "order": [[3, "desc"]],
            "columnDefs": [{
                "width": "2%",
                "targets": 4
            }]
        });

        new $.fn.dataTable.FixedHeader(table);
    });
</script>
</body>

</html>
