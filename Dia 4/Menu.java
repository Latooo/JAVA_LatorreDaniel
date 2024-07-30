import java.sql.*;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Seleccionar o Crear Hospital");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (option) {
                case 1:
                    manageHospital();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    private static void manageHospital() {
        int hospitalId = selectOrCreateHospital();

        if (hospitalId > 0) {
            int option;
            do {
                System.out.println("\nGestión del Hospital:");
                System.out.println("1. Añadir Departamento");
                System.out.println("2. Añadir Personal");
                System.out.println("3. Añadir Doctor");
                System.out.println("4. Añadir Paciente a Doctor");
                System.out.println("0. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                option = scanner.nextInt();
                scanner.nextLine();  // Consumir nueva línea

                switch (option) {
                    case 1:
                        addDepartamento(hospitalId);
                        break;
                    case 2:
                        addPersonal(hospitalId);
                        break;
                    case 3:
                        addDoctor(hospitalId);
                        break;
                    case 4:
                        assignPatientToDoctor();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (option != 0);
        }
    }

    private static int selectOrCreateHospital() {
        System.out.println("\nSeleccione un Hospital:");
        displayHospitals();

        System.out.print("ID del Hospital (0 para crear uno nuevo): ");
        int hospitalId = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        if (hospitalId == 0) {
            hospitalId = createHospital();
        }

        return hospitalId;
    }

    private static void displayHospitals() {
        String query = "SELECT id, nombre FROM Hospital";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.println(id + ": " + nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int createHospital() {
        System.out.print("Nombre del Hospital: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección del Hospital: ");
        String direccion = scanner.nextLine();

        String insertHospital = "INSERT INTO Hospital (nombre, direccion) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertHospital, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int hospitalId = generatedKeys.getInt(1);
                    System.out.println("Hospital creado exitosamente con ID: " + hospitalId);
                    return hospitalId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    private static void addDepartamento(int hospitalId) {
        System.out.print("Nombre del Departamento: ");
        String nombre = scanner.nextLine();

        String insertDepartamento = "INSERT INTO Departamento (nombre, hospital_id) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertDepartamento)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, hospitalId);
            stmt.executeUpdate();
            System.out.println("Departamento añadido exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addPersonal(int hospitalId) {
        System.out.print("ID de la Persona: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea
        System.out.print("Fecha de vinculación (YYYY-MM-DD): ");
        String fechaVinculacion = scanner.nextLine();
        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();  // Consumir nueva línea
        System.out.print("ID del Departamento: ");
        int departamentoId = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea
        System.out.print("Tipo de personal (administrativo/tecnico/operaciones): ");
        String tipoPersonal = scanner.nextLine();

        String tipoOperacion = null;
        String tipoTecnico = null;
        if (tipoPersonal.equalsIgnoreCase("operaciones")) {
            System.out.print("Tipo de operaciones (doctor/enfermera): ");
            tipoOperacion = scanner.nextLine();
        } else if (tipoPersonal.equalsIgnoreCase("tecnico")) {
            System.out.print("Tipo de técnico (tecnico/tecnologia): ");
            tipoTecnico = scanner.nextLine();
        }

        String insertPersonal = "INSERT INTO Personal (id, fecha_vinculacion, salario, departamento_id, tipo_personal, tipo_operacion, tipo_tecnico) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertPersonal)) {
            stmt.setInt(1, id);
            stmt.setDate(2, Date.valueOf(fechaVinculacion));
            stmt.setDouble(3, salario);
            stmt.setInt(4, departamentoId);
            stmt.setString(5, tipoPersonal);
            stmt.setString(6, tipoOperacion);
            stmt.setString(7, tipoTecnico);
            stmt.executeUpdate();
            System.out.println("Personal añadido exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addDoctor(int hospitalId) {
        System.out.print("ID del Personal: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea
        System.out.print("¿Es líder? (true/false): ");
        boolean esLider = scanner.nextBoolean();
        scanner.nextLine();  // Consumir nueva línea

        String insertDoctor = "INSERT INTO Doctor (id, es_lider) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertDoctor)) {
            stmt.setInt(1, id);
            stmt.setBoolean(2, esLider);
            stmt.executeUpdate();
            System.out.println("Doctor añadido exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void assignPatientToDoctor() {
        System.out.print("ID del Paciente: ");
        int pacienteId = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea
        System.out.print("ID del Doctor: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        String assignPatient = "INSERT INTO PacienteDoctor (paciente_id, doctor_id) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(assignPatient)) {
            stmt.setInt(1, pacienteId);
            stmt.setInt(2, doctorId);
            stmt.executeUpdate();
            System.out.println("Paciente asignado al doctor exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
