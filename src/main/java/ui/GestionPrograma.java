package ui;

import common.Comprobacion;
import common.Constantes;
import common.Idioma;
import common.IdiomaException;
import domain.Empleado;
import domain.Escenario;
import domain.Guion;
import domain.Pelicula;
import service.GestionPeliculas;
import service.IGestionPeliculas;

import java.util.*;

public class GestionPrograma {

    private final IGestionPeliculas iGestionPeliculas;

    public GestionPrograma() {
        this.iGestionPeliculas = new GestionPeliculas();
    }

    public void menuPrograma(){
        Scanner lector = new Scanner(System.in);
        int opcion = 0;

        iGestionPeliculas.crearFicheroEmpleados();
        iGestionPeliculas.crearFicheroEscenarios();
        iGestionPeliculas.escribirFicheroEmpleados();
        iGestionPeliculas.escribirFicheroEscenarios();

        do {
            System.out.println(Constantes.MENUPROGRAMA+"\n"+Constantes.OPCION1P+"\n"+Constantes.OPCION2P+"\n"+Constantes.SALIR);
            try {
                opcion = lector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Las letras no están permitidas, introduce un número");
                lector.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    calcularPresupuesto(organizarPelicula());
                    break;
                case 2:
                    calcularPresupuesto(cargarPelicula());
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while (opcion!=3);
    }

    public Pelicula organizarPelicula(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre de tu película:");
        String nombre = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingresa el presupuesto que tendrá tu película:");
        double presupuesto = scanner.nextDouble();

        System.out.print("Vamos con el guión");
        System.out.print("Número de páginas del guion: ");
        int numPag = scanner.nextInt();
        System.out.print("Nombre del escritor: ");
        String nombreEscritor = scanner.nextLine();
        scanner.nextLine();
        System.out.print("NIF del escritor: ");
        String nifEscritor = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Salario del escritor: ");
        double salarioEscritor = scanner.nextDouble();
        System.out.print("Idioma del guion: ");
        String idioma = scanner.nextLine();
        scanner.nextLine();

        try {
            Comprobacion.IdiomaCorrecto(idioma);
        } catch (IdiomaException e) {
            throw new RuntimeException(e);
        }

        Empleado guionista = new Empleado(nifEscritor, nombreEscritor, salarioEscritor, "guionista", true);
        Guion guion = new Guion(numPag, guionista, Idioma.valueOf(idioma));
        List<Empleado> empleadosPelicula = contratarEmpleados();
        Set<Escenario> escenariosPelicula = alquilarEscenarios();

        Pelicula pelicula = new Pelicula(nombre, guion, presupuesto, empleadosPelicula, escenariosPelicula);
        iGestionPeliculas.crearFicheroBinarioPeliculas();
        iGestionPeliculas.escribirFicheroBinarioPeliculas(pelicula);
        return pelicula;
    }

    public List<Empleado> contratarEmpleados() {
        Scanner lector = new Scanner(System.in);
        List<Empleado> empleadosPelicula = new LinkedList<>();
        List<Empleado> empleados = iGestionPeliculas.getListaEmpleado();

        System.out.println("Ahora te toca contratar a los empleados. Escoge la opción que desees");
        System.out.println("1. Ver lista completa de empleados");
        System.out.println("2. Buscar empleado por NIF");
        System.out.println("3. Buscar empleados por rango de sueldo");
        System.out.println("4. Añadir empleado a la lista de la película");
        System.out.println("5. Ver lista completa de empleados de la película");
        System.out.println("6. Pasar al siguiente paso (Si haces esto no podrás volver atrás)");
        System.out.println("7. Salir");
        int opcion = lector.nextInt();
        do {

            switch (opcion) {
                case 1:
                    System.out.println(iGestionPeliculas.getListaEmpleado());
                    break;
                case 2:
                    System.out.println("Introduce el NIF");
                    String NIF = lector.nextLine();
                    lector.nextLine();
                    System.out.println(iGestionPeliculas.listarEmpleado(NIF));
                    break;
                case 3:
                    System.out.println("Introduce el sueldo mínimo");
                    double sueldoMin = lector.nextDouble();
                    System.out.println("Introduce el sueldo máximo");
                    double sueldoMax = lector.nextDouble();
                    System.out.println(iGestionPeliculas.listarEmpleado(sueldoMin, sueldoMax));
                    break;
                case 4:
                    //Añadir empleado
                    break;
                case 5:
                    System.out.println(empleadosPelicula);
                    break;
                case 6:
                    alquilarEscenarios();
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while(opcion!=7);
        return empleadosPelicula;
    }

    public Set<Escenario> alquilarEscenarios() {
        Scanner lector = new Scanner(System.in);
        Set<Escenario> escenariosPelicula = new HashSet<>();
        Set<Escenario> escenarios = iGestionPeliculas.getListaEscenario();

        System.out.println("Ahora te toca alquilar los escenarios. Escoge la opción que desees:");
        System.out.println("1. Ver lista completa de empleados");
        System.out.println("2. Buscar escenarios por id");
        System.out.println("3. Buscar escenarios por rango de alquiler");
        System.out.println("4. Añadir escenario a la lista de la película");
        System.out.println("5. Ver lista completa de escenarios de la película");
        System.out.println("6. Pasar al siguiente paso (Si haces esto no podrás volver atrás)");
        System.out.println("7. Salir");
        int opcion = lector.nextInt();
        do {

            switch (opcion) {
                case 1:
                    System.out.println(iGestionPeliculas.getListaEscenario());
                    break;
                case 2:
                    System.out.println("Introduce el id");
                    int id = lector.nextInt();
                    System.out.println(iGestionPeliculas.listarEscenario(id));
                    break;
                case 3:
                    System.out.println("Introduce el alquiler mínimo");
                    double alquilerMin = lector.nextDouble();
                    System.out.println("Introduce el alquiler máximo");
                    double alquilerMax = lector.nextDouble();
                    System.out.println(iGestionPeliculas.listarEscenario(alquilerMin, alquilerMax));
                    break;
                case 4:
                    //Añadir escenario
                    break;
                case 5:
                    System.out.println(escenariosPelicula);
                    break;
                case 6:
                    alquilarEscenarios();
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while(opcion!=7);
        return escenariosPelicula;
    }

    public Pelicula cargarPelicula(){
        return iGestionPeliculas.cargarFicheroBinarioPeliculas();
    }

    public void calcularPresupuesto(Pelicula pelicula){
        Map<Integer, Empleado> costesEmpleados = new HashMap<>();
        Map<Integer, Escenario> costesEscenarios = new HashMap<>();
    }

}

