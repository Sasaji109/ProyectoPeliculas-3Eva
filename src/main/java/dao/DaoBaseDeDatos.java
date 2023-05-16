package dao;

import domain.Empleado;
import domain.Escenario;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DaoBaseDeDatos {

    private static List<Empleado> empleados;
    private static Set<Escenario> escenarios;


    public DaoBaseDeDatos() {
        this.empleados = new LinkedList<>();
        this.escenarios = new HashSet<>();

        empleados.add(new Empleado("12345678A", "John Smith", 2000.0, "Actor", false));
        empleados.add(new Empleado("23456789B", "Jane Doe", 2500.0, "Director", false));
        empleados.add(new Empleado("45678901D", "Tom Hanks", 3000.0, "Actor", false));
        empleados.add(new Empleado("56789012E", "Meryl Streep", 3500.0, "Actriz", false));
        empleados.add(new Empleado("67890123F", "Brad Pitt", 4000.0, "Actor", false));
        empleados.add(new Empleado("78901234G", "Angelina Jolie", 4500.0, "Actriz", false));
        empleados.add(new Empleado("89012345H", "Steven Spielberg", 6000.0, "Director", false));
        empleados.add(new Empleado("90123456I", "Martin Scorsese", 5500.0, "Director", false));
        empleados.add(new Empleado("01234567J", "Leonardo DiCaprio", 4500.0, "Actor", false));
        empleados.add(new Empleado("12345678K", "Kate Winslet", 4000.0, "Actriz", false));
        empleados.add(new Empleado("23456789L", "James Cameron", 6500.0, "Director", false));
        empleados.add(new Empleado("34567890M", "Robert De Niro", 5000.0, "Actor", false));
        empleados.add(new Empleado("45678901N", "Al Pacino", 5500.0, "Actor", false));
        empleados.add(new Empleado("56789012O", "Quentin Tarantino", 6000.0, "Director", false));
        empleados.add(new Empleado("67890123P", "Uma Thurman", 3500.0, "Actriz", false));
        empleados.add(new Empleado("78901234Q", "Samuel L. Jackson", 4500.0, "Actor", false));
        empleados.add(new Empleado("89012345R", "Tim Burton", 5000.0, "Director", false));
        empleados.add(new Empleado("90123456S", "Johnny Depp", 4000.0, "Actor", false));
        empleados.add(new Empleado("01234567T", "Helena Bonham Carter", 3500.0, "Actriz", false));
        empleados.add(new Empleado("12345678U", "Christopher Nolan", 5500.0, "Director", false));
        empleados.add(new Empleado("23456789V", "Christian Bale", 4500.0, "Actor", false));
        empleados.add(new Empleado("34567890W", "Heath Ledger", 4000.0, "Actor", false));
        empleados.add(new Empleado("45678901X", "Tom Hardy", 5000.0, "Actor", false));
        empleados.add(new Empleado("56789012Y", "Anne Hathaway", 3500.0, "Actriz", false));
        empleados.add(new Empleado("67890123Z", "Ridley Scott", 6000.0, "Director", false));

        empleados.add(new Empleado("14725689D", "Sara García", 2500.50, "Productor", false));
        empleados.add(new Empleado("25896314E", "Pablo Rodríguez", 1800.75, "Productor", false));
        empleados.add(new Empleado("36987412F", "Lucía Hernández", 3000.0, "Director de fotografía", false));
        empleados.add(new Empleado("89326561A", "Juan Martínez", 3200.00, "Director de fotografía", false));
        empleados.add(new Empleado("47851236G", "Juan Pérez", 2200.0, "Montador", false));
        empleados.add(new Empleado("37269080J", "Ana García", 3000.00, "Montadora", false));
        empleados.add(new Empleado("58624791H", "Ana Torres", 2700.0, "Sonidista", false));
        empleados.add(new Empleado("94527853W", "Jorge Martín", 1800.00, "Sonidista", false));
        empleados.add(new Empleado("69325847I", "Diego Sánchez", 1500.0, "Ayudante de producción", false));
        empleados.add(new Empleado("34761209E", "Luisa Fernández", 2400.00, "Ayudante de producción", false));
        empleados.add(new Empleado("78542136J", "Laura Gómez", 2000.0, "Maquilladora", false));
        empleados.add(new Empleado("36987412M", "Miguel García", 2900.0, "Maquillador", false));
        empleados.add(new Empleado("89562314K", "Pedro Martínez", 1800.50, "Director de arte", false));
        empleados.add(new Empleado("98741256L", "María López", 2200.0, "Directora de arte", false));
        empleados.add(new Empleado("14725689O", "Carla Pérez", 2100.0, "Jefa de producción", false));
        empleados.add(new Empleado("01655339L", "Marcos Gómez", 2200.00, "Jefe de producción", false));
        empleados.add(new Empleado("25896314N", "Sofía Fernández", 1800.0, "Vestuario", false));
        empleados.add(new Empleado("89562314P", "Cristina Martín", 2400.0, "Vestuario", false));
        empleados.add(new Empleado("78542136Q", "Javier Sánchez", 1900.0, "Asistente de dirección", false));
        empleados.add(new Empleado("78542136Y", "Marta Pérez", 2000.0, "Asistente de dirección", false));
        empleados.add(new Empleado("69325847R", "Mario Torres", 1700.0, "Electricista", false));
        empleados.add(new Empleado("35694080S", "Pedro López", 1500.00, "Electricista", false));
        empleados.add(new Empleado("58624791S", "Paula Gómez", 2500.0, "Coordinadora de producción", false));
        empleados.add(new Empleado("01892473B", "Elena Sánchez", 1800.00, "Coordinadora de producción", false));
        empleados.add(new Empleado("47851236T", "Carlos Martínez", 2000.0, "Efectos especiales", false));
        empleados.add(new Empleado("79640264D", "Sara García", 2000.00, "Efectos especiales", false));
        empleados.add(new Empleado("36987412U", "Sandra López", 3000.0, "Directora de casting", false));
        empleados.add(new Empleado("78453012G", "Laura Pérez", 2500.00, "Directora de casting", false));
        empleados.add(new Empleado("25896314V", "Andrea García", 1800.0, "Ayudante de cámara", false));
        empleados.add(new Empleado("54081723F", "Lucía Ramos", 1800.00, "Ayudante de cámara", false));
        empleados.add(new Empleado("14725689W", "Jorge Rodríguez", 2200.0, "Supervisor de postproducción", false));
        empleados.add(new Empleado("89562314X", "Lucas Hernández", 2500.0, "Supervisor de postproducción", false));
        empleados.add(new Empleado("69325847Z", "Irene Torres", 1700.0, "Editor", false));
        empleados.add(new Empleado("11111111A", "Luis García", 2300.0, "Editor", false));

        escenarios.add(new Escenario(7290, "Hollywood", 3500.0, false));
        escenarios.add(new Escenario(4319, "Roma", 2100.0, false));
        escenarios.add(new Escenario(1173, "Nueva York", 2800.0, false));
        escenarios.add(new Escenario(5037, "Las Vegas", 3900.0, false));
        escenarios.add(new Escenario(6616, "París", 2600.0, false));
        escenarios.add(new Escenario(8091, "Sídney", 3100.0, false));
        escenarios.add(new Escenario(2994, "Londres", 2900.0, false));
        escenarios.add(new Escenario(9346, "Tokio", 4000.0, false));
        escenarios.add(new Escenario(6857, "Berlín", 2200.0, false));
        escenarios.add(new Escenario(1029, "Ámsterdam", 1800.0, false));
        escenarios.add(new Escenario(4884, "Nápoles", 2400.0, false));
        escenarios.add(new Escenario(7668, "Miami", 3200.0, false));
        escenarios.add(new Escenario(3209, "Barcelona", 2000.0, false));
        escenarios.add(new Escenario(8837, "Hong Kong", 3600.0, false));
        escenarios.add(new Escenario(1738, "San Francisco", 2700.0, false));
        escenarios.add(new Escenario(6022, "Dublín", 1900.0, false));
        escenarios.add(new Escenario(9546, "Viena", 2500.0, false));
        escenarios.add(new Escenario(2617, "Marrakech", 1500.0, false));
        escenarios.add(new Escenario(7153, "Buenos Aires", 3400.0, false));
        escenarios.add(new Escenario(3664, "Moscú", 3700.0, false));
        escenarios.add(new Escenario(9881, "Estambul", 2900.0, false));
        escenarios.add(new Escenario(5288, "Los Ángeles", 3600.0, false));
        escenarios.add(new Escenario(6901, "Seúl", 3800.0, false));
        escenarios.add(new Escenario(1166, "Santiago de Chile", 2600.0, false));
        escenarios.add(new Escenario(4803, "Shanghái", 3200.0, false));
        escenarios.add(new Escenario(1347, "Chicago", 2300.0, false));
        escenarios.add(new Escenario(6750, "Bangkok", 2700.0, false));
        escenarios.add(new Escenario(2018, "África del Sur", 4000.0, false));
        escenarios.add(new Escenario(9340, "Praga", 1900.0, false));
        escenarios.add(new Escenario(2547, "Edimburgo", 2000.0, false));
        escenarios.add(new Escenario(7577, "México D.F.", 3100.0, false));
        escenarios.add(new Escenario(3910, "San Petersburgo", 2800.0, false));
    }

    public static List<Empleado> getListaEmpleados() {
        return empleados;
    }
    public static Set<Escenario> getListaEscenarios() {
        return escenarios;
    }

    public void setListaEmpleados(List<Empleado> empleados) {
        this.empleados.clear();
        this.empleados.addAll(empleados);
    }

    public void setListaEscenarios(Set<Escenario> escenarios) {
        this.escenarios.clear();
        this.escenarios.addAll(escenarios);
    }
}
