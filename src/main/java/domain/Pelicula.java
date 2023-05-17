package domain;

import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Pelicula {
    private String nombre;
    private Guion guion;
    private double presupuesto;
    private List<Empleado> empleadosPelicula;
    private Set<Escenario> escenariosPelicula;

    public Pelicula(String nombre, Guion guion, double presupuesto, List<Empleado> empleadosPelicula, Set<Escenario> escenariosPelicula) {
        this.nombre = nombre;
        this.guion = guion;
        this.presupuesto = presupuesto;
        this.empleadosPelicula = empleadosPelicula;
        this.escenariosPelicula = escenariosPelicula;
    }
}
