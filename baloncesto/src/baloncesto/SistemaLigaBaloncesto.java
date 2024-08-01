import java.util.ArrayList;
import java.util.Scanner;

public class SistemaLigaBaloncesto {
    private static ArrayList<Partido> partidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Gestión de Partidos:");
            System.out.println("1. Registrar partido de liga");
            System.out.println("2. Registrar partido de playOff");
            System.out.println("3. Finalizar partido");
            System.out.println("4. Mostrar ganador de un partido");
            System.out.println("5. Mostrar información de un partido");
            System.out.println("6. Mostrar todos los partidos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarPartidoLiga(scanner);
                    break;
                case 2:
                    registrarPartidoPlayOff(scanner);
                    break;
                case 3:
                    finalizarPartido(scanner);
                    break;
                case 4:
                    mostrarGanador(scanner);
                    break;
                case 5:
                    mostrarInformacionPartido(scanner);
                    break;
                case 6:
                    mostrarTodosLosPartidos();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void registrarPartidoLiga(Scanner scanner) {
        System.out.print("Ingrese el equipo local: ");
        String equipoLocal = scanner.next();
        System.out.print("Ingrese el equipo visitante: ");
        String equipoVisitante = scanner.next();
        System.out.print("Ingrese la fecha del partido (YYYY-MM-DD): ");
        String fecha = scanner.next();
        System.out.print("Ingrese la jornada: ");
        int jornada = scanner.nextInt();

        Partido partido = new PartidoLiga(equipoLocal, equipoVisitante, fecha, jornada);
        partidos.add(partido);
        System.out.println("Partido de liga registrado.");
    }

    private static void registrarPartidoPlayOff(Scanner scanner) {
        System.out.print("Ingrese el equipo local: ");
        String equipoLocal = scanner.next();
        System.out.print("Ingrese el equipo visitante: ");
        String equipoVisitante = scanner.next();
        System.out.print("Ingrese la fecha del partido (YYYY-MM-DD): ");
        String fecha = scanner.next();
        System.out.print("Ingrese la ronda: ");
        String ronda = scanner.next();

        Partido partido = new PartidoPlayOff(equipoLocal, equipoVisitante, fecha, ronda);
        partidos.add(partido);
        System.out.println("Partido de playOff registrado.");
    }

    private static void finalizarPartido(Scanner scanner) {
        mostrarTodosLosPartidos();
        System.out.print("Ingrese el índice del partido a finalizar: ");
        int indice = scanner.nextInt();

        if (indice >= 0 && indice < partidos.size()) {
            Partido partido = partidos.get(indice);
            partido.finalizarPartido();
            if (partido.isFinalizado()) {
                System.out.println("Partido finalizado.");
            }
        } else {
            System.out.println("Índice no válido.");
        }
    }

    private static void mostrarGanador(Scanner scanner) {
        mostrarTodosLosPartidos();
        System.out.print("Ingrese el índice del partido: ");
        int indice = scanner.nextInt();

        if (indice >= 0 && indice < partidos.size()) {
            Partido partido = partidos.get(indice);
            System.out.println(partido.obtenerGanador());
        } else {
            System.out.println("Índice no válido.");
        }
    }

    private static void mostrarInformacionPartido(Scanner scanner) {
        mostrarTodosLosPartidos();
        System.out.print("Ingrese el índice del partido: ");
        int indice = scanner.nextInt();

        if (indice >= 0 && indice < partidos.size()) {
            Partido partido = partidos.get(indice);
            partido.mostrarInformacion();
        } else {
            System.out.println("Índice no válido.");
        }
    }

    private static void mostrarTodosLosPartidos() {
        System.out.println("\nPartidos registrados:");
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            System.out.print("Índice " + i + ": ");
            partido.mostrarInformacion();
        }
    }
}
