package Armeria;

public class Cliente {
    public static void main(String[] args) {
        Armeria armeria = new Armeria();
        
        Arma armaElfica = armeria.crearArma("elfico", "Espada Luminosa");
        armaElfica.mostrar();
        
        Arma armaEnana = armeria.crearArma("enano", "Hacha Poderosa");
        armaEnana.mostrar();
    }
}

