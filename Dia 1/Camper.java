package campuslands;

import java.util.ArrayList;
import java.util.List;

public class Camper extends Persona {
    private String estado;
    private double riesgo;
    private List<Evaluacion> evaluaciones;

    public Camper(String id, String nombres, String apellidos, String direccion, String acudiente, String telefonoCelular, String telefonoFijo, String estado, double riesgo) {
        super(id, nombres, apellidos, direccion, acudiente, telefonoCelular, telefonoFijo);
        this.estado = estado;
        this.riesgo = riesgo;
        this.evaluaciones = new ArrayList<>();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getRiesgo() {
        return riesgo;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    @Override
    public String toString() {
        return "Camper{" +
                "id='" + getId() + '\'' +
                ", nombres='" + getNombres() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", acudiente='" + getAcudiente() + '\'' +
                ", telefonoCelular='" + getTelefonoCelular() + '\'' +
                ", telefonoFijo='" + getTelefonoFijo() + '\'' +
                ", estado='" + estado + '\'' +
                ", riesgo=" + riesgo +
                '}';
    }
}

