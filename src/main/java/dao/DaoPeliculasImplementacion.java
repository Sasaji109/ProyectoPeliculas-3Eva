package dao;

import common.IdiomaException;
import domain.Empleado;
import domain.Escenario;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DaoPeliculasImplementacion implements DaoPeliculas {

    private final DaoBaseDeDatos daoBaseDeDatos;

    public DaoPeliculasImplementacion() {
        this.daoBaseDeDatos = new DaoBaseDeDatos();
    }

    public DaoPeliculasImplementacion(DaoBaseDeDatos daoBaseDeDatos) {
        this.daoBaseDeDatos = daoBaseDeDatos;
    }

    @Override
    public boolean isEmptyEmpleadosList() {
        return daoBaseDeDatos.getListaEmpleados().isEmpty();
    }

    @Override
    public List<Empleado> getListaEmpleado() {
        return daoBaseDeDatos.getListaEmpleados();
    }

    @Override
    public boolean insertarEmpleado(Empleado empleado) {
        List<Empleado> empleados = daoBaseDeDatos.getListaEmpleados();
        return empleados.add(empleado);
    }

    @Override
    public void eliminarEmpleado(String NIF) {
        List<Empleado> empleados = daoBaseDeDatos.getListaEmpleados();
        empleados.removeIf(empleado -> empleado.getNIF().equals(NIF));
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        List<Empleado> empleados = daoBaseDeDatos.getListaEmpleados();
        int index = empleados.indexOf(empleado);
        if (index >= 0) {
            empleados.set(index, empleado);
        }
    }

    @Override
    public void eliminarListaEmpleados(List<Empleado> empleados) {
        empleados.clear();
    }

    @Override
    public List<Empleado> listarEmpleado(String NIF) {
        return daoBaseDeDatos.getListaEmpleados().stream().filter(empleado -> empleado.getNIF().equals(NIF)).collect(Collectors.toList());
    }

    @Override
    public List<Empleado> listarEmpleado(double sueldo1, double sueldo2) {
        return daoBaseDeDatos.getListaEmpleados().stream().filter(empleado -> empleado.getSalario() > sueldo1
                        && empleado.getSalario() < sueldo2).collect(Collectors.toList());}

    @Override
    public List<Empleado> listarEmpleado(String NIF, double sueldo) {
        return daoBaseDeDatos.getListaEmpleados().stream().filter(empleado -> empleado.getNIF().equals(NIF)
                && empleado.getSalario() == sueldo).collect(Collectors.toList());
    }

    @Override
    public List<Empleado> listarEmpleado(boolean trabajando) {
        return daoBaseDeDatos.getListaEmpleados().stream().filter(empleado -> empleado.isTrabajando() == trabajando).collect(Collectors.toList());
    }

    @Override
    public boolean isEmptyEscenariosSet() {
        return daoBaseDeDatos.getListaEscenarios().isEmpty();
    }

    @Override
    public Set<Escenario> getListaEscenario() {
        return daoBaseDeDatos.getListaEscenarios();
    }

    @Override
    public boolean insertarEscenario(Escenario escenario) {
        Set<Escenario> escenarios = daoBaseDeDatos.getListaEscenarios();
        return escenarios.add(escenario);
    }

    @Override
    public void eliminarEscenario(int id) {
        Set<Escenario> escenarios = daoBaseDeDatos.getListaEscenarios();
        escenarios.removeIf(escenario -> escenario.getId() == id);
    }

    @Override
    public void modificarEscenario(Escenario escenario) {
        Set<Escenario> escenarios = daoBaseDeDatos.getListaEscenarios();
        escenarios.removeIf(esc -> esc.getId() == escenario.getId());
        escenarios.add(escenario);
    }

    @Override
    public void eliminarListaEscenarios(Set<Escenario> escenarios) {
        escenarios.clear();
    }

    @Override
    public Set<Escenario> listarEscenario(int id) {
        return daoBaseDeDatos.getListaEscenarios().stream().filter(escenario -> escenario.getId() == id).collect(Collectors.toSet());
    }

    @Override
    public Set<Escenario> listarEscenario(String lugar) {
        return daoBaseDeDatos.getListaEscenarios().stream().filter(escenario -> escenario.getLugar().equals(lugar)).collect(Collectors.toSet());
    }

    @Override
    public Set<Escenario> listarEscenario(double alquiler1, double alquiler2) {
        return daoBaseDeDatos.getListaEscenarios().stream().filter(escenario -> escenario.getAlquiler() > alquiler1
                && escenario.getAlquiler() < alquiler2).collect(Collectors.toSet());
    }

    @Override
    public Set<Escenario> listarEscenario(boolean enUso) {
        return daoBaseDeDatos.getListaEscenarios().stream().filter(escenario -> escenario.isEnUso() == enUso).collect(Collectors.toSet());
    }
}
