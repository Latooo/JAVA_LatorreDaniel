package campuslands;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static CampusLands campusLands = new CampusLands();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            menuPrincipal();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    menuCoordinador();
                    break;
                case 2:
                    menuTrainer();
                    break;
                case 3:
                    menuCamper();
                    break;
                case 4:
                    reportes();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente nuevamente.");
            }
        }
    }

    private static void menuPrincipal() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Iniciar Sesión como Coordinador");
        System.out.println("2. Iniciar Sesión como Trainer");
        System.out.println("3. Iniciar Sesión como Camper");
        System.out.println("4. Reportes");
        System.out.println("5. Salir del programa");
    }

    private static void menuCoordinador() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menú Coordinador ---");
            System.out.println("1. Agregar nuevo estudiante");
            System.out.println("2. Editar información de un estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Modificar información de una clase");
            System.out.println("5. Agregar notas y actualizar estado del estudiante");
            System.out.println("6. Agregar nueva ruta de estudio");
            System.out.println("7. Listar estudiantes inscritos");
            System.out.println("8. Listar estudiantes aprobados");
            System.out.println("9. Listar estudiantes reprobados");
            System.out.println("10. Listar todas las clases");
            System.out.println("11. Agregar estudiantes a un grupo");
            System.out.println("12. Matricular estudiante");
            System.out.println("13. Asignar trainer");
            System.out.println("14. Salir del programa");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registrarCamper();
                    break;
                case 2:
                    editarCamper();
                    break;
                case 3:
                    eliminarCamper();
                    break;
                case 4:
                    modificarClase();
                    break;
                case 5:
                    registrarNota();
                    break;
                case 6:
                    agregarRuta();
                    break;
                case 7:
                    listarCampersInscritos();
                    break;
                case 8:
                    listarCampersAprobados();
                    break;
                case 9:
                    listarCampersReprobados();
                    break;
                case 10:
                    listarClases();
                    break;
                case 11:
                    agregarCamperAGrupo();
                    break;
                case 12:
                    matricularEstudiante();
                    break;
                case 13:
                    asignarTrainer();
                    break;
                case 14:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente nuevamente.");
            }
        }
    }

    private static void registrarCamper() {
        System.out.print("Ingrese ID del Camper: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese acudiente: ");
        String acudiente = scanner.nextLine();
        System.out.print("Ingrese teléfono celular: ");
        String telefonoCelular = scanner.nextLine();
        System.out.print("Ingrese teléfono fijo: ");
        String telefonoFijo = scanner.nextLine();
        System.out.print("Ingrese estado: ");
        String estado = scanner.nextLine();

        double riesgo = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Ingrese riesgo: ");
                riesgo = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número decimal para el riesgo.");
            }
        }

        Camper camper = new Camper(id, nombres, apellidos, direccion, acudiente, telefonoCelular, telefonoFijo, estado, riesgo);
        campusLands.registrarCamper(camper);
        System.out.println("Camper registrado exitosamente.");
    }

    private static void editarCamper() {
        System.out.print("Ingrese ID del Camper a editar: ");
        String id = scanner.nextLine();
        Camper camper = campusLands.buscarCamperPorId(id);

        if (camper != null) {
            System.out.print("Ingrese nuevos nombres (actual: " + camper.getNombres() + "): ");
            String nombres = scanner.nextLine();
            camper.setNombres(nombres);

            System.out.print("Ingrese nuevos apellidos (actual: " + camper.getApellidos() + "): ");
            String apellidos = scanner.nextLine();
            camper.setApellidos(apellidos);

            System.out.print("Ingrese nueva dirección (actual: " + camper.getDireccion() + "): ");
            String direccion = scanner.nextLine();
            camper.setDireccion(direccion);

            System.out.print("Ingrese nuevo acudiente (actual: " + camper.getAcudiente() + "): ");
            String acudiente = scanner.nextLine();
            camper.setAcudiente(acudiente);

            System.out.print("Ingrese nuevo teléfono celular (actual: " + camper.getTelefonoCelular() + "): ");
            String telefonoCelular = scanner.nextLine();
            camper.setTelefonoCelular(telefonoCelular);

            System.out.print("Ingrese nuevo teléfono fijo (actual: " + camper.getTelefonoFijo() + "): ");
            String telefonoFijo = scanner.nextLine();
            camper.setTelefonoFijo(telefonoFijo);

            System.out.print("Ingrese nuevo estado (actual: " + camper.getEstado() + "): ");
            String estado = scanner.nextLine();
            camper.setEstado(estado);

            double riesgo = -1;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Ingrese nuevo riesgo (actual: " + camper.getRiesgo() + "): ");
                    riesgo = Double.parseDouble(scanner.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número decimal para el riesgo.");
                }
            }
            camper.setRiesgo(riesgo);

            System.out.println("Camper editado exitosamente.");
        } else {
            System.out.println("Camper no encontrado.");
        }
    }

    private static void eliminarCamper() {
        System.out.print("Ingrese ID del Camper a eliminar: ");
        String id = scanner.nextLine();
        campusLands.eliminarCamper(id);
        System.out.println("Camper eliminado exitosamente.");
    }

    private static void listarCampersInscritos() {
        System.out.println("\n--- Listado de Campers Inscritos ---");
        for (Camper camper : campusLands.listarCampers()) {
            System.out.println(camper.getId() + " - " + camper.getNombres() + " " + camper.getApellidos());
        }
    }

    private static void registrarNota() {
        // Implementar lógica para registrar nota y actualizar estado del estudiante
    }

    private static void modificarClase() {
        // Implementar lógica para modificar información de una clase
    }

    private static void agregarRuta() {
        // Implementar lógica para agregar nueva ruta de estudio
    }

    private static void listarCampersAprobados() {
        System.out.println("\n--- Listado de Campers Aprobados ---");
        for (Camper camper : campusLands.listarCampersAprobados()) {
            System.out.println(camper.getId() + " - " + camper.getNombres() + " " + camper.getApellidos());
        }
    }

    private static void listarCampersReprobados() {
        System.out.println("\n--- Listado de Campers Reprobados ---");
        for (Camper camper : campusLands.listarCampersBajoRendimiento()) {
            System.out.println(camper.getId() + " - " + camper.getNombres() + " " + camper.getApellidos());
        }
    }

    private static void listarClases() {
        // Implementar lógica para listar todas las clases
    }

    private static void agregarCamperAGrupo() {
        // Implementar lógica para agregar estudiantes a un grupo
    }

    private static void matricularEstudiante() {
        // Implementar lógica para matricular estudiante
    }

    private static void asignarTrainer() {
        // Implementar lógica para asignar trainer
    }

    private static void menuTrainer() {
        // Implementar menú y lógica para el Trainer
    }

    private static void menuCamper() {
        System.out.println("\n--- Acceso denegado ---");
        System.out.println("Los campers no tienen acceso a este sistema.");
    }

    private static void reportes() {
        // Implementar módulo de reportes
    }
}
