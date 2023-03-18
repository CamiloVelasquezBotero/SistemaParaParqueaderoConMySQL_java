
package Modelo;

public class Vehiculo {
    private String placa;  
    private String nombrePropietario;
    private String tipoDeVehiculo;
    private String horaEntrada;
    private String horaSalida;
    private double valorPagado;
    private String estado;

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getNombrePropietario() {
        return nombrePropietario;
    }
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    public String getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }
    public void setTipoDeVehiculo(String tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }
    public String getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public String getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    public double getValorPagado() {
        return valorPagado;
    }
    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }      
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
