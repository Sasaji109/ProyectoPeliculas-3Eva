package dao;

import common.IdiomaException;
import domain.Empleado;
import domain.Escenario;

import java.util.*;
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
    public List<Empleado> listarEmpleadoNIF(boolean orden) {
        Comparator<Empleado> comparador = Comparator.comparing(Empleado::getNIF);
        if (!orden) {
            comparador = comparador.reversed();
        }
        return daoBaseDeDatos.getListaEmpleados().stream().sorted(comparador).collect(Collectors.toList());
    }

    @Override
    public List<Empleado> listarEmpleado(double sueldo1, double sueldo2) {
        return daoBaseDeDatos.getListaEmpleados().stream().filter(empleado -> empleado.getSalario() > sueldo1
                        && empleado.getSalario() < sueldo2).collect(Collectors.toList());}

    @Override
    public List<Empleado> listarEmpleadoSUELDONIF(boolean orden) {
        Comparator<Empleado> comparador = Comparator.comparingDouble(Empleado::getSalario);

        if (orden) {
            comparador = comparador.thenComparing(Empleado::getNIF);
        } else {
            comparador = comparador.reversed().thenComparing(Empleado::getNIF);
        }

        return daoBaseDeDatos.getListaEmpleados().stream().sorted(comparador).collect(Collectors.toList());
    }

    @Override
    public List<Empleado> listarEmpleado(boolean trabajando) {
        return daoBaseDeDatos.getListaEmpleados().stream().filter(empleado -> empleado.isTrabajando() == trabajando).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Empleado>> dividirEmpleado(List<Empleado> empleados) {
        Map<String, List<Empleado>> empleadosPorTrabajo = new HashMap<>();

        for (Empleado empleado : empleados) {
            String trabajo = empleado.getTrabajo();
            if (empleadosPorTrabajo.containsKey(trabajo)) {
                empleadosPorTrabajo.get(trabajo).add(empleado);
            } else {
                List<Empleado> listaEmpleados = new ArrayList<>();
                listaEmpleados.add(empleado);
                empleadosPorTrabajo.put(trabajo, listaEmpleados);
            }
        }

        return empleadosPorTrabajo;
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
    public Set<Escenario> listarEscenarioLUGAR(boolean orden) {
        Comparator<Escenario> comparador = Comparator.comparing(Escenario::getLugar);
        if (!orden) {
            comparador = comparador.reversed();
        }
        return daoBaseDeDatos.getListaEscenarios().stream().sorted(comparador).collect(Collectors.toCollection(LinkedHashSet::new));
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
