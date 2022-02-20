package controller;

import conexion.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sesion_Consulta  {
    private Connection conn = null;

    public Sesion_Consulta() throws SQLException, ClassNotFoundException {
        conn = DBConnection.getConnection();
    }

    public boolean autenticacion (String usuario, String password){
        PreparedStatement estancia = null;
        ResultSet rs = null;

        try {
            String consulta = "select * from usuarios_prueba where user = ? and pass = ?";
            estancia = conn.prepareStatement(consulta);// inicializamos la estancia con la variabe donde guardamos el getConnection
            estancia.setString(1, usuario);
            estancia.setString(2, password);

            rs =  estancia.executeQuery();//guardar resultado de la consulta

            if (rs.absolute(1)){// si encuentra un registro devuelvame true
                return true;
            }
        }catch (Exception e){
            System.err.println("ERROR: " + e);

        }finally {
            try {
                if(estancia.getConnection() != null) estancia.getConnection().close();
                if (estancia!=null) estancia.close();
                if (rs!=null) rs.close();
            } catch (Exception e){
                System.err.println("ERROR: " + e);
            }


        }




        return false;

    }

    public boolean registrar (String usuario, String password, String email){

        PreparedStatement estancia = null;

        try {
            String consulta = "insert into usuarios_prueba (user, pass, email) values (?,?,?)";

            estancia = conn.prepareStatement(consulta);// tambien validamos la tabla con la bd
            estancia.setString(1,usuario); // aca añadimos los datos de la bd a nuestras variables segun su posicion
            estancia.setString(2,password);
            estancia.setString(3,email);

            if (estancia.executeUpdate() == 1 ) { // Si se agrega un dato que nos devuelva true
                return true;
            }



        }catch (Exception ex){
            System.err.println("ERROR: " + ex);

        } finally {
            try {
                if (conn != null) conn.close();
                if (estancia != null) estancia.close();
            }catch (Exception ex){
                System.err.println("EEROR: " + ex);
            }


        }

        return false;
    }
    public static void main (String [] args) throws SQLException, ClassNotFoundException {
      Sesion_Consulta co = new Sesion_Consulta();

      System.out.println(co.registrar("user04", "123456","prueba@hotmail.com"));


    }
}
