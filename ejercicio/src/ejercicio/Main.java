
package ejercicio;

public class Main {
    private static int entradasDisponibles = 10;

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            new Thread(new ReservaEntradas(), "Usuario " + (i + 1)).start();
        }
    }

        static class ReservaEntradas implements Runnable {
        @Override
        public void run() {
            
            if (entradasDisponibles > 0) {
                System.out.println(Thread.currentThread().getName() + " está reservando una entrada.");
                entradasDisponibles--;
                System.out.println(Thread.currentThread().getName() + " completó la reserva. Entradas restantes: " + entradasDisponibles);
            } else {
                System.out.println(Thread.currentThread().getName() + " no pudo reservar una entrada. Entradas agotadas.");
            }
        }
    }
}