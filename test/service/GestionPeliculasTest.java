package service;

import dao.DaoPeliculas;
import domain.Empleado;
import domain.Escenario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GestionPeliculasTest {

    @InjectMocks
    GestionPeliculas gestionPeliculas;

    @Mock
    DaoPeliculas daoPeliculas;

    @Test
    void isEmptyEmpleadosList() {
        //given
        when(daoPeliculas.isEmptyEmpleadosList()).thenReturn(true);
        //when
        boolean respuesta = gestionPeliculas.isEmptyEmpleadosList();
        //then
        assertThat(respuesta).isTrue();
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
        List<Empleado> respuesta = gestionPeliculas.getListaEmpleado();
        //then
        assertThat(respuesta).isEqualTo(empleados);
    }

    @Test
    void insertarEmpleado() {
        //given
        Empleado empleado = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
        //when
        when(daoPeliculas.insertarEmpleado(empleado)).thenReturn(true);
        boolean respuesta = gestionPeliculas.insertarEmpleado(empleado);
        //then
        assertThat(respuesta).isTrue();
    }

    @Test
    void eliminarEmpleado() {
        //given
        Empleado empleado = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
        //when
        when(daoPeliculas.insertarEmpleado(empleado)).thenReturn(true);
        boolean respuesta = gestionPeliculas.insertarEmpleado(empleado);
        //then
        assertThat(respuesta).isTrue();
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

    @DisplayName("Listando Empleados")
    @Nested
    public class ListarEmpleados {

        @Test
        void listarEmpleado() {
            //given
            String NIF = "12345678A";
            List<Empleado> empleadosEsperados = new ArrayList<>();
            Empleado empleado1 = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
            Empleado empleado2 = new Empleado("12345678A", "John Smith", 2000.0, "Actor", false);
            empleadosEsperados.add(empleado1);
            empleadosEsperados.add(empleado2);
            //when
            when(daoPeliculas.listarEmpleado(NIF)).thenReturn(empleadosEsperados);
            List<Empleado> empleadosObtenidos = gestionPeliculas.listarEmpleado(NIF);
            //then
            assertThat(empleadosObtenidos).isEqualTo(empleadosEsperados);
        }

        @Test
        void testListarEmpleado() {
            //given
            String NIF = "12345678A";
            String trabajo = "Actor";
            List<Empleado> empleadosEsperados = new ArrayList<>();
            Empleado empleado1 = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
            Empleado empleado2 = new Empleado("12345678A", "John Smith", 2000.0, "Actor", false);
            empleadosEsperados.add(empleado1);
            empleadosEsperados.add(empleado2);
            //when
            when(daoPeliculas.listarEmpleado(NIF, trabajo)).thenReturn(empleadosEsperados);
            List<Empleado> empleadosObtenidos = gestionPeliculas.listarEmpleado(NIF, trabajo);
            //then
            assertThat(empleadosObtenidos).isEqualTo(empleadosEsperados);
        }

        @Test
        void testListarEmpleado1() {
            //given
            double sueldo = 2000.0;
            List<Empleado> empleadosEsperados = new ArrayList<>();
            Empleado empleado1 = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
            Empleado empleado2 = new Empleado("12345678A", "John Smith", 2000.0, "Actor", false);
            empleadosEsperados.add(empleado1);
            empleadosEsperados.add(empleado2);
            //when
            when(daoPeliculas.listarEmpleado(sueldo)).thenReturn(empleadosEsperados);
            List<Empleado> empleadosObtenidos = gestionPeliculas.listarEmpleado(sueldo);
            //then
            assertThat(empleadosObtenidos).isEqualTo(empleadosEsperados);
        }

        @Test
        void testListarEmpleado2() {
            //given
            String NIF = "12345678A";
            double sueldo = 2000.0;
            List<Empleado> empleadosEsperados = new ArrayList<>();
            Empleado empleado1 = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
            Empleado empleado2 = new Empleado("12345678A", "John Smith", 2000.0, "Actor", false);
            empleadosEsperados.add(empleado1);
            empleadosEsperados.add(empleado2);
            //when
            when(daoPeliculas.listarEmpleado(NIF, sueldo)).thenReturn(empleadosEsperados);
            List<Empleado> empleadosObtenidos = gestionPeliculas.listarEmpleado(NIF, sueldo);
            //then
            assertThat(empleadosObtenidos).isEqualTo(empleadosEsperados);
        }

        @Test
        void testListarEmpleado3() {
            //given
            boolean trabajando = false;
            List<Empleado> empleadosEsperados = new ArrayList<>();
            Empleado empleado1 = new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false);
            Empleado empleado2 = new Empleado("12345678A", "John Smith", 2000.0, "Actor", false);
            empleadosEsperados.add(empleado1);
            empleadosEsperados.add(empleado2);
            //when
            when(daoPeliculas.listarEmpleado(trabajando)).thenReturn(empleadosEsperados);
            List<Empleado> empleadosObtenidos = gestionPeliculas.listarEmpleado(trabajando);
            //then
            assertThat(empleadosObtenidos).isEqualTo(empleadosEsperados);
        }
    }

    @Test
    void isEmptyEscenariosSet() {
        //given
        when(daoPeliculas.isEmptyEscenariosSet()).thenReturn(true);
        //when
        boolean respuesta = gestionPeliculas.isEmptyEscenariosSet();
        //then
        assertThat(respuesta).isTrue();
    }

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
    void insertarEscenario() {
        //given
        Escenario escenario = new Escenario(7290, "Hollywood", 3500.0, false);
        //when
        when(daoPeliculas.insertarEscenario(escenario)).thenReturn(true);
        boolean respuesta = gestionPeliculas.insertarEscenario(escenario);
        //then
        assertThat(respuesta).isTrue();
    }

    @Test
    void eliminarEscenario() {
        //given
        Escenario escenario = new Escenario(7290, "Hollywood", 3500.0, false);
        //when
        when(daoPeliculas.insertarEscenario(escenario)).thenReturn(true);
        boolean respuesta = gestionPeliculas.insertarEscenario(escenario);
        //then
        assertThat(respuesta).isTrue();
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

    @DisplayName("Listando Escenarios")
    @Nested
    public class ListarEscenarios {
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

        @Test
        void testListarEscenario() {
            //given
            String lugar = "Hollywood";
            Set<Escenario> escenariosEsperados = new HashSet<>();
            Escenario escenario1 = new Escenario(7290, "Hollywood", 3500.0, false);
            Escenario escenario2 = new Escenario(4319, "Roma", 2100.0, false);
            escenariosEsperados.add(escenario1);
            escenariosEsperados.add(escenario2);
            //when
            when(daoPeliculas.listarEscenario(lugar)).thenReturn(escenariosEsperados);
            Set<Escenario> escenariosObtenidos = gestionPeliculas.listarEscenario(lugar);
            //then
            assertThat(escenariosObtenidos).isEqualTo(escenariosEsperados);
        }

        @Test
        void testListarEscenario1() {
            //given
            double alquiler = 3500.0;
            Set<Escenario> escenariosEsperados = new HashSet<>();
            Escenario escenario1 = new Escenario(7290, "Hollywood", 3500.0, false);
            Escenario escenario2 = new Escenario(4319, "Roma", 2100.0, false);
            escenariosEsperados.add(escenario1);
            escenariosEsperados.add(escenario2);
            //when
            when(daoPeliculas.listarEscenario(alquiler)).thenReturn(escenariosEsperados);
            Set<Escenario> escenariosObtenidos = gestionPeliculas.listarEscenario(alquiler);
            //then
            assertThat(escenariosObtenidos).isEqualTo(escenariosEsperados);
        }

        @Test
        void testListarEscenario2() {
            //given
            int id = 7290;
            double alquiler = 3500.0;
            Set<Escenario> escenariosEsperados = new HashSet<>();
            Escenario escenario1 = new Escenario(7290, "Hollywood", 3500.0, false);
            Escenario escenario2 = new Escenario(4319, "Roma", 2100.0, false);
            escenariosEsperados.add(escenario1);
            escenariosEsperados.add(escenario2);
            //when
            when(daoPeliculas.listarEscenario(id, alquiler)).thenReturn(escenariosEsperados);
            Set<Escenario> escenariosObtenidos = gestionPeliculas.listarEscenario(id, alquiler);
            //then
            assertThat(escenariosObtenidos).isEqualTo(escenariosEsperados);
        }
    }


}