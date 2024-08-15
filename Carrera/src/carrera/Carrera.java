package carrera;

class Atleta extends Thread {
    private String nombre;
    private int numeroAtleta;
    private static Object testigo = new Object();

    public Atleta(String nombre, int numeroAtleta) {
        this.nombre = nombre;
        this.numeroAtleta = numeroAtleta;
    }

       @Override
    public void run() {
        synchronized (testigo) {
            try {
              
                long startTime = System.currentTimeMillis();
                System.out.println(nombre + " prendio pique.");
                
                Thread.sleep((int) (Math.random() * 2000) + 9000); 
                
                long endTime = System.currentTimeMillis();
                System.out.println(nombre + " se mamo de correr. Tiempo: " + (endTime - startTime) / 1000.0 + " segundos.");

               
                if (numeroAtleta < 4) {
                    System.out.println(nombre + " lo roto.");
                    testigo.notify();
                }
            } catch (InterruptedException e) {
            }

            if (numeroAtleta < 4) {
                try {
                    testigo.wait(); 
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

class Carrera {
    public static void main(String[] args) {
        
        Atleta atleta1 = new Atleta("El cote", 1);
        Atleta atleta2 = new Atleta("Pedrazin", 2);
        Atleta atleta3 = new Atleta("Pedro", 3);
        Atleta atleta4 = new Atleta("Stormice", 4);

        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();
    }
}