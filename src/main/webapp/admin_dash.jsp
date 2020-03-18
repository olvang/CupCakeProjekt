<%@ page import="PresentationLayer.AdminDashboard" %><%--
  Created by IntelliJ IDEA.
  User: Oliver
  Date: 17/03/2020
  Time: 16.54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    new AdminDashboard().execute(request, response);
%>


<jsp:include page="WEB-INF/includes/header.jsp"/>
<div class="outer">
    <div class="container pagecontainer main border rounded ">
        <div class="row mt-4">
            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-blue order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Antal Ordre</h6>
                        <h2 class="text-right"><i class="fa fa-cart-plus f-left"></i><span>${requestScope.amountOfOrders}</span></h2>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-green order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Antal CupCakes</h6>
                        <h2 class="text-right"><i class="fa fa-birthday-cake f-left"></i><span>${requestScope.amountOfCupcakes}</span></h2>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-yellow order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Antal Brugere</h6>
                        <h2 class="text-right"><i class="fa fa-users f-left"></i><span>${requestScope.amountOfUsers}</span></h2>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xl-3">
                <div class="card bg-c-pink order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">$$$ Lavet</h6>
                        <h2 class="text-right"><i class="fa fa-credit-card f-left"></i><span>${requestScope.totalSale}</span></h2>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col">
                    <h4>Sidste 5 ordre</h4>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Email</th>
                            <th scope="col">pris</th>
                            <th scope="col">cup cakes</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="stats" items="${requestScope.last5}">
                            <tr>
                                <th scope="row">${stats.o_id}</th>
                                <td>${stats.email}</td>
                                <td>${stats.price}</td>
                                <td>${stats.amountOfCupcakes}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="col">
                    <h4>Ordre i år</h4>
                    <div class="card">
                        <div class="card-body">
                            <canvas id="chLine"></canvas>
                        </div>
                    </div>
                </div>
            </div>
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
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script>
    /* large line chart */
    var chLine = document.getElementById("chLine");
    var chartData = {
        labels: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"],
        datasets: [{
            data: [589, 445, 483, 503, 689, 692, 634],
            backgroundColor: 'transparent',
            borderColor: "#007bff",
            borderWidth: 4,
            pointBackgroundColor: "#007bff"
        }
        ]
    };
    if (chLine) {
        new Chart(chLine, {
            type: 'line',
            data: chartData,
            options: {
                scales: {
                    xAxes: [{
                        ticks: {
                            beginAtZero: false
                        }
                    }]
                },
                legend: {
                    display: false
                },
                responsive: true
            }
        });
    }

</script>
</body>
</html>
</html>
