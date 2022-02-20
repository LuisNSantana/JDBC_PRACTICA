<%--
  Created by IntelliJ IDEA.
  User: luisnayib
  Date: 21/11/2019
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Iniciar Sesion</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<h1>Login</h1>
<form action="Login" method="get">
    <div class="form-group">
        <i class="fas fa-user"> <label for="exampleFormControlInput1">Usuario</label></i>
         <input type="text" name="user" class="form-control" id="exampleFormControlInput1" placeholder="Usuario">
    </div>
    <div class="form-group">
        <i class="fas fa-key"><label for="exampleFormControlInput2">Contraseña</label></i>
        <input type="password" name="password" class="form-control" id="exampleFormControlInput2" placeholder="Password">
    </div>
    <input type="submit" name="btn" class="button" value="Inciar Sesion">
</form> <br/>

<a class="button" href="registrarse.jsp"> Registrarse</a>


</body>
</html>
