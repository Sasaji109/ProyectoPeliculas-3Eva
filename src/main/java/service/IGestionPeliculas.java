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
    void eliminarListaEmpleados(List <Empleado> empleados);
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
    void eliminarListaEscenarios(Set <Escenario> escenarios);
    Set<Escenario> listarEscenario(int id);
    Set<Escenario> listarEscenario(String lugar);
    Set<Escenario> listarEscenario(double alquiler);
    Set<Escenario> listarEscenario(boolean enUso);

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

