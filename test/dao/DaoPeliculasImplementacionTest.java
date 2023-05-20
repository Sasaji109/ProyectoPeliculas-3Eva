package dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import domain.Empleado;
import domain.Escenario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DaoPeliculasImplementacionTest {

    @InjectMocks
    DaoPeliculasImplementacion daoPeliculasImplementacion;

    @Mock
    DaoBaseDeDatos daoBaseDeDatos;

    @DisplayName("Gestionar Empleados")
    @Nested
    public class GestionarEmpleados {
        @Test
        void isEmptyEmpleadosList() {
            //given
            List<Empleado> empleados = new ArrayList<>();
            when(daoBaseDeDatos.getListaEmpleados()).thenReturn(empleados);
            //when
            boolean isEmpty = daoPeliculasImplementacion.isEmptyEmpleadosList();
            //then
            assertThat(isEmpty).isEqualTo(true);
        }

        @Test
        void getListaEmpleado() {
            //given
            List<Empleado> empleados = new LinkedList<>();
            empleados.add(new Empleado("12345678A", "John Smith", 2000.0, "Actor", false));
            empleados.add(new Empleado("23456789B", "Jane Doe", 2500.0, "Director", false));
            empleados.add(new Empleado("45678901D", "Tom Hanks", 3000.0, "Actor", false));
            empleados.add(new Empleado("56789012E", "Meryl Streep", 3500.0, "Actriz", false));
            empleados.add(new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false));
            empleados.add(new Empleado("78901234G", "Angelina Jolie", 4500.0, "Actriz", false));
            //when
            when(daoBaseDeDatos.getListaEmpleados()).thenReturn(empleados);
            List<Empleado> empleadosObtenidos = daoPeliculasImplementacion.getListaEmpleado();
            //then
            assertEquals(empleados.size(), empleadosObtenidos.size());
            assertEquals(empleados, empleadosObtenidos);
        }

        @Test
        void eliminarListaEmpleados() {
            //given
            List<Empleado> empleados = new ArrayList<>();
            empleados.add(new Empleado("56789012Y", "Anne Hathaway", 3500.0, "Actriz", false));
            empleados.add(new Empleado("67890123Z", "Ridley Scott", 6000.0, "Director", false));
            //when
            daoPeliculasImplementacion.eliminarListaEmpleados(empleados);
            //then
            assertEquals(0, empleados.size());
        }

        @ParameterizedTest
        @ValueSource(booleans = {true, false})
        void listarEmpleadoNIF(boolean orden) {
            //given
            List<Empleado> empleados = new ArrayList<>();
            empleados.add(new Empleado("14725689O", "Carla Pérez", 2100.0, "Jefa de producción", false));
            empleados.add(new Empleado("01655339L", "Marcos Gómez", 2200.00, "Jefe de producción", false));
            empleados.add(new Empleado("25896314N", "Sofía Fernández", 1800.0, "Vestuario", false));
            empleados.add(new Empleado("89562314P", "Cristina Martín", 2400.0, "Vestuario", false));
            //when
            when(daoBaseDeDatos.getListaEmpleados()).thenReturn(empleados);
            List<Empleado> resultado = daoPeliculasImplementacion.listarEmpleadoNIF(orden);
            //then
            List<Empleado> empleadosEsperados = new ArrayList<>(empleados);
            Comparator<Empleado> comparador = Comparator.comparing(Empleado::getNIF);
            if (!orden) {
                comparador = comparador.reversed();
            }
            empleadosEsperados.sort(comparador);
            assertEquals(empleadosEsperados, resultado);
        }

        @Test
        void listarEmpleadoSUELDONIF() {
        }

        @Test
        void testListarEmpleado() {
        }

        @Test
        void dividirEmpleado() {
            //given
            List<Empleado> empleados = new ArrayList<>();
            Empleado empleado1 = new Empleado("14725689D", "Sara García", 2500.50, "Productor", false);
            Empleado empleado2 = new Empleado("25896314E", "Pablo Rodríguez", 1800.75, "Productor", false);
            Empleado empleado3 = new Empleado("36987412F", "Lucía Hernández", 3000.0, "Director de fotografía", false);
            empleados.add(empleado1);
            empleados.add(empleado2);
            empleados.add(empleado3);
            Map<String, List<Empleado>> empleadosPorTrabajo = new HashMap<>();
            List<Empleado> productores = new ArrayList<>();
            productores.add(empleado1);
            productores.add(empleado2);
            List<Empleado> fotografia = new ArrayList<>();
            fotografia.add(empleado3);
            empleadosPorTrabajo.put("Productor", productores);
            empleadosPorTrabajo.put("Director de fotografía", fotografia);
            //when
            Map<String, List<Empleado>> empleadosPorTrabajoActual = daoPeliculasImplementacion.dividirEmpleado(empleados);
            //then
            assertEquals(empleadosPorTrabajo, empleadosPorTrabajoActual);
        }
    }

    @DisplayName("Gestionar Escenarios")
    @Nested
    public class GestionarEscenarios {
        @Test
        void insertarEscenario() {
            //given
            Escenario escenario = new Escenario(4884, "Nápoles", 2400.0, false);
            Set<Escenario> listaEscenarios = new HashSet<>();
            //when
            when(daoBaseDeDatos.getListaEscenarios()).thenReturn(listaEscenarios);
            boolean resultado = daoPeliculasImplementacion.insertarEscenario(escenario);
            //then
            assertTrue(resultado);
            assertTrue(listaEscenarios.contains(escenario));
        }

        @ParameterizedTest
        @CsvSource({"3664", "9881", "5288"})
        void eliminarEscenario(int id) {
            //given
            Set<Escenario> escenarios = new HashSet<>();
            Escenario escenario1 = new Escenario(3664, "Moscú", 3700.0, false);
            Escenario escenario2 = new Escenario(9881, "Estambul", 2900.0, false);
            Escenario escenario3 = new Escenario(5288, "Los Ángeles", 3600.0, false);
            escenarios.add(escenario1);
            escenarios.add(escenario2);
            escenarios.add(escenario3);
            //when
            when(daoBaseDeDatos.getListaEscenarios()).thenReturn(escenarios);
            daoPeliculasImplementacion.eliminarEscenario(id);
            //then
            assertEquals(2, escenarios.size());
        }

        @Test
        void listarEscenarioLUGAR() {
        }

        @Test
        void testListarEscenario() {
        }

        @Test
        void testListarEscenario1() {
        }
    }

}