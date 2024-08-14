package Encantamiento;

class Fuego implements Encantamiento {
    @Override
    public void activar() {
        System.out.println("El arma se ilumina con un aura de fuego.");
    }

    @Override
    public void aplicar() {
        System.out.println("Añadiendo daño de fuego al ataque.");
    }

    @Override
    public void desactivar() {
        System.out.println("El fuego se apaga.");
    }
}

