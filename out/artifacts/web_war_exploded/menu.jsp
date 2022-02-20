<%--
  Created by IntelliJ IDEA.
  User: luisnayib
  Date: 21/11/2019
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@page import="modelo.ListaTareas"  import="modelo.Tarea"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://startbootstrap.com/snippets/full-image-header/" type="text/css">

    <link rel="stylesheet" href="css/estilos.css" type="text/css">
</head>
<body>
<div class="container-fluid">


    <section>
        <div class="container">
            <div class="row ">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <h1>Lista de tareas</h1>
                    <table class="table table-sm" border=1>
                        <%

                            ListaTareas lista = new ListaTareas();
                            lista.obtenerTareas();
                            String guardar = lista.pintarLista();
                        %>

                        <%=guardar %>


                    </table>
                </div>
                <div class="col-md-2">
                    <a class="nav-link" href="registrotarea.jsp"><i class="fas fa-ad"></i></a>

                </div>
            </div>
            <%----<%
            ListaTareas lt=new ListaTareas();

            out.print(lt.obtenerTareas());
            %>--%>





        </div>
    </section>


</div>

</body>
</html>