package campuslands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CampusLands {
    private List<Camper> campers;
    private List<Trainer> trainers;
    private List<RutaEntrenamiento> rutas;
    private Coordinador coordinador;

    public CampusLands() {
        this.campers = new ArrayList<>();
        this.trainers = new ArrayList<>();
        this.rutas = new ArrayList<>();
    }

    public void registrarCamper(Camper camper) {
        this.campers.add(camper);
    }

    public Camper buscarCamperPorId(String id) {
        for (Camper camper : campers) {
            if (camper.getId().equals(id)) {
                return camper;
            }
        }
        return null;
    }

    public void eliminarCamper(String id) {
        Camper camper = buscarCamperPorId(id);
        if (camper != null) {
            this.campers.remove(camper);
        }
    }

    public List<Camper> listarCampers() {
        return new ArrayList<>(campers);
    }

    public List<Camper> listarCampersAprobados() {
        return campers.stream()
                .filter(camper -> "Aprobado".equals(camper.getEstado()))
                .collect(Collectors.toList());
    }

    public List<Camper> listarCampersBajoRendimiento() {
        return campers.stream()
                .filter(camper -> camper.getEvaluaciones().stream().anyMatch(evaluacion -> !evaluacion.isAprobado()))
                .collect(Collectors.toList());
    }

    public List<Camper> getCampers() {
        return campers;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public List<RutaEntrenamiento> getRutas() {
        return rutas;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}
