package service;

import dao.DaoPeliculas;
import domain.Empleado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

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
    }

    @Test
    void modificarEmpleado() {
    }

    @Test
    void listarEmpleado() {
    }

    @Test
    void testListarEmpleado() {
    }

    @Test
    void testListarEmpleado1() {
    }

    @Test
    void testListarEmpleado2() {
    }

    @Test
    void testListarEmpleado3() {
    }

    @Test
    void isEmptyEscenariosSet() {
    }

    @Test
    void getListaEscenario() {
    }

    @Test
    void insertarEscenario() {
    }

    @Test
    void eliminarEscenario() {
    }

    @Test
    void modificarEscenario() {
    }
}