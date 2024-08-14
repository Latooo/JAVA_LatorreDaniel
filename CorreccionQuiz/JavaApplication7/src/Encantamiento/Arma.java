package Encantamiento;

abstract class Arma {
    protected Encantamiento encantamiento;

    public Arma(Encantamiento encantamiento) {
        this.encantamiento = encantamiento;
    }

    abstract void blandir();
    abstract void atacar();
    abstract void soltar();
}

