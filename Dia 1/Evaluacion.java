package campuslands;

public class Evaluacion {
    private double notaTeorica;
    private double notaPractica;
    private double notaQuizzes;
    private boolean aprobado;

    public Evaluacion(double notaTeorica, double notaPractica, double notaQuizzes) {
        this.notaTeorica = notaTeorica;
        this.notaPractica = notaPractica;
        this.notaQuizzes = notaQuizzes;
    }

    public void calcularAprobacion() {
        double promedio = (notaTeorica * 0.3) + (notaPractica * 0.6) + (notaQuizzes * 0.1);
        this.aprobado = promedio >= 60;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public double getNotaTeorica() {
        return notaTeorica;
    }

    public double getNotaPractica() {
        return notaPractica;
    }

    public double getNotaQuizzes() {
        return notaQuizzes;
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
                "notaTeorica=" + notaTeorica +
                ", notaPractica=" + notaPractica +
                ", notaQuizzes=" + notaQuizzes +
                ", aprobado=" + aprobado +
                '}';
    }
}

