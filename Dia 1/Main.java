package campuslands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static CampusLands campusLands = new CampusLands();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarCamper(scanner);
                    break;
                case 2:
                    registrarNota(scanner);
                    break;
                case 3:
                    listarCampers();
                    break;
                case 4:
                    listarCampersAprobados();
                    break;
                case 5:
                    listarTrainers();
                    break;
                case 6:
                    listarCampersBajoRendimiento();
                    break;
                case 7:
                    listarCampersPorRuta();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Registrar Camper");
        System.out.println("2. Registrar Nota");
        System.out.println("3. Listar Campers");
        System.out.println("4. Listar Campers Aprobados");
        System.out.println("5. Listar Trainers");
        System.out.println("6. Listar Campers con Bajo Rendimiento");
        System.out.println("7. Listar Campers por Ruta");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarCamper(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Acudiente: ");
        String acudiente = scanner.nextLine();
        System.out.print("Teléfono Celular: ");
        String telefonoCelular = scanner.nextLine();
        System.out.print("Teléfono Fijo: ");
        String telefonoFijo = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Riesgo: ");
        double riesgo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        Camper camper = new Camper(id, nombres, apellidos, direccion, acudiente, telefonoCelular, telefonoFijo, estado, riesgo);
        campusLands.registrarCamper(camper);
        System.out.println("Camper registrado exitosamente.");
    }

    private static void registrarNota(Scanner scanner) {
        System.out.print("ID del Camper: ");
        String id = scanner.nextLine();
        Camper camper = campusLands.buscarCamperPorId(id);
        
        if (camper != null) {
            System.out.print("Nota Teórica: ");
            double notaTeorica = scanner.nextDouble();
            System.out.print("Nota Práctica: ");
            double notaPractica = scanner.nextDouble();
            System.out.print("Nota Quizzes: ");
            double notaQuizzes = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            campusLands.getCoordinador().registrarNota(camper, notaTeorica, notaPractica, notaQuizzes);
            System.out.println("Nota registrada exitosamente.");
        } else {
            System.out.println("Camper no encontrado.");
        }
    }

    private static void listarCampers() {
        List<Camper> campers = campusLands.getCampers();
        for (Camper camper : campers) {
            System.out.println(camper);
        }
    }

    private static void listarCampersAprobados() {
        List<Camper> campersAprobados = campusLands.listarCampersAprobados();
        for (Camper camper : campersAprobados) {
            System.out.println(camper);
        }
    }

    private static void listarTrainers() {
        List<Trainer> trainers = campusLands.getTrainers();
        for (Trainer trainer : trainers) {
            System.out.println(trainer);
        }
    }

    private static void listarCampersBajoRendimiento() {
        List<Camper> campersBajoRendimiento = campusLands.listarCampersBajoRendimiento();
        for (Camper camper : campersBajoRendimiento) {
            System.out.println(camper);
        }
    }

    private static void listarCampersPorRuta() {
        // Implementar esta funcionalidad según la estructura de datos
    }
}

