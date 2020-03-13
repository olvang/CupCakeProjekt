<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<html>
<head>
    <title>Olsker Cupcakes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>

<%!
    @Override
    public void jspInit() {
        //TODO initialiser bund og top liste
    }
%>
<%
    //TODO læg listerne i requestscope
%>

<div class="outer">
    <div class="pagecontainer main border rounded ">
        <h1 class="title">Velkommen ombord! </h1>
        <h2 class="subtitle">Øens bedste cupcakes. Vælg og bestil her:</h2>

        <div class="container">
            <form name="addToOrder" action="FrontController" method="POST">
                <input type="hidden" name="target" value="addToOrder">
                <div class="form-row align-items-center">
                    <div class="col-lg-4 my-1">
                        <label class="mr-md-3" for="bottoms">Bund</label>
                        <select class="custom-select mb-4" id="bottoms">
                            <option selected disabled>Vælg...</option>
                            <!-- TODO læg alle bunde i en liste kaldt bottoms, i requestScope -->
                            <c: forEach var="bottom" items="${bottoms}">
                                <option value="${bottom}">${bottom}</option>
                            </c:>
                            <%--<option value="Chocolate">Chocolate</option>
                            <option value="Vanilla">Vanilla</option>
                            <option value="Nutmeg">Nutmeg</option>
                            <option value="Pistacio">Pistacio</option>--%>
                        </select>
                    </div>
                    <div class="col-lg-4 my-1">
                        <label class="mr-md-3" for="bottoms">Topping</label>
                        <select class="custom-select mb-4" id="toppings">
                            <option selected disabled>Vælg...</option>
                            <!-- TODO læg alle toppe i en liste kaldt toppings, i requestScope -->
                            <c: forEach var="topping" items="${toppings}">
                                <option value="${topping}">${topping}</option>
                            </c:>
                            <%--<option value="Chocolate">Chocolate</option>
                            <option value="Blueberry">Blueberry</option>
                            <option value="Rasberry">Rasberry</option>
                            <option value="Crispy">Crispy</option>--%>
                        </select>
                    </div>
                    <div class="col-lg-4 my-1">
                        <label class="mr-md-3" for="quantity">Antal</label>
                        <input class="form-control mb-4" type="number" id="quantity" name="quantity">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 my-1">
                        <input type="submit" class="btn btn-primary button" id="addtobasket" value="Føj til kurv">
                    </div>
                </div>
            </form>
        </div>
    </div>
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
