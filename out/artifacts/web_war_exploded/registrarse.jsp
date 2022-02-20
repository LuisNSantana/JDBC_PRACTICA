<%--
  Created by IntelliJ IDEA.
  User: luisnayib
  Date: 21/11/2019
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<h1>Login</h1>
<form action="Registro" method="get">
    <div class="form-group">
        <label for="exampleFormControlInput1">Usuario</label>
        <input type="text" name="user" class="form-control" id="exampleFormControlInput1" placeholder="Usuario">
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput2">Contraseña</label>
        <input type="password" name="password" class="form-control" id="exampleFormControlInput2" placeholder="Password">
    </div>

    <div class="form-group">
        <label for="exampleFormControlInput2">Correo Electronico</label>
        <input type="email" name="email" class="form-control" placeholder="Correo electronico">
    </div>
    <input type="submit" name="btn" class="btn btn-primary" value="Registrarse">
</form> <br/>

<a class="btn btn-primary" href="login.jsp"> Home</a>
</body>
</html>
