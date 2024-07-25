package sih;

public abstract class Persona {
    private String titulo;
    private String nombrePila;
    private String segundoNombre;
    private String apellido;
    private String direccion;

    public Persona(String titulo, String nombrePila, String segundoNombre, String apellido, String direccion) {
        this.titulo = titulo;
        this.nombrePila = nombrePila;
        this.segundoNombre = segundoNombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return titulo + " " + nombrePila + " " + segundoNombre + " " + apellido;
    }

    public String getDireccion() {
        return direccion;
    }
}
