package campuslands;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Persona {
    private List<RutaEntrenamiento> rutasAsignadas;

    public Trainer(String id, String nombres, String apellidos, String direccion, String acudiente, String telefonoCelular, String telefonoFijo) {
        super(id, nombres, apellidos, direccion, acudiente, telefonoCelular, telefonoFijo);
        this.rutasAsignadas = new ArrayList<>();
    }

    public List<RutaEntrenamiento> getRutasAsignadas() {
        return rutasAsignadas;
    }

    @Override
    public String toString() {
        return "Trainer{" +
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
