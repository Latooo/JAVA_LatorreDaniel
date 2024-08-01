public class PartidoPlayOff extends Partido {
    private String ronda;

    public PartidoPlayOff(String equipoLocal, String equipoVisitante, String fecha, String ronda) {
        super(equipoLocal, equipoVisitante, fecha);
        this.ronda = ronda;
    }

    @Override
    public boolean puedeFinalizar() {
        return cestasLocales != cestasVisitantes; // Solo puede finalizar si hay un ganador
    }

    @Override
    public void finalizarPartido() {
        if (puedeFinalizar()) {
            super.finalizarPartido();
        } else {
            System.out.println("El partido no puede finalizar en empate.");
        }
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Ronda: " + ronda);
    }
}
