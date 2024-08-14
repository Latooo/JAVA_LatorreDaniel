package Armeria;

public class ArmaElfica extends Arma {
    public ArmaElfica(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar() {
        System.out.println("Arma Élfica: " + nombre);
    }
}

