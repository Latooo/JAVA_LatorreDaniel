package sih;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre;
    private List<Departamento> departamentos;
    private List<Persona> personas;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public List<Persona> getPersonas() {
        return personas;
    }
}
