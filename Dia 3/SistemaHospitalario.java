package sih;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaHospitalario {
    private static List<Hospital> hospitales = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume la nueva línea

            switch (opcion) {
                case 1:
                    agregarHospital();
                    break;
                case 2:
                    agregarDepartamento();
                    break;
                case 3:
                    agregarPersonal();
                    break;
                case 4:
                    agregarPaciente();
                    break;
                case 5:
                    listarHospitales();
                    break;
                case 6:
                    listarDepartamentos();
                    break;
                case 7:
                    listarPersonal();
                    break;
                case 8:
                    listarPacientes();
                    break;
                case 9:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Sistema Integrado Hospitalario");
        System.out.println("1. Agregar Hospital");
        System.out.println("2. Agregar Departamento");
        System.out.println("3. Agregar Personal");
        System.out.println("4. Agregar Paciente");
        System.out.println("5. Listar Hospitales");
        System.out.println("6. Listar Departamentos");
        System.out.println("7. Listar Personal");
        System.out.println("8. Listar Pacientes");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarHospital() {
        System.out.print("Ingrese el nombre del hospital: ");
        String nombre = scanner.nextLine();
        hospitales.add(new Hospital(nombre));
        System.out.println("Hospital agregado.");
    }

    private static void agregarDepartamento() {
        System.out.print("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        Hospital hospital = buscarHospital(nombreHospital);

        if (hospital != null) {
            System.out.print("Ingrese el nombre del departamento: ");
            String nombre = scanner.nextLine();
            hospital.agregarDepartamento(new Departamento(nombre));
            System.out.println("Departamento agregado.");
        } else {
            System.out.println("Hospital no encontrado.");
        }
    }

    private static void agregarPersonal() {
        System.out.print("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        Hospital hospital = buscarHospital(nombreHospital);

        if (hospital != null) {
            System.out.print("Ingrese el nombre del departamento: ");
            String nombreDepartamento = scanner.nextLine();
            Departamento departamento = buscarDepartamento(hospital, nombreDepartamento);

            if (departamento != null) {
                System.out.print("Ingrese el tipo de personal (Doctor/Enfermera): ");
                String tipo = scanner.nextLine();
                System.out.print("Ingrese el título: ");
                String titulo = scanner.nextLine();
                System.out.print("Ingrese el nombre de pila: ");
                String nombrePila = scanner.nextLine();
                System.out.print("Ingrese el segundo nombre: ");
                String segundoNombre = scanner.nextLine();
                System.out.print("Ingrese el apellido: ");
                String apellido = scanner.nextLine();
                System.out.print("Ingrese la dirección: ");
                String direccion = scanner.nextLine();
                System.out.print("Ingrese la fecha de vinculación (AAAA-MM-DD): ");
                LocalDate fechaVinculacion = LocalDate.parse(scanner.nextLine());
                System.out.print("Ingrese el salario: ");
                double salario = scanner.nextDouble();
                scanner.nextLine();  // Consume la nueva línea

                if (tipo.equalsIgnoreCase("Doctor")) {
                    System.out.print("¿Es líder de equipo? (true/false): ");
                    boolean esLider = scanner.nextBoolean();
                    scanner.nextLine();  // Consume la nueva línea
                    Doctor doctor = new Doctor(titulo, nombrePila, segundoNombre, apellido, direccion, fechaVinculacion, salario, esLider);
                    departamento.agregarPersonal(doctor);
                } else if (tipo.equalsIgnoreCase("Enfermera")) {
                    Enfermera enfermera = new Enfermera(titulo, nombrePila, segundoNombre, apellido, direccion, fechaVinculacion, salario);
                    departamento.agregarPersonal(enfermera);
                } else {
                    System.out.println("Tipo de personal no válido.");
                }

                System.out.println("Personal agregado.");
            } else {
                System.out.println("Departamento no encontrado.");
            }
        } else {
            System.out.println("Hospital no encontrado.");
        }
    }

    private static void agregarPaciente() {
        System.out.print("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        Hospital hospital = buscarHospital(nombreHospital);

        if (hospital != null) {
            System.out.print("Ingrese el título: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese el nombre de pila: ");
            String nombrePila = scanner.nextLine();
            System.out.print("Ingrese el segundo nombre: ");
            String segundoNombre = scanner.nextLine();
            System.out.print("Ingrese el apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Ingrese la dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Ingrese la fecha de nacimiento (AAAA-MM-DD): ");
            LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
            System.out.print("Ingrese la fecha de ingreso (AAAA-MM-DD): ");
            LocalDate fechaIngreso = LocalDate.parse(scanner.nextLine());
            System.out.print("Ingrese el diagnóstico: ");
            String diagnostico = scanner.nextLine();

            Paciente paciente = new Paciente(titulo, nombrePila, segundoNombre, apellido, direccion, fechaNacimiento, fechaIngreso, diagnostico);
            hospital.agregarPersona(paciente);

            System.out.print("Ingrese el nombre del pabellón: ");
            String nombrePabellon = scanner.nextLine();
            Pabellon pabellon = buscarPabellon(hospital, nombrePabellon);

            if (pabellon != null) {
                pabellon.asignarPaciente(paciente);
                System.out.println("Paciente agregado y asignado al pabellón.");
            } else {
                System.out.println("Pabellón no encontrado.");
            }
        } else {
            System.out.println("Hospital no encontrado.");
        }
    }

    private static Hospital buscarHospital(String nombre) {
        for (Hospital hospital : hospitales) {
            if (hospital.getNombre().equalsIgnoreCase(nombre)) {
                return hospital;
            }
        }
        return null;
    }

    private static Departamento buscarDepartamento(Hospital hospital, String nombre) {
        for (Departamento departamento : hospital.getDepartamentos()) {
            if (departamento.getNombre().equalsIgnoreCase(nombre)) {
                return departamento;
            }
        }
        return null;
    }

    private static Pabellon buscarPabellon(Hospital hospital, String nombre) {
        // Implementación de búsqueda de pabellón en el hospital (se omite aquí por simplicidad)
        return null; // Placeholder, debe implementarse correctamente
    }

    private static void listarHospitales() {
        for (Hospital hospital : hospitales) {
            System.out.println("Hospital: " + hospital.getNombre());
        }
    }

    private static void listarDepartamentos() {
        System.out.print("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        Hospital hospital = buscarHospital(nombreHospital);

        if (hospital != null) {
            for (Departamento departamento : hospital.getDepartamentos()) {
                System.out.println("Departamento: " + departamento.getNombre());
            }
        } else {
            System.out.println("Hospital no encontrado.");
        }
    }

    private static void listarPersonal() {
        System.out.print("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        Hospital hospital = buscarHospital(nombreHospital);

        if (hospital != null) {
            System.out.print("Ingrese el nombre del departamento: ");
            String nombreDepartamento = scanner.nextLine();
            Departamento departamento = buscarDepartamento(hospital, nombreDepartamento);

            if (departamento != null) {
                for (Personal personal : departamento.getPersonal()) {
                    System.out.println("Personal: " + personal.getNombreCompleto());
                }
            } else {
                System.out.println("Departamento no encontrado.");
            }
        } else {
            System.out.println("Hospital no encontrado.");
        }
    }

    private static void listarPacientes() {
        System.out.print("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        Hospital hospital = buscarHospital(nombreHospital);

        if (hospital != null) {
            for (Persona persona : hospital.getPersonas()) {
                if (persona instanceof Paciente) {
                    System.out.println("Paciente: " + persona.getNombreCompleto());
                }
            }
        } else {
            System.out.println("Hospital no encontrado.");
        }
    }
}
