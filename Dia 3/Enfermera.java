package sih;

import java.time.LocalDate;

public class Enfermera extends Personal {
    public Enfermera(String titulo, String nombrePila, String segundoNombre, String apellido, String direccion,
                     LocalDate fechaVinculacion, double salario) {
        super(titulo, nombrePila, segundoNombre, apellido, direccion, fechaVinculacion, salario);
    }
}
