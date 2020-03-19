<%@ page import="PresentationLayer.GetAllCustomers" %><%--
  Created by IntelliJ IDEA.
  User: gamma
  Date: 18-03-2020
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%
    //TODO Fjern denne, da det er spild at hente hele listen hver gang der klikkes på en redigerknap.
    //kald den i stedet kun når man klikker ind på siden fra admin_dashboard
    new GetAllCustomers().execute(request, response);
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcakes - Kunder</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/fc-3.3.0/fh-3.1.6/r-2.2.3/datatables.min.css" />

    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/c97c9bd36e.js" crossorigin="anonymous"></script>
</head>

<body class="d-flex flex-column">
<jsp:include page="includes/header.jsp" />
<div class="outer">
    <div class="container pagecontainer main border rounded mb-2">
        <div class="container flex-fill">
            <div class="form-row">
                <div class="col-lg-12">
                    <h1>Kunder</h1>
                    <div class="container px-5">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover" id="table">
                                <thead class="tablehead">
                                <tr>
                                    <th scope="col">Email</th>
                                    <th scope="col">ID</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Kodeord</th>
                                    <th scope="col">Saldo</th>
                                    <th scope="col">...</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!-- IF EDIT BUTTON HAS NOT BEEN PRESSED -->
                                <c:choose>
                                    <c:when test="${requestScope.IDToEdit == null}">

                                        <c:forEach var="user" items="${sessionScope.users}">
                                            <tr>
                                                <!-- first user.email is used for searching while editing, not visible to user -->
                                                <td>${user.email}</td>
                                                <td>${user.id}</td>
                                                <td>${user.email}</td>
                                                <td>********</td>
                                                <td>${user.balance}</td>
                                                <td>
                                                    <form action="FrontController" method="POST">
                                                        <button type="submit" class="btn btn-success"><i class="fas fa-edit"></i></button>
                                                        <input type="hidden" name="target" value="beginEditUser">
                                                        <input type="hidden" name="userID" value="${user.id}">
                                                        <input type="hidden" name="userEmail" value="${user.email}">

                                                    </form>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="user" items="${sessionScope.users}" varStatus="count">
                                            <tr>
                                                <c:choose>
                                                    <c:when test="${user.id == requestScope.IDToEdit}">
                                                        <form action="FrontController" method="POST">
                                                            <!-- first user.email is used for searching while editing, not visible to user -->
                                                            <td>${user.email}</td>
                                                            <td>${user.id}</td>
                                                            <td><input type="email" value="${user.email}" name="editedEmail"></td>
                                                            <td><input type="password" placeholder="********" name="editedPassword"></td>
                                                            <td><input type="number" value="${user.balance}" step="0.01" min="0" name="editedBalance"></td>
                                                            <td>

                                                                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i></button>
                                                                <input type="hidden" name="target" value="updateUser">
                                                                <input type="hidden" name="userID" value="${user.id}">
                                                                <input type="hidden" name="counter" value="${count.index}">
                                                            </td>
                                                        </form>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!-- first user.email is used for searching while editing, not visible to user -->
                                                        <td>${user.email}</td>
                                                        <td>${user.id}</td>
                                                        <td>${user.email}</td>
                                                        <td>********</td>
                                                        <td>${user.balance}</td>
                                                        <td>
                                                            <form action="FrontController" method="POST">
                                                                <button type="submit" class="btn btn-success" disabled><i class="fas fa-edit"></i></button>
                                                                <input type="hidden" name="target" value="beginEditUser">
                                                                <input type="hidden" name="userEmail"
                                                                       value="${user.email}">
                                                                <input type="hidden" name="userID" value="${user.id}">
                                                            </form>
                                                        </td>
                                                    </c:otherwise>
                                                </c:choose>
                                            </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                </tbody>


                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp"></jsp:include>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/fc-3.3.0/fh-3.1.6/r-2.2.3/datatables.min.js"></script>

<script>

</script>

<c:choose>
    <c:when test="${userEmail != null}">
        <script>
            $(document).ready(function () {
                var table = $('#table').DataTable({
                    "ordering": false,
                    "search": {
                        "search": "${userEmail}"
                    },
                    "columnDefs": [{
                        "width": "2%",
                        "targets": 5
                    },
                        {
                            "targets": [0],
                            "visible": false,
                            "searchable": true
                        }

                    ]
                });

                new $.fn.dataTable.FixedHeader(table);
            });
        </script>
    </c:when>
    <c:otherwise>
        <script>
            $(document).ready(function () {
                var table = $('#table').DataTable({
                    "ordering": false,
                    "columnDefs": [{
                        "width": "2%",
                        "targets": 4
                    },
                        {
                            "targets": [0],
                            "visible": false,
                            "searchable": false
                        }]
                });

                new $.fn.dataTable.FixedHeader(table);
            });
        </script>
    </c:otherwise>
</c:choose>
</body>

</html>
