package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VentasDao implements CRUD {
    // Variables para gestionar la conexión a la base de datos, declaraciones y resultados
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    //Obtiene el número de serie más alto de las ventas.
    public String NroSerieVentas() {
        String serie = "00000"; // Valor por defecto
        String sql = "select max(NumSerie) from ventas";
        try {
            con = cn.Conectar(); // Conectar a la base de datos
            ps = con.prepareStatement(sql); // Preparar la declaración SQL
            rs = ps.executeQuery(); // Ejecutar la consulta
            if (rs.next() && rs.getString(1) != null) {
                serie = rs.getString(1); // Obtener el número de serie más alto
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return serie;
    }
    
    //Obtiene el ID de la última venta.
    public String IdVentas() {
        String idv = "";
        String sql = "select max(IdVentas) from ventas";
        try {
            con = cn.Conectar(); // Conectar a la base de datos
            ps = con.prepareStatement(sql); // Preparar la declaración SQL
            rs = ps.executeQuery(); // Ejecutar la consulta
            if (rs.next()) {
                idv = rs.getString(1); // Obtener el ID de la última venta
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error para depuración
        }
        return idv;
    }

    //Guarda una nueva venta en la base de datos.
    public int GuardarVentas(Ventas v) {
        String sql = "insert into ventas(NumSerie,IdUsuario,FechaVentas,Monto,Estado)values(?,?,?,?,?)";
        try {
            con = cn.Conectar(); // Conectar a la base de datos
            ps = con.prepareStatement(sql); // Preparar la declaración SQL
            // Establecer los valores de los parámetros de la consulta
            ps.setString(1, v.getNumSerie());
            ps.setInt(2, v.getIdUsuario());
            ps.setString(3, v.getFechaVentas());
            ps.setDouble(4, v.getMonto());
            ps.setString(5, v.getEstado());
            r = ps.executeUpdate(); // Ejecutar la consulta
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r; // Retornar el número de filas afectadas
    }

    //Guarda los detalles de una venta en la base de datos.
    public int GuardarDetalleVentas(Detalle_Ventas dv) {
        String sql = "insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try {
            con = cn.Conectar(); // Conectar a la base de datos
            ps = con.prepareStatement(sql); // Preparar la declaración SQL
            // Establecer los valores de los parámetros de la consulta
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPreventa());
            r = ps.executeUpdate(); // Ejecutar la consulta
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error para depuración
        }
        return r; // Retornar el número de filas afectadas
    }

    //Lista todas las ventas de la base de datos.
    @Override
    public List<Ventas> listar() {
        List<Ventas> lista = new ArrayList<>();
        String sql = "select * from ventas";
        try {
            con = cn.Conectar(); // Conectar a la base de datos
            ps = con.prepareStatement(sql); // Preparar la declaración SQL
            rs = ps.executeQuery(); // Ejecutar la consulta
            while (rs.next()) {
                Ventas v = new Ventas();
                v.setIdVentas(rs.getInt(1));
                v.setNumSerie(rs.getString(2));
                v.setIdUsuario(rs.getInt(3));
                v.setFechaVentas(rs.getString(4));
                v.setMonto(rs.getInt(5));
                v.setEstado(rs.getString(6));
                lista.add(v); // Añadir la venta a la lista
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); // Método aún no implementado
    }

    @Override
    public int actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); // Método aún no implementado
    }
    
    //Elimina una venta de la base de datos dado su ID.
    @Override
    public void eliminar(int id) {
        String sql = "delete from ventas where IdVentas=?";
        try {
            con = cn.Conectar(); // Conectar a la base de datos
            ps = con.prepareStatement(sql); // Preparar la declaración SQL
            ps.setInt(1, id); // Establecer el ID de la venta a eliminar
            ps.executeUpdate(); // Ejecutar la consulta
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error para depuración
        }
    }
}

