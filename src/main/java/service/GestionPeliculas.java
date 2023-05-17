package service;

import dao.DaoPeliculas;
import dao.DaoPeliculasFicheros;
import dao.DaoPeliculasImplementacion;
import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;
import java.util.List;
import java.util.Set;

public class GestionPeliculas implements IGestionPeliculas {

    private final DaoPeliculas daoPeliculas;
    private final DaoPeliculasFicheros daoPeliculasFicheros;

    public GestionPeliculas() {
        this.daoPeliculas = new DaoPeliculasImplementacion();
        this.daoPeliculasFicheros = new DaoPeliculasFicheros();
    }

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
    public void eliminarListaEmpleados(List<Empleado> empleados) {
        daoPeliculas.eliminarListaEmpleados(empleados);
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
    public void eliminarListaEscenarios(Set<Escenario> escenarios) {
        daoPeliculas.eliminarListaEscenarios(escenarios);
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
    public Set<Escenario> listarEscenario(boolean enUso) {
        return daoPeliculas.listarEscenario(enUso);
    }

    @Override
    public void crearFicheroEmpleados() {
        daoPeliculasFicheros.crearFicheroEmpleados();
    }


    @Override
    public void escribirFicheroEmpleados() {
        List<Empleado> empleados = daoPeliculas.getListaEmpleado();
        daoPeliculasFicheros.escribirFicheroEmpleados(empleados);
    }

    @Override
    public List<Empleado> cargarFicheroEmpleados() {
        return daoPeliculasFicheros.cargarFicheroEmpleados();
    }

    @Override
    public void crearFicheroEscenarios() {
        daoPeliculasFicheros.crearFicheroEscenarios();
    }

    @Override
    public void escribirFicheroEscenarios() {
        Set<Escenario> escenarios = daoPeliculas.getListaEscenario();
        daoPeliculasFicheros.escribirFicheroEscenarios(escenarios);
    }

    @Override
    public Set<Escenario> cargarFicheroEscenarios() {
        return daoPeliculasFicheros.cargarFicheroEscenarios();
    }

    @Override
    public void crearFicheroBinarioPeliculas() {
        daoPeliculasFicheros.crearFicheroBinarioPeliculas();
    }

    @Override
    public void escribirFicheroBinarioPeliculas(Pelicula pelicula) {
        daoPeliculasFicheros.escribirFicheroBinarioPeliculas(pelicula);
    }

    @Override
    public Pelicula cargarFicheroBinarioPeliculas() {
        return daoPeliculasFicheros.cargarFicheroBinarioPeliculas();
    }

}
