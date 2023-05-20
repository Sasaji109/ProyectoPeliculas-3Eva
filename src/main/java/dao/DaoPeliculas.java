package dao;

import common.IdiomaException;
import domain.Empleado;
import domain.Escenario;
import domain.Guion;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DaoPeliculas {

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
    Map<String, List<Empleado>> dividirEmpleado(List<Empleado> empleados);

    boolean isEmptyEscenariosSet();
    Set<Escenario> getListaEscenario();
    boolean insertarEscenario(Escenario escenario);
    void eliminarEscenario(int id);
    void modificarEscenario(Escenario escenario);
    void eliminarListaEscenarios(Set <Escenario> escenarios);
    Set<Escenario> listarEscenario(int id);
    Set<Escenario> listarEscenarioLUGAR(boolean orden);
    Set<Escenario> listarEscenario(double alquiler1, double alquiler2);
    Set<Escenario> listarEscenario(boolean enUso);

    boolean manejarGuion(Guion guion);
}
