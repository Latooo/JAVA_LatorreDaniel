package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO {

    private Connection con;

    public TarjetaDAO(Connection con) {
        this.con = con;
        
    }

    // Consulta para obtener todas las tarjetas
    public List<Tarjeta> obtenerTodasLasTarjetas() {
        List<Tarjeta> tarjetas = new ArrayList<>();
        String sql = "SELECT * FROM tarjetas";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String numero = rs.getString("numeroCuenta");
                double montoApertura = rs.getDouble("montoApertura");
                String tipo = rs.getString("tipoTarjeta");
                String mes = rs.getString("mes");

                // Dependiendo del tipo, crea una instancia de la clase correcta
                Tarjeta tarjeta;
                switch (tipo.toLowerCase()) {
                    case "joven" -> tarjeta = new Joven(numero, montoApertura, mes);
                    case "nomina" -> tarjeta = new Nomina(numero, montoApertura, mes);
                    case "visa" -> tarjeta = new Visa(numero, montoApertura, mes);
                    default -> throw new IllegalArgumentException("Tipo de tarjeta no válido");
                }

                tarjetas.add(tarjeta);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener todas las tarjetas: " + e.getMessage());
        }

        return tarjetas;
    }

    // Consulta para obtener las tarjetas de un mes específico
    public List<Tarjeta> obtenerTarjetasPorMes(String mes) {
        List<Tarjeta> tarjetas = new ArrayList<>();
        String sql = "SELECT * FROM tarjetas WHERE mes = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mes);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String numero = rs.getString("numeroCuenta");
                double montoApertura = rs.getDouble("montoApertura");
                String tipo = rs.getString("tipoTarjeta");

                // Dependiendo del tipo, crea una instancia de la clase correcta
                Tarjeta tarjeta;
                switch (tipo.toLowerCase()) {
                    case "joven" -> tarjeta = new Joven(numero, montoApertura, mes);
                    case "nomina" -> tarjeta = new Nomina(numero, montoApertura, mes);
                    case "visa" -> tarjeta = new Visa(numero, montoApertura, mes);
                    default -> throw new IllegalArgumentException("Tipo de tarjeta no válido");
                }

                tarjetas.add(tarjeta);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener las tarjetas del mes " + mes + ": " + e.getMessage());
        }

        return tarjetas;
    }
}