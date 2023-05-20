package service;

import common.Idioma;
import common.IdiomaException;
import dao.DaoPeliculas;
import domain.Empleado;
import domain.Escenario;
import domain.Guion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class GestionPeliculasTest {

    @InjectMocks
    GestionPeliculas gestionPeliculas;

    @Mock
    DaoPeliculas daoPeliculas;

    @DisplayName("Gestionar Empleados")
    @Nested
    public class GestionarEmpleados {
        @Test
        void isEmptyEmpleadosList() {
            //given
            when(daoPeliculas.isEmptyEmpleadosList()).thenReturn(true);
            //when
            boolean respuesta = gestionPeliculas.isEmptyEmpleadosList();
            //then
            assertThat(respuesta).isEqualTo(true);
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
            when(daoPeliculas.getListaEmpleado()).thenReturn(empleados);
            List<Empleado> empleados2 = gestionPeliculas.getListaEmpleado();
            //then
            assertThat(empleados2).isEqualTo(empleados);
        }

        @Test
        void insertarEmpleado() {
            //given
            Empleado empleado = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
            //when
            when(daoPeliculas.insertarEmpleado(empleado)).thenReturn(true);
            boolean respuesta = gestionPeliculas.insertarEmpleado(empleado);
            //then
            assertThat(respuesta).isEqualTo(true);
        }

        @Test
        void eliminarEmpleado() {
            //given
            String NIF = "67890123F";
            //when
            gestionPeliculas.eliminarEmpleado(NIF);
            //then
            verify(daoPeliculas).eliminarEmpleado(NIF);
        }

        @Test
        void modificarEmpleado() {
            //given
            Empleado empleado = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
            //when
            gestionPeliculas.modificarEmpleado(empleado);
            //then
            verify(daoPeliculas, times(1)).modificarEmpleado(empleado);
        }

        @ParameterizedTest
        @CsvSource({ "1000.0, 7000.0", "2000.0, 6500.0", "2500.0, 6200.0" })
        void listarEmpleado(double sueldo1, double sueldo2) {
            //given
            List<Empleado> empleados = new LinkedList<>();
            empleados.add(new Empleado("12345678U", "Christopher Nolan", 5500.0, "Director", false));
            empleados.add(new Empleado("23456789V", "Christian Bale", 4500.0, "Actor", false));
            empleados.add(new Empleado("34567890W", "Heath Ledger", 4000.0, "Actor", false));
            empleados.add(new Empleado("45678901X", "Tom Hardy", 5000.0, "Actor", false));
            empleados.add(new Empleado("56789012Y", "Anne Hathaway", 3500.0, "Actriz", false));
            empleados.add(new Empleado("67890123Z", "Ridley Scott", 6000.0, "Director", false));
            //when
            when(daoPeliculas.listarEmpleado(sueldo1, sueldo2)).thenReturn(empleados);
            List<Empleado> empleados2 = gestionPeliculas.listarEmpleado(sueldo1, sueldo2);
            //then
            assertEquals(empleados, empleados2);
        }

        @Test
        void dividirEmpleado() {
            //given
            List<Empleado> empleados = new ArrayList<>();
            Empleado empleado1 = new Empleado("12345678U", "Christopher Nolan", 5500.0, "Director", false);
            Empleado empleado2 = new Empleado("23456789V", "Christian Bale", 4500.0, "Actor", false);
            empleados.add(empleado1);
            empleados.add(empleado2);
            Map<String, List<Empleado>> empleadosPorTrabajo = new HashMap<>();
            List<Empleado> directores = new ArrayList<>();
            directores.add(empleado1);
            empleadosPorTrabajo.put("Director", directores);
            List<Empleado> actores = new ArrayList<>();
            actores.add(empleado2);
            empleadosPorTrabajo.put("Actor", actores);
            //when
            when(daoPeliculas.dividirEmpleado(empleados)).thenReturn(empleadosPorTrabajo);
            Map<String, List<Empleado>> empleadosPorTrabajos = gestionPeliculas.dividirEmpleado(empleados);
            //then
            assertEquals(empleadosPorTrabajo, empleadosPorTrabajos);
            verify(daoPeliculas, times(1)).dividirEmpleado(empleados);
        }
    }

    @DisplayName("Gestionar Escenarios")
    @Nested
    public class GestionarEscenarios {
        @Test
        void getListaEscenario() {
            //given
            Set<Escenario> escenarios = new HashSet<>();
            escenarios.add(new Escenario(7290, "Hollywood", 3500.0, false));
            escenarios.add(new Escenario(4319, "Roma", 2100.0, false));
            escenarios.add(new Escenario(1173, "Nueva York", 2800.0, false));
            escenarios.add(new Escenario(5037, "Las Vegas", 3900.0, false));
            escenarios.add(new Escenario(6616, "París", 2600.0, false));
            //when
            when(daoPeliculas.getListaEscenario()).thenReturn(escenarios);
            Set<Escenario> respuesta = gestionPeliculas.getListaEscenario();
            //then
            assertThat(respuesta).isEqualTo(escenarios);
        }

        @Test
        void modificarEscenario() {
            //given
            Escenario escenario = new Escenario(7290, "Hollywood", 3500.0, false);
            //when
            gestionPeliculas.modificarEscenario(escenario);
            //then
            verify(daoPeliculas, times(1)).modificarEscenario(escenario);
        }

        @Test
        void listarEscenario() {
            //given
            int id = 7290;
            Set<Escenario> escenariosEsperados = new HashSet<>();
            Escenario escenario1 = new Escenario(7290, "Hollywood", 3500.0, false);
            Escenario escenario2 = new Escenario(4319, "Roma", 2100.0, false);
            escenariosEsperados.add(escenario1);
            escenariosEsperados.add(escenario2);
            //when
            when(daoPeliculas.listarEscenario(id)).thenReturn(escenariosEsperados);
            Set<Escenario> escenariosObtenidos = gestionPeliculas.listarEscenario(id);
            //then
            assertThat(escenariosObtenidos).isEqualTo(escenariosEsperados);
        }

    }

    @DisplayName("Prueba de Excepciones")
    @Nested
    public class Excepciones {
        @Test
        void manejarGuionSinEx() throws IdiomaException {
            //given
            Guion guion = new Guion(100, new Empleado("12345678A", "Jaume Suarez",
                    2000.0, "Escritor", false), Idioma.ingles);
            //when
            when(daoPeliculas.manejarGuion(guion)).thenReturn(true);
            boolean respuesta;
            try {
                respuesta = gestionPeliculas.manejarGuion(guion);
            } catch (IdiomaException e) {
                throw new RuntimeException(e);
            }
            //then
            assertThat(respuesta).isTrue();
        }
        @Test
        void manejarGuionConEx() throws IdiomaException {
            //given
            Guion guion = new Guion(100, new Empleado("12345678A", "Jaume Suarez",
                    2000.0, "Escritor", false), Idioma.ingles);
            //when
            boolean respuesta = false;
            try {
                respuesta = gestionPeliculas.manejarGuion(guion);
            } catch (IdiomaException e) {
                assertThat(e.getMessage()).isEqualToIgnoringCase("El idioma no es correcto, debe ser uno de los siguientes: español, ingles, frances, italiano, chino, hindi o arabe");
                assertThat(respuesta).isFalse();
            }
            //then
            verify(daoPeliculas, times(1)).manejarGuion(guion);

        }
    }

}