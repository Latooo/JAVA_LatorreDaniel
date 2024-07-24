package campuslands;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
    private String nombre;
    private List<Evaluacion> evaluaciones;

    public Modulo(String nombre) {
        this.nombre = nombre;
        this.evaluaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

