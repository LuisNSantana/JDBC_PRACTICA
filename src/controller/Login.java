package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Login")

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("user");
        String password = request.getParameter("password");


        try {
            Sesion_Consulta co = new Sesion_Consulta();
            if(co.autenticacion(usuario,password)){
                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
