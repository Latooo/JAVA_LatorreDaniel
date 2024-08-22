package presentacion;

import logica.Conection;
import logica.Tarjeta;
import logica.TarjetaDAO;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class DemoBanco {
    public static void main(String[] args) {
        Conection conexion = new Conection();
        Connection con = conexion.getConnection();
        
        if (con == null) {
            System.err.println("No se pudo establecer la conexión a la base de datos.");
            return;
        }

        TarjetaDAO tarjetaDAO = new TarjetaDAO(con);

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("""
                               1. Consulta general de todas las tarjetas
                               2. Consulta de tarjetas por mes
                               3. Salir
                               Digite una opción del menú""");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    try {
                        List<Tarjeta> tarjetas = tarjetaDAO.obtenerTodasLasTarjetas();
                        imprimirTarjetas(tarjetas);
                    } catch (Exception e) {
                        System.err.println("Error al obtener todas las tarjetas: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Digite el mes que desea consultar: ");
                    String mes = sc.next();
                    try {
                        List<Tarjeta> tarjetasMes = tarjetaDAO.obtenerTarjetasPorMes(mes);
                        imprimirTarjetas(tarjetasMes);
                    } catch (Exception e) {
                        System.err.println("Error al obtener las tarjetas del mes " + mes + ": " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }
        } while (opcion != 3);

        conexion.closeConnection();
    }

    public static void imprimirTarjetas(List<Tarjeta> tarjetas) {
        for (Tarjeta tarjeta : tarjetas) {
            System.out.println(tarjeta);
        }
    }
}
