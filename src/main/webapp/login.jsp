<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcakes - Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>

<body class="d-flex flex-column">

<div class="container main border rounded mb-2 pt-1 pagecontainer">
    <div class="form-row">
        <div class="col-lg-6">
            <form name="login" action="FrontController" method="POST">
                <input type="hidden" name="target" value="login">
                <h1>Log ind</h1>
                <div class="container px-5">
                    <div class="form-group">
                        <label for="LoginEmail">Email Adresse</label>
                        <input name="LoginEmail" type="email" class="form-control" id="LoginEmail"
                               placeholder="Indtast Email" required>
                    </div>
                    <div class="form-group">
                        <label for="LoginPassword">Kodeord</label>
                        <input id="LoginPassword" name="LoginPassword" type="password" class="form-control"
                               placeholder="Kodeord" required>
                    </div>
                    <button type="submit" class="btn button buttonLogin">Login</button>
                </div>
            </form>
        </div>

        <div class="col d-lg-none d-xl-none py-3">
            <hr class="dividerLogin">
        </div>
        <div class="col-lg-6">
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="target" value="register">
                <h1>Registrer</h1>
                <p style="color: red;">${requestScope.error}</p>
                <div class="container px-5">
                    <div class="form-group">
                        <label for="RegisterEmail">Email Adresse</label>
                        <input name="RegisterEmail" type="email" class="form-control" id="RegisterEmail"
                               placeholder="Indtast Email" required>
                    </div>
                    <div class="form-group">
                        <label for="RegisterPassword1">Kodeord</label>
                        <input id="RegisterPassword1" name="RegisterPassword1" type="password" class="form-control"
                               placeholder="Kodeord" required>
                    </div>
                    <div class="form-group">
                        <label for="RegisterPassword2">Gentag Kodeord</label>
                        <input id="RegisterPassword2" name="RegisterPassword2" type="password" class="form-control"
                               placeholder="Kodeord" required>
                    </div>
                    <button type="submit" class="btn button buttonLogin">Opret Konto</button>
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
