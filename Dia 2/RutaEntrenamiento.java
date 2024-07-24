package campuslands;

import java.util.ArrayList;
import java.util.List;

public class RutaEntrenamiento {
    private String nombre;
    private List<Modulo> modulos;

    public RutaEntrenamiento(String nombre) {
        this.nombre = nombre;
        this.modulos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    @Override
    public String toString() {
        return "RutaEntrenamiento{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
