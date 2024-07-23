package campuslands;

public class Coordinador extends Persona {
    public Coordinador(String id, String nombres, String apellidos, String direccion, String acudiente, String telefonoCelular, String telefonoFijo) {
        super(id, nombres, apellidos, direccion, acudiente, telefonoCelular, telefonoFijo);
    }

    public void registrarNota(Camper camper, double notaTeorica, double notaPractica, double notaQuizzes) {
        Evaluacion evaluacion = new Evaluacion(notaTeorica, notaPractica, notaQuizzes);
        evaluacion.calcularAprobacion();
        camper.getEvaluaciones().add(evaluacion);

        boolean aprobado = camper.getEvaluaciones().stream().allMatch(Evaluacion::isAprobado);
        camper.setEstado(aprobado ? "Aprobado" : "Reprobado");
    }

    @Override
    public String toString() {
        return "Coordinador{" +
                "id='" + getId() + '\'' +
                ", nombres='" + getNombres() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", acudiente='" + getAcudiente() + '\'' +
                ", telefonoCelular='" + getTelefonoCelular() + '\'' +
                ", telefonoFijo='" + getTelefonoFijo() + '\'' +
                '}';
    }
}
