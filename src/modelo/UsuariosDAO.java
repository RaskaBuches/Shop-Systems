package modelo;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class UsuariosDAO implements CRUD {
    // Variables para gestionar la conexión a la base de datos, declaraciones y resultados
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    
    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    //Añade un nuevo usuario a la base de datos.
    @Override
    public int add(Object[] o) {
        int r = 0;
        // Consulta SQL para insertar un nuevo usuario
        String sql = "insert into usuarios(NombreUsuario,Contrasena,Nombre,Apellido,Fecha)values(?,?,?,?,?)";
        try {
            con = cn.Conectar(); // Conectar a la base de datos
            ps = con.prepareStatement(sql); // Preparar la declaración SQL
            // Establecer los valores de los parámetros de la consulta
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate(); // Ejecutar la consulta
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return r; // Retornar el número de filas afectadas
    }

    @Override
    public int actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

