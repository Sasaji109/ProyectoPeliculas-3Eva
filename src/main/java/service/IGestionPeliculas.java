package service;

import common.IdiomaException;
import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface IGestionPeliculas {

    boolean isEmptyEmpleadosList();
    List<Empleado> getListaEmpleado();
    boolean insertarEmpleado(Empleado empleado);
    void eliminarEmpleado(String NIF);
    void modificarEmpleado(Empleado empleado);
    List<Empleado> listarEmpleado(String NIF);
    List<Empleado> listarEmpleado(String NIF, String trabajo);
    List<Empleado> listarEmpleado(double sueldo);
    List<Empleado> listarEmpleado(String NIF, double sueldo);
    List<Empleado> listarEmpleado(boolean trabajando);

    boolean isEmptyEscenariosSet();
    Set<Escenario> getListaEscenario();
    boolean insertarEscenario(Escenario escenario);
    void eliminarEscenario(int id);
    void modificarEscenario(Escenario escenario);
    Set<Escenario> listarEscenario(int id);
    Set<Escenario> listarEscenario(String lugar);
    Set<Escenario> listarEscenario(double alquiler);
    Set<Escenario> listarEscenario(int id, double alquiler);

    void crearFicheroEmpleados();
    void escribirFicheroEmpleados();
    List<Empleado> cargarFicheroEmpleados();

    void crearFicheroEscenarios();
    void escribirFicheroEscenarios();
    Set<Escenario> cargarFicheroEscenarios();

    void crearFicheroBinarioPeliculas();
    void escribirFicheroBinarioPeliculas(Pelicula pelicula);
    void cargarFicheroBinarioPeliculas();
}

