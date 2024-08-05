package baloncesto;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    private static final DBManager dbManager = new DBManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Añadir partido");
            System.out.println("2. Listar partidos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addPartido(scanner);
                    break;
                case 2:
                    dbManager.listPartidos();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void addPartido(Scanner scanner) {
        scanner.nextLine();  // Consumir nueva línea
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        System.out.print("Equipo local: ");
        String equipoLocal = scanner.nextLine();

        System.out.print("Equipo visitante: ");
        String equipoVisitante = scanner.nextLine();

        System.out.print("¿Finalizado? (true/false): ");
        boolean finalizado = scanner.nextBoolean();

        Partido partido = new Partido(fecha, equipoLocal, equipoVisitante, finalizado);
        dbManager.addPartido(partido);

        System.out.print("Tipo de partido (liga/playoff): ");
        scanner.nextLine();  // Consumir nueva línea
        String tipo = scanner.nextLine();

        System.out.print("Cestas locales: ");
        int cestasLocal = scanner.nextInt();

        System.out.print("Cestas visitantes: ");
        int cestasVisitante = scanner.nextInt();

        int partidoId = getLastInsertedPartidoId();

        if ("liga".equalsIgnoreCase(tipo)) {
            dbManager.addLiga(partidoId, cestasLocal, cestasVisitante);
        } else if ("playoff".equalsIgnoreCase(tipo)) {
            dbManager.addPlayoff(partidoId, cestasLocal, cestasVisitante);
        } else {
            System.out.println("Tipo de partido no válido");
        }
    }

    private static int getLastInsertedPartidoId() {
        // Implementa la lógica para obtener el último id insertado en la tabla Partidos
        // Puedes usar una consulta SQL o un método de tu gestor de bases de datos
        // Aquí solo se incluye un ejemplo simple (suponiendo que es el último id)
        return -1;  // Debes implementar este método correctamente
    }
}

