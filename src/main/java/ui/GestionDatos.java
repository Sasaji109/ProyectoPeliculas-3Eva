package ui;

import common.Constantes;
import domain.Empleado;
import domain.Escenario;
import service.GestionPeliculas;
import service.IGestionPeliculas;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestionDatos {

    private final IGestionPeliculas iGestionPeliculas;

    public GestionDatos() {
        this.iGestionPeliculas = new GestionPeliculas();
    }

    private static final String password = "109";

    public static boolean validarUsuario() {
        Scanner lector = new Scanner(System.in);

        System.out.println(Constantes.CORREO);
        String correo = lector.nextLine();
        System.out.println(Constantes.CONTRASENA);
        String contrasena = lector.nextLine();

        if (contrasena.equals(password)) {
            String patronCorreo = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]+$";
            Pattern patron = Pattern.compile(patronCorreo);
            Matcher matcher = patron.matcher(correo);
            return matcher.matches();
        } else {
            return false;
        }
    }

    public void menuGestionar() {
        Scanner lector = new Scanner(System.in);
        int finBucle = 0;
        int opcion;

        iGestionPeliculas.crearFicheroEmpleados();
        iGestionPeliculas.crearFicheroEscenarios();
        iGestionPeliculas.escribirFicheroEmpleados();
        iGestionPeliculas.escribirFicheroEscenarios();

        //Guion guion = new Guion(100, new Empleado("12345678A", "Escritor1", 5000.0, "Escritor", false), Idioma.ingles);
        //Guion.imprimirGuion(guion);

        do {
            System.out.println(Constantes.MENUGESTIONAR+"\n"+Constantes.OPCION1D+"\n"+Constantes.OPCION2D+"\n"+Constantes.SALIR);
            try {
                opcion = lector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Las letras no están permitidas, introduce un número");
                lector.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    opcion1D();
                    finBucle = 1;
                    break;
                case 2:
                    opcion2D();
                    finBucle = 1;
                    break;
                case 3:
                    finBucle = 1;
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while (finBucle!=1);
    }

    public void opcion1D() {
        Scanner lector = new Scanner(System.in);
        List<Empleado> empleados = iGestionPeliculas.cargarFicheroEmpleados();
        Empleado empleado = null;
        String NIF;
        String nombre;
        double salario;
        String trabajo;
        boolean trabajando;
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUOPCION1D+"\n"+Constantes.OPCION1D1+"\n"+Constantes.OPCION1D2+"\n"+Constantes.OPCION1D3+"\n"+Constantes.OPCION1D4+"\n"+Constantes.OPCION1D5+"\n"+Constantes.SALIR2);
            try {
                opcion = lector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Las letras no están permitidas, introduce un número");
                lector.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    opcionesListarEmpleados();
                    finBucle = 1;
                    break;
                case 2:
                    System.out.print("Introduce el NIF del empleado: ");
                    NIF = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Introduce el nombre del empleado: ");
                    nombre = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Introduce el salario del empleado: ");
                    salario = lector.nextDouble();
                    System.out.print("Introduce el trabajo del empleado: ");
                    trabajo = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Indica si el empleado está trabajando (true/false): ");
                    trabajando = lector.nextBoolean();
                    lector.nextLine();
                    empleado = new Empleado(NIF, nombre, salario, trabajo, trabajando);
                    iGestionPeliculas.insertarEmpleado(empleado);
                    finBucle = 1;
                    break;
                case 3:
                    System.out.print("Introduce el NIF del empleado: ");
                    NIF = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Introduce el nombre del empleado: ");
                    nombre = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Introduce el salario del empleado: ");
                    salario = lector.nextDouble();
                    System.out.print("Introduce el trabajo del empleado: ");
                    trabajo = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Indica si el empleado está trabajando (true/false): ");
                    trabajando = lector.nextBoolean();
                    lector.nextLine();
                    empleado = new Empleado(NIF, nombre, salario, trabajo, trabajando);
                    iGestionPeliculas.modificarEmpleado(empleado);
                    finBucle = 1;
                    break;
                case 4:
                    System.out.println("Introduce el NIF");
                    NIF = lector.nextLine();
                    lector.nextLine();
                    iGestionPeliculas.eliminarEmpleado(NIF);
                    finBucle = 1;
                    break;
                case 5:
                    iGestionPeliculas.eliminarListaEmpleados(empleados);
                    finBucle = 1;
                    break;
                case 6:
                    finBucle = 1;
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while (finBucle!=1);
    }

    public void opcionesListarEmpleados() {
        Scanner lector = new Scanner(System.in);
        List<Empleado> empleados = iGestionPeliculas.cargarFicheroEmpleados();
        String NIF;
        String trabajo;
        boolean trabajando;
        double sueldo;
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENULISTAREMPLEADOS+"\n"+Constantes.OPCIONLEMP1+"\n"+Constantes.OPCIONLEMP2+"\n"+Constantes.OPCIONLEMP3+"\n"+Constantes.OPCIONLEMP4+"\n"+Constantes.OPCIONLEMP5+"\n"+Constantes.SALIR2);
            try {
                opcion = lector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Las letras no están permitidas, introduce un número");
                lector.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el NIF");
                    NIF = lector.nextLine();
                    lector.nextLine();
                    System.out.println(iGestionPeliculas.listarEmpleado(NIF));
                    finBucle = 1;
                    break;
                case 2:
                    System.out.println("Introduce el NIF");
                    NIF = lector.nextLine();
                    lector.nextLine();
                    System.out.println("Introduce el trabajo");
                    trabajo = lector.nextLine();
                    System.out.println(iGestionPeliculas.listarEmpleado(NIF,trabajo));
                    finBucle = 1;
                    break;
                case 3:
                    System.out.println("Introduce el sueldo");
                    sueldo = lector.nextDouble();
                    System.out.println(iGestionPeliculas.listarEmpleado(sueldo));
                    finBucle = 1;
                    break;
                case 4:
                    System.out.println("Introduce el NIF");
                    NIF = lector.nextLine();
                    lector.nextLine();
                    System.out.println("Introduce el sueldo");
                    sueldo = lector.nextDouble();
                    lector.nextLine();
                    System.out.println(iGestionPeliculas.listarEmpleado(NIF, sueldo));
                    finBucle = 1;
                    break;
                case 5:
                    System.out.println("¿Deseas listar los empleados que están trabajando? (true/false)");
                    trabajando = lector.nextBoolean();
                    lector.nextLine();
                    System.out.println(iGestionPeliculas.listarEmpleado(trabajando));
                    finBucle = 1;
                    break;
                case 6:
                    finBucle = 1;
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while (finBucle!=1);
    }

    public void opcion2D() {
        Scanner lector = new Scanner(System.in);
        Set<Escenario> escenarios = iGestionPeliculas.cargarFicheroEscenarios();
        Escenario escenario = null;
        int id;
        String lugar;
        double alquiler;
        boolean enUso;
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUOPCION2D+"\n"+Constantes.OPCION2D1+"\n"+Constantes.OPCION2D2+"\n"+Constantes.OPCION2D3+"\n"+Constantes.OPCION2D4+"\n"+Constantes.OPCION2D5+"\n"+Constantes.SALIR2);
            try {
                opcion = lector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Las letras no están permitidas, introduce un número");
                lector.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    opcionesListarEscenarios();
                    finBucle = 1;
                    break;
                case 2:
                    System.out.print("Introduce el id del escenario: ");
                    id = lector.nextInt();
                    System.out.print("Introduce el lugar del escenario: ");
                    lugar = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Introduce el alquiler del escenario: ");
                    alquiler = lector.nextDouble();
                    System.out.print("Indica si el escenario está en uso (true/false): ");
                    enUso = lector.nextBoolean();
                    lector.nextLine();
                    escenario = new Escenario(id, lugar, alquiler, enUso);
                    iGestionPeliculas.insertarEscenario(escenario);
                    finBucle = 1;
                    break;
                case 3:
                    System.out.print("Introduce el id del escenario: ");
                    id = lector.nextInt();
                    System.out.print("Introduce el lugar del escenario: ");
                    lugar = lector.nextLine();
                    lector.nextLine();
                    System.out.print("Introduce el alquiler del escenario: ");
                    alquiler = lector.nextDouble();
                    System.out.print("Indica si el escenario está en uso (true/false): ");
                    enUso = lector.nextBoolean();
                    lector.nextLine();
                    escenario = new Escenario(id, lugar, alquiler, enUso);
                    iGestionPeliculas.modificarEscenario(escenario);
                    finBucle = 1;
                    break;
                case 4:
                    System.out.println("Introduce el id");
                    id = lector.nextInt();
                    iGestionPeliculas.eliminarEscenario(id);
                    finBucle = 1;
                    break;
                case 5:
                    iGestionPeliculas.eliminarListaEscenarios(escenarios);
                    finBucle = 1;
                    break;
                case 6:
                    finBucle = 1;
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while (finBucle!=1);
    }
    public void opcionesListarEscenarios() {
        Scanner lector = new Scanner(System.in);
        Set<Escenario> escenarios = iGestionPeliculas.cargarFicheroEscenarios();
        int id;
        String lugar;
        double alquiler;
        boolean enUso;
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENULISTARESCENARIOS+"\n"+Constantes.OPCIONLESC1+"\n"+Constantes.OPCIONLESC2+"\n"+Constantes.OPCIONLESC3+"\n"+Constantes.OPCIONLESC4+"\n"+Constantes.SALIR3);
            try {
                opcion = lector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Las letras no están permitidas, introduce un número");
                lector.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el id");
                    id = lector.nextInt();
                    System.out.println(iGestionPeliculas.listarEscenario(id));
                    finBucle = 1;
                    break;
                case 2:
                    System.out.println("Introduce el lugar");
                    lugar = lector.nextLine();
                    lector.nextLine();
                    System.out.println(iGestionPeliculas.listarEscenario(lugar));
                    finBucle = 1;
                    break;
                case 3:
                    System.out.println("Introduce el alquiler");
                    alquiler = lector.nextDouble();
                    System.out.println(iGestionPeliculas.listarEscenario(alquiler));
                    finBucle = 1;
                    break;
                case 4:
                    System.out.println("¿Deseas listar los empleados que están trabajando? (true/false)");
                    enUso = lector.nextBoolean();
                    lector.nextLine();
                    System.out.println(iGestionPeliculas.listarEscenario(enUso));
                    finBucle = 1;
                    break;
                case 5:
                    finBucle = 1;
                    break;
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while (finBucle!=1);
    }

}

