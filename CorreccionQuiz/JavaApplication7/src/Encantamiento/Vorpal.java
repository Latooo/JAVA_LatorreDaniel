package Encantamiento;

class Vorpal implements Encantamiento {
    @Override
    public void activar() {
        System.out.println("El arma se torna roja brillante.");
    }

    @Override
    public void aplicar() {
        System.out.println("Incrementando la posibilidad de un ataque crítico.");
    }

    @Override
    public void desactivar() {
        System.out.println("El brillo rojo desaparece.");
    }
}

