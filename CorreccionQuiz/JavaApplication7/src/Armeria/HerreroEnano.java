package Armeria;

public class HerreroEnano implements Herrero {
    @Override
    public Arma fabricarArma(String tipoArma) {
        return new ArmaEnana(tipoArma);
    }
}

