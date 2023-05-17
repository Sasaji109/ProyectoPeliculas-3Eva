package service;
import dao.DaoPeliculas;
import domain.Empleado;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
        assertThat(respuesta).isEqualTo(true);
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

    @Test
    void listarEscenario() {
    }

    @Test
    void testListarEscenario() {
    }

    @Test
    void testListarEscenario1() {
    }

    @Test
    void testListarEscenario2() {
    }
}