package HeroeVillano;

public class Juego {
    public static void main(String[] args) {
        // Crear la única instancia de Héroe
        Heroe heroe = Heroe.getInstancia();
        heroe.mostrarHabilidadEspecial();

        Heroe otroHeroe = Heroe.getInstancia();
        otroHeroe.mostrarHabilidadEspecial();
        
        System.out.println("¿El mismo héroe?: " + (heroe == otroHeroe)); 

        Villano villano1 = new Villano("Rek'sai", 80);
        Villano villano2 = new Villano("Kha'zix", 90);
        
        villano1.mostrarHabilidadEspecial();
        villano2.mostrarHabilidadEspecial();
    }
}

