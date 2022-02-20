package dao;


import conexion.DBConnection;
import modelo.Tarea;
import modelo.modelo_prueba;

import java.sql.*;
import java.util.ArrayList;

public class DAOprueba {
    private Connection con = null;

    public static DAOprueba instance = null;

    public DAOprueba() throws SQLException, ClassNotFoundException {
        con = DBConnection.getConnection();


    }

    public static DAOprueba getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new DAOprueba();
        return instance;
    }

    public void insert(modelo_prueba t) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO pruebajdbc2 (id,nombre, apellido, correo) VALUES (?,?,?,?)");
        ps.setInt(1, t.getId());
        ps.setString(2, t.getNombre());
        ps.setString(3, t.getApellido());
        ps.setString(4, t.getEmail());

        System.out.println(ps.toString());
        ps.executeUpdate();
        ps.close();

    }
    public void insert(Tarea t) throws SQLException {
        System.out.println(t.toString());
        PreparedStatement ps = con.prepareStatement("INSERT INTO tarea"
                + " (titulo, categoria, importancia,fecha_inicio, fecha_fin,dependencia,descripcion,estado) VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1, t.getTitulo());
        ps.setString(7, t.getDescripcion());
        ps.setInt(2, t.getCategoria());
        ps.setInt(3, t.getImportante());
        ps.setInt(6, t.getDepende());
        ps.setDate(4, Date.valueOf(t.getFecha_inicio()));
        ps.setDate(5, Date.valueOf(t.getFecha_fin()));
        ps.setInt(8, t.getEstado());

        ps.executeUpdate();
        ps.close();
    }

    public void update(Tarea t) throws SQLException {

        PreparedStatement ps = con.prepareStatement("UPDATE tarea SET titulo = ?, descripcion = ?, categoria= ?, importancia= ?, depende= ?, fecha_inicio= ?, fecha_fin= ?, estado= ? WHERE id = ?");
        ps.setString(1, t.getTitulo());
        ps.setString(2, t.getDescripcion());
        ps.setInt(3, t.getCategoria());
        ps.setInt(4, t.getImportante());
        ps.setInt(5, t.getDepende());
        ps.setDate(6, Date.valueOf(t.getFecha_inicio()));
        ps.setDate(7, Date.valueOf(t.getFecha_fin()));
        ps.setInt(8, t.getEstado());
        ps.setInt(9, t.getId());
        ps.executeUpdate();
        ps.close();

    }

    public ArrayList<Tarea> listaTareas() throws Exception {

        ArrayList<Tarea> lista = new ArrayList<Tarea>();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea");
        ResultSet resultado = ps.executeQuery();

        while (resultado.next()) {

            Tarea t = new Tarea(resultado.getInt("id"), resultado.getString("titulo"),
                    resultado.getString("descripcion"), resultado.getInt("categoria"),
                    resultado.getInt("importancia"), resultado.getInt("depende"), resultado.getDate("fecha_inicio").toLocalDate(), resultado.getDate("fecha_fin").toLocalDate(),
                    resultado.getInt("estado"));
            lista.add(t);
        }
        resultado.close();
        ps.close();

        return lista;
    }

    public Tarea buscarID(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM tarea WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Tarea result = null;
        if (rs.next()) {
            result = new Tarea(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"), rs.getInt("categoria"),
                    rs.getInt("importancia"), rs.getInt("depende"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate(),
                    rs.getInt("estado"));
        }
        rs.close();
        ps.close();
        return result;
    }

    public void delete(Tarea t) throws SQLException {
        delete(t.getId());
    }

    public void delete(int id) throws SQLException {
        if (id <= 0)
            return;

        PreparedStatement ps = con.prepareStatement("DELETE FROM tarea WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

}