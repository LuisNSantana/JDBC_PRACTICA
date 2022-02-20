<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Prueba</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </head>
  <body>
    <h1>Prueba JDBC</h1>

    <form action="Alta_Controlador" method="get">
      <div class="form-group">
        <label for="exampleFormControlInput1">Nombre</label>
        <input type="text" name="nombre" class="form-control" id="exampleFormControlInput1" placeholder="Ingresa tu nombre">
      </div>
      <div class="form-group">
        <label for="exampleFormControlInput2">Apellidos</label>
        <input type="text" name="apellidos" class="form-control" id="exampleFormControlInput2" placeholder="Ingresa tu apellido">
      </div>
      <div class="form-group">
        <label for="exampleFormControlInput3">Direccion de correo electronico</label>
        <input type="email" name="correo" class="form-control" id="exampleFormControlInput3" placeholder="Ingresa tu correo electronico">
      </div>
      <input type="submit" name="btn" value="Enviar" >
      </form>

  </body>
</html>