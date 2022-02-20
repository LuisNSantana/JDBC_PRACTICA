package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final String JDBC_URL="jdbc:mysql://mysql-5703.dinaserver.com:3306/ciberkaos023";
    private static Connection instance=null;

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        if (instance == null) {
            Properties props = new Properties();
            props.put("user", "uss023");
            props.put("password", "serpiente2019");
            instance = DriverManager.getConnection(JDBC_URL, props);
        }
        return instance;
    }





}
