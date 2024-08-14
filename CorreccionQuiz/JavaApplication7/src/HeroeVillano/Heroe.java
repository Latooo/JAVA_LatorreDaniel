package HeroeVillano;

class Heroe extends Personaje {
    private static Heroe instancia;

    private Heroe(String nombre, int poder) {
        super(nombre, poder);
    }

    public static Heroe getInstancia() {
        if (instancia == null) {
            instancia = new Heroe("Xin zhao", 100);
        }
        return instancia;
    }

    @Override
    public void mostrarHabilidadEspecial() {
        System.out.println(nombre + " utiliza su ultimate!");
    }
}

