public class PartidoLiga extends Partido {
    private int jornada;

    public PartidoLiga(String equipoLocal, String equipoVisitante, String fecha, int jornada) {
        super(equipoLocal, equipoVisitante, fecha);
        this.jornada = jornada;
    }

    @Override
    public boolean puedeFinalizar() {
        return true; // Puede finalizar en cualquier momento
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Jornada: " + jornada);
    }
}
