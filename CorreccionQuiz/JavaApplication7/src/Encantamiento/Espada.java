package Encantamiento;

class Espada extends Arma {
    public Espada(Encantamiento encantamiento) {
        super(encantamiento);
    }

    @Override
    void blandir() {
        encantamiento.activar();
        System.out.println("Blandiendo la espada.");
    }

    @Override
    void atacar() {
        encantamiento.aplicar();
        System.out.println("Atacando con la espada.");
    }

    @Override
    void soltar() {
        encantamiento.desactivar();
        System.out.println("Soltando la espada.");
    }
}

