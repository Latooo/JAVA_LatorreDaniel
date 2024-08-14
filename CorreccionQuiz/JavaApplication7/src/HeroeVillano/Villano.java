package HeroeVillano;

class Villano extends Personaje {
    public Villano(String nombre, int poder) {
        super(nombre, poder);
    }

    @Override
    public void mostrarHabilidadEspecial() {
        System.out.println(nombre + " usa su poder corrupto!");
    }
}

