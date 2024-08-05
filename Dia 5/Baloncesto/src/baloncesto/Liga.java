package baloncesto;

public class Liga {
    private int id;
    private int partidoId;
    private int cestasLocal;
    private int cestasVisitante;

    // Constructor
    public Liga(int partidoId, int cestasLocal, int cestasVisitante) {
        this.partidoId = partidoId;
        this.cestasLocal = cestasLocal;
        this.cestasVisitante = cestasVisitante;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(int partidoId) {
        this.partidoId = partidoId;
    }

    public int getCestasLocal() {
        return cestasLocal;
    }

    public void setCestasLocal(int cestasLocal) {
        this.cestasLocal = cestasLocal;
    }

    public int getCestasVisitante() {
        return cestasVisitante;
    }

    public void setCestasVisitante(int cestasVisitante) {
        this.cestasVisitante = cestasVisitante;
    }
}

