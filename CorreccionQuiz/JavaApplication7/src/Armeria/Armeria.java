package Armeria;

public class Armeria {
    public Arma crearArma(String tipoTrabajo, String tipoArma) {
        Herrero herrero;
        if (tipoTrabajo.equalsIgnoreCase("elfico")) {
            herrero = new HerreroElfico();
        } else if (tipoTrabajo.equalsIgnoreCase("enano")) {
            herrero = new HerreroEnano();
        } else {
            throw new IllegalArgumentException("Tipo de trabajo desconocido");
        }
        return herrero.fabricarArma(tipoArma);
    }
}

