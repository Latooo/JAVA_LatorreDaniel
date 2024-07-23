package campuslands;

public class Persona {
    private String id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String acudiente;
    private String telefonoCelular;
    private String telefonoFijo;

    public Persona(String id, String nombres, String apellidos, String direccion, String acudiente, String telefonoCelular, String telefonoFijo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.acudiente = acudiente;
        this.telefonoCelular = telefonoCelular;
        this.telefonoFijo = telefonoFijo;
    }

    public String getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }
}

