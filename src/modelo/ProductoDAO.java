package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO implements CRUD {
    // Variables para gestionar la conexión a la base de datos, declaraciones y resultados
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    
    //Actualiza el stock de un producto dado un valor y el ID del producto.
    public int actualizarStock(int cant, int idp) {
        String sql = "update producto set Stock=? where ID=?";
        int r = 0;
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, idp);
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    //Recupera un producto por su ID.
    public Producto listarId(int id) {
        Producto p = new Producto();
        String sql = "select * from producto where ID=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setDni(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setPrecio(rs.getInt(4));
                p.setStock(rs.getInt(5));
                p.setEstado(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    
    //Lista todos los productos de la base de datos.
    @Override
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setDni(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setPrecio(rs.getInt(4));
                p.setStock(rs.getInt(5));
                p.setEstado(rs.getInt(6));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //Añade un nuevo producto a la base de datos.
    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into producto(Dni,Nombre,Precio,Stock,Estado)values(?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    //Actualiza un producto existente en la base de datos.
    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update producto set Dni=?,Nombre=?,Precio=?,Stock=?,Estado=? where ID=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    //Elimina un producto de la base de datos dado su ID.
    @Override
    public void eliminar(int id) {
        String sql = "delete from producto where ID=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
