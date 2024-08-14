package HeroeVillano;

abstract class Personaje {
    protected String nombre;
    protected int poder;

    public Personaje(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public abstract void mostrarHabilidadEspecial();
}

