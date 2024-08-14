package Armeria;

public class HerreroElfico implements Herrero {
    @Override
    public Arma fabricarArma(String tipoArma) {
        return new ArmaElfica(tipoArma);
    }
}

