public abstract class Partido {
    protected String equipoLocal;
    protected String equipoVisitante;
    protected int cestasLocales;
    protected int cestasVisitantes;
    protected boolean finalizado;
    protected String fecha;

    public Partido(String equipoLocal, String equipoVisitante, String fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.cestasLocales = 0;
        this.cestasVisitantes = 0;
        this.finalizado = false;
    }

    public void registrarPuntosLocales(int puntos) {
        if (!finalizado) {
            cestasLocales += puntos;
        }
    }

    public void registrarPuntosVisitantes(int puntos) {
        if (!finalizado) {
            cestasVisitantes += puntos;
        }
    }

    public String obtenerResultado() {
        return "Resultado: " + equipoLocal + " " + cestasLocales + " - " + equipoVisitante + " " + cestasVisitantes;
    }

    public String obtenerGanador() {
        if (cestasLocales > cestasVisitantes) {
            return "Ganador: " + equipoLocal;
        } else if (cestasVisitantes > cestasLocales) {
            return "Ganador: " + equipoVisitante;
        } else {
            return "Empate";
        }
    }

    public void finalizarPartido() {
        if (puedeFinalizar()) {
            this.finalizado = true;
        } else {
            System.out.println("El partido no puede finalizar en empate.");
        }
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void mostrarInformacion() {
        System.out.println("Partido: " + equipoLocal + " vs " + equipoVisitante);
        System.out.println("Fecha: " + fecha);
        System.out.println(obtenerResultado());
    }

    public abstract boolean puedeFinalizar();
}
