package modelo;

import dao.DAOprueba;

import java.sql.SQLException;

public class modelo_prueba {
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    @Override
    public String toString() {
        return "modelo_prueba [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
                + email + "]";
    }

    public modelo_prueba(){

    }

    public modelo_prueba(int id, String nombre, String apellido, String email) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void insertar() throws ClassNotFoundException {


        try {
            DAOprueba.getInstance().insert(this);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
