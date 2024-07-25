package sih;

import java.time.LocalDate;
import java.time.Period;

public class Paciente extends Persona {
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private String diagnostico;

    public Paciente(String titulo, String nombrePila, String segundoNombre, String apellido, String direccion,
                    LocalDate fechaNacimiento, LocalDate fechaIngreso, String diagnostico) {
        super(titulo, nombrePila, segundoNombre, apellido, direccion);
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.diagnostico = diagnostico;
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getDiagnostico() {
        return diagnostico;
    }
}
