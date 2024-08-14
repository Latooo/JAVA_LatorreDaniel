package Encantamiento;

class Martillo extends Arma {
    public Martillo(Encantamiento encantamiento) {
        super(encantamiento);
    }

    @Override
    void blandir() {
        encantamiento.activar();
        System.out.println("Blandiendo el martillo.");
    }

    @Override
    void atacar() {
        encantamiento.aplicar();
        System.out.println("Atacando con el martillo.");
    }

    @Override
    void soltar() {
        encantamiento.desactivar();
        System.out.println("Soltando el martillo.");
    }
}
