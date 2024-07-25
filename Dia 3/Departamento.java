package sih;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Personal> personal;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.personal = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPersonal(Personal personal) {
        this.personal.add(personal);
    }

    public List<Personal> getPersonal() {
        return personal;
    }
}
