package sih;

import java.util.ArrayList;
import java.util.List;

public class Pabellon {
    private String nombre;
    private int capacidad;
    private List<Paciente> pacientes;

    public Pabellon(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pacientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void asignarPaciente(Paciente paciente) {
        if (pacientes.size() < capacidad) {
            pacientes.add(paciente);
        } else {
            System.out.println("No hay capacidad en el pabellón.");
        }
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
