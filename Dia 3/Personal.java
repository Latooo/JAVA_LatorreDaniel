package sih;

import java.time.LocalDate;

public abstract class Personal extends Persona {
    private LocalDate fechaVinculacion;
    private double salario;

    public Personal(String titulo, String nombrePila, String segundoNombre, String apellido, String direccion,
                    LocalDate fechaVinculacion, double salario) {
        super(titulo, nombrePila, segundoNombre, apellido, direccion);
        this.fechaVinculacion = fechaVinculacion;
        this.salario = salario;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public double getSalario() {
        return salario;
    }
}
