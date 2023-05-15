package service;

import dao.DaoPeliculas;
import dao.DaoPeliculasFicheros;
import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class GestionPeliculas implements IGestionPeliculas {

    private final DaoPeliculas daoPeliculas;
    private final DaoPeliculasFicheros daoPeliculasFicheros;

    public GestionPeliculas(DaoPeliculas daoPeliculas, DaoPeliculasFicheros daoPeliculasFicheros) {
        this.daoPeliculas = daoPeliculas;
        this.daoPeliculasFicheros = daoPeliculasFicheros;
    }

    @Override
    public boolean isEmptyEmpleadosList() {
        return daoPeliculas.isEmptyEmpleadosList();
    }

    @Override
    public List<Empleado> getListaEmpleado() {
        return daoPeliculas.getListaEmpleado();
    }

    @Override
    public boolean insertarEmpleado(Empleado empleado) {
        return daoPeliculas.insertarEmpleado(empleado);
    }

    @Override
    public void eliminarEmpleado(String NIF) {
        daoPeliculas.eliminarEmpleado(NIF);
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        daoPeliculas.modificarEmpleado(empleado);
    }

    @Override
    public List<Empleado> listarEmpleado(String NIF) {
        return daoPeliculas.listarEmpleado(NIF);
    }

    @Override
    public List<Empleado> listarEmpleado(String NIF, String trabajo) {
        return daoPeliculas.listarEmpleado(NIF,trabajo);
    }

    @Override
    public List<Empleado> listarEmpleado(double sueldo) {
        return daoPeliculas.listarEmpleado(sueldo);
    }

    @Override
    public List<Empleado> listarEmpleado(String NIF, double sueldo) {
        return daoPeliculas.listarEmpleado(NIF, sueldo);
    }

    @Override
    public List<Empleado> listarEmpleado(boolean trabajando) {
        return daoPeliculas.listarEmpleado(trabajando);
    }

    @Override
    public boolean isEmptyEscenariosSet() {
        return daoPeliculas.isEmptyEscenariosSet();
    }

    @Override
    public Set<Escenario> getListaEscenario() {
        return daoPeliculas.getListaEscenario();
    }

    @Override
    public boolean insertarEscenario(Escenario escenario) {
        return daoPeliculas.insertarEscenario(escenario);
    }

    @Override
    public void eliminarEscenario(int id) {
        daoPeliculas.eliminarEscenario(id);
    }

    @Override
    public void modificarEscenario(Escenario escenario) {
        daoPeliculas.modificarEscenario(escenario);
    }

    @Override
    public Set<Escenario> listarEscenario(int id) {
        return daoPeliculas.listarEscenario(id);
    }

    @Override
    public Set<Escenario> listarEscenario(String lugar) {
        return daoPeliculas.listarEscenario(lugar);
    }

    @Override
    public Set<Escenario> listarEscenario(double alquiler) {
        return daoPeliculas.listarEscenario(alquiler);
    }

    @Override
    public Set<Escenario> listarEscenario(int id, double alquiler) {
        return daoPeliculas.listarEscenario(id, alquiler);
    }

    @Override
    public void comprobacionFicheroEmpleados() throws IOException {
        daoPeliculasFicheros.comprobacionFicheroEmpleados();
    }

    @Override
    public List<Empleado> cargarFicheroEmpleados() throws IOException {
        return daoPeliculasFicheros.cargarFicheroEmpleados();
    }

    @Override
    public void comprobacionFicheroEscenarios() throws IOException {
        daoPeliculasFicheros.comprobacionFicheroEscenarios();
    }

    @Override
    public Set<Escenario> cargarFicheroEscenarios() throws IOException {
        return daoPeliculasFicheros.cargarFicheroEscenarios();
    }

    @Override
    public void escribirFicheroBinarioPeliculas(Pelicula pelicula) {
        daoPeliculasFicheros.escribirFicheroBinarioPeliculas(pelicula);
    }

    @Override
    public void cargarFicheroBinarioPeliculas() {
        daoPeliculasFicheros.cargarFicheroBinarioPeliculas();
    }

}
