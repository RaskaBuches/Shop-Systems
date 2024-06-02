
package modelo;

public class Ventas {
    int idVentas;
    String NumSerie;
    int IdUsuario;
    String FechaVentas;
    double monto;
    String estado;

    public Ventas() {
    }

    public Ventas(int idVentas, String NumSerie, int IdUsuario, String FechaVentas, double monto, String estado) {
        this.idVentas = idVentas;
        this.NumSerie = NumSerie;
        this.IdUsuario = IdUsuario;
        this.FechaVentas = FechaVentas;
        this.monto = monto;
        this.estado = estado;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String NumSerie) {
        this.NumSerie = NumSerie;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getFechaVentas() {
        return FechaVentas;
    }

    public void setFechaVentas(String FechaVentas) {
        this.FechaVentas = FechaVentas;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
