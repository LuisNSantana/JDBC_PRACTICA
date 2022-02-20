package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Registro")
public class Registro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("user");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            Sesion_Consulta co = new Sesion_Consulta();
            if(co.registrar(usuario,pass,email)){
                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
