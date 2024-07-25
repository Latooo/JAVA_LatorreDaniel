package sih;

import java.time.LocalDate;

public class Doctor extends Personal {
    private boolean esLider;

    public Doctor(String titulo, String nombrePila, String segundoNombre, String apellido, String direccion,
                  LocalDate fechaVinculacion, double salario, boolean esLider) {
        super(titulo, nombrePila, segundoNombre, apellido, direccion, fechaVinculacion, salario);
        this.esLider = esLider;
    }

    public boolean esLider() {
        return esLider;
    }
}
