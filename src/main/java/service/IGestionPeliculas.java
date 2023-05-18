package service;

import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;

import java.util.List;
import java.util.Set;

public interface IGestionPeliculas {

    boolean isEmptyEmpleadosList();
    List<Empleado> getListaEmpleado();
    boolean insertarEmpleado(Empleado empleado);
    void eliminarEmpleado(String NIF);
    void modificarEmpleado(Empleado empleado);
    void eliminarListaEmpleados(List <Empleado> empleados);
    List<Empleado> listarEmpleadoNIF(boolean orden);
    List<Empleado> listarEmpleado(double sueldo1, double sueldo2);
    List<Empleado> listarEmpleadoSUELDONIF(boolean orden);
    List<Empleado> listarEmpleado(boolean trabajando);

    boolean isEmptyEscenariosSet();
    Set<Escenario> getListaEscenario();
    boolean insertarEscenario(Escenario escenario);
    void eliminarEscenario(int id);
    void modificarEscenario(Escenario escenario);
    void eliminarListaEscenarios(Set <Escenario> escenarios);
    Set<Escenario> listarEscenario(int id);
    Set<Escenario> listarEscenario(String lugar);
    Set<Escenario> listarEscenario(double alquiler1, double alquiler2);
    Set<Escenario> listarEscenario(boolean enUso);

    void crearFicheroEmpleados();
    void escribirFicheroEmpleados();
    List<Empleado> cargarFicheroEmpleados();

    void crearFicheroEscenarios();
    void escribirFicheroEscenarios();
    Set<Escenario> cargarFicheroEscenarios();

    void crearFicheroBinarioPeliculas();
    void escribirFicheroBinarioPeliculas(Pelicula pelicula);
    Pelicula cargarFicheroBinarioPeliculas();
}

