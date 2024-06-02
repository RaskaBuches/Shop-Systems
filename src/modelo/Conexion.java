package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Atributos de la clase
    Connection con;
    String url = "jdbc:mysql://localhost:3306/shop_systems";
    String user = "root";
    String pass = "";

    //Metodo para Conectar
    public Connection Conectar() {
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión utilizando la URL, el usuario y la contraseña
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conecto"); // Mensaje de éxito en la conexión
        } catch (ClassNotFoundException | SQLException e) {
            System.err.print(e); // Imprimir el error en la consola
            System.out.println("No conecto"); // Mensaje de fallo en la conexión
        }
        // Retornar el objeto Connection (puede ser null si no se estableció la conexión)
        return con;
    }
}


