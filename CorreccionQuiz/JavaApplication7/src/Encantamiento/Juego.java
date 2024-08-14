package Encantamiento;

public class Juego {
    public static void main(String[] args) {
        
        Arma espadaConFuego = new Espada(new Fuego());
        espadaConFuego.blandir();  
        espadaConFuego.atacar();   
        espadaConFuego.soltar();   

        System.out.println();

        
        Arma martilloConVorpal = new Martillo(new Vorpal());
        martilloConVorpal.blandir();  
        martilloConVorpal.atacar();   
        martilloConVorpal.soltar(); 
    }
}

