
package Armeria;

public class ArmaEnana extends Arma {
    public ArmaEnana(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar() {
        System.out.println("Arma Enana: " + nombre);
    }
}

