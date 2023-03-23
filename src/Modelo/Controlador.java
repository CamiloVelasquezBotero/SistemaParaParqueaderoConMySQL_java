package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador {

    public boolean registrar(Vehiculo vehiculo) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;

        try {
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("insert into registrovehiculos (placa,nombrePropietario,tipoDeVehiculo,horaEntrada,estado) values (?,?,?,?,?)");
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getNombrePropietario());
            ps.setString(3, vehiculo.getTipoDeVehiculo());
            ps.setString(4, vehiculo.getHoraEntrada());
            ps.setString(5, "si");
            ps.executeUpdate();

            return true;

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return false;
        }
    }

    public boolean retirar(Vehiculo vehiculo) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;

        try {
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("update registrovehiculos set horaSalida = (?), estado = (?) where placa=?");
            ps.setString(1, vehiculo.getHoraSalida());
            ps.setString(2, vehiculo.getEstado());
            ps.setString(3, vehiculo.getPlaca());
            ps.executeUpdate();

            return true;

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return false;
        }
    }
    
    public boolean eliminarVehiculo(Vehiculo vehiculo){
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        
        try{
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("delete from registrovehiculos where placa = ?");
            ps.setString(1, vehiculo.getPlaca());
            ps.executeUpdate();
            
            return true;
        }catch(Exception ex){
            System.err.println("Error, " + ex);
            return false;
        }
    }
    
    public int verificarPlaca(Vehiculo vehiculo) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("select count(id) from registrovehiculos where placa=?");
            ps.setString(1, vehiculo.getPlaca());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 1;
            }
        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return 1;
        }
    }

    public boolean valorCobrar(Vehiculo vehiculo) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String tipoDeVehiculo = "";
        String stringEntrada = "";
        int horaEntrada;
        int horaSalida;
        int horas;
        double valorPagar;

        try {    //Obteniendo la hora de entrada del vehiculo para calcular con la hora de salida
            Connection conexion = con.getConnection();
            ps = conexion.prepareStatement("select horaEntrada,tipoDeVehiculo from registrovehiculos where placa=?");
            ps.setString(1, vehiculo.getPlaca());
            rs = ps.executeQuery();

            if (rs.next()) {
                stringEntrada = rs.getString("horaEntrada");
                tipoDeVehiculo = rs.getString("tipoDeVehiculo");
            }

            //Convirtiendo el time de string a date para luego convertirlo a int y poder obtener el valorPagar
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date entrada = formato.parse(stringEntrada);    //Convierto de string a tipo date
            Date salida = formato.parse(vehiculo.getHoraSalida());

            Calendar calendar = Calendar.getInstance(); //Obtengo las horas de la entrad y la salida en tipo int
            calendar.setTime(entrada);
            horaEntrada = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(salida);
            horaSalida = calendar.get(Calendar.HOUR_OF_DAY);

            horas = horaSalida - horaEntrada;

            if (horas > 0) {
                if (tipoDeVehiculo.equals("Automovil")) {   //Hago la multiplicacion de las horas, por el precio
                    valorPagar = horas * 1.5;
                    JOptionPane.showMessageDialog(null, "El valor a pagar es: $" + valorPagar);
                } else if (tipoDeVehiculo.equals("Motocicleta")) {
                    valorPagar = horas * 1;
                    JOptionPane.showMessageDialog(null, "El valor a pagar es: $" + valorPagar);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No debe horas");
            }
            return true;

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return false;
        }

    }
    
    public String parqueaderosEnUSO(){
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int enUso = 0;
        
        try{
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("select count(id) from registrovehiculos where estado='si'");
            rs = ps.executeQuery();
            
            if(rs.next()){
                enUso = rs.getInt(1);
            }
        }catch(Exception ex){
            System.err.println("Error, "+ex);
        }
        
        String numero = String.valueOf(enUso);
        return numero;
    }
    
    public String verificarEstado(Vehiculo vehiculo) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("select estado from registrovehiculos where placa=?");
            ps.setString(1, vehiculo.getPlaca());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return rs.getString(1);
            }
        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return "no";
        }
    }
    
    public DefaultTableModel obtenerRegistros(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Placa");
        modelo.addColumn("Nombre Propietario");
        modelo.addColumn("Tipo");
        modelo.addColumn("Entrada");
        modelo.addColumn("Salida");
        modelo.addColumn("Pagado");
        modelo.addColumn("Estado");
        
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("select placa, nombrePropietario, tipoDeVehiculo, horaEntrada, horaSalida, valorPagado, estado from registrovehiculos");
            rs = ps.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[7];
                for(int i=0; i<7; i++){
                    fila[i] = rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar la base de datos");
            System.err.println("Error," + ex);
        }
        return modelo;
    }
    
    public boolean ActualizarRegistros(Vehiculo vehiculo, String placaActual){
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        
        try{
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("update registrovehiculos set nombrePropietario=?,tipoDeVehiculo=? where placa=?");
            ps.setString(1, vehiculo.getNombrePropietario());
            ps.setString(2, vehiculo.getTipoDeVehiculo());
            ps.setString(3, placaActual);
            ps.executeUpdate();
            
            return true;
        }catch(Exception ex){
            System.err.println("Error, " + ex);
            return false;
        }
    }
}
