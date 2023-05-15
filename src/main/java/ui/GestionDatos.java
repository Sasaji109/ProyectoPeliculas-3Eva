package ui;

import common.Constantes;
import domain.Empleado;
import service.IGestionPeliculas;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestionDatos {

    private final IGestionPeliculas iGestionPeliculas;

    public GestionDatos(IGestionPeliculas iGestionPeliculas) {
        this.iGestionPeliculas = iGestionPeliculas;
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

    public static final String MENUGESTIONAR = "Introduce la opción que quieras: ";
    public static final String OPCION1D = "1. Gestionar lista de Empleados";
    public static final String OPCION2D = "2. Gestionar lista de Escenarios";

    public static final String MENUOPCION1D ="¿Qué deseas hacer con la lista de Empleados?";
    public static final String OPCION1D1 = "1. Listar Empleados";
    public static final String OPCION1D2 = "2. Insertar un nuevo Empleado";
    public static final String OPCION1D3 = "3. Modificar un Empleado";
    public static final String OPCION1D4 = "4. Eliminar un Empleado";
    public static final String OPCION1D5 = "5. Eliminar la lista de Empleados";

    public static final String MENUOPCION2D = "¿Qué deseas hacer con la lista de Escenarios?";
    public static final String OPCION2D1 = "1. Listar Escenarios";
    public static final String OPCION2D2 = "2. Insertar un nuevo Escenario";
    public static final String OPCION2D3 = "3. Modificar un Escenario";
    public static final String OPCION2D4 = "4. Eliminar un Escenario";
    public static final String OPCION2D5 = "5. Eliminar la lista de Escenarios";

    public void menuGestionar() {
        Scanner lector = new Scanner(System.in);
        iGestionPeliculas.crearFicheroEmpleados();
        iGestionPeliculas.crearFicheroEscenarios();
        iGestionPeliculas.crearFicheroBinarioPeliculas();
        iGestionPeliculas.escribirFicheroEmpleados();
        iGestionPeliculas.escribirFicheroEscenarios();
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUGESTIONAR+"\n"+Constantes.OPCION1D+"\n"+Constantes.OPCION2D+"\n"+Constantes.SALIR);
            opcion = lector.nextInt();
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
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUOPCION1D+"\n"+Constantes.OPCION1D1+"\n"+Constantes.OPCION1D2+"\n"+Constantes.OPCION1D3+"\n"+Constantes.OPCION1D4+"\n"+Constantes.OPCION1D5+"\n"+Constantes.SALIR);
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    finBucle = 1;
                    break;
                case 2:
                    finBucle = 1;
                    break;
                case 3:
                    finBucle = 1;
                    break;
                case 4:
                    finBucle = 1;
                    break;
                case 5:
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
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUOPCION2D+"\n"+Constantes.OPCION2D1+"\n"+Constantes.OPCION2D2+"\n"+Constantes.OPCION2D3+"\n"+Constantes.OPCION2D4+"\n"+Constantes.OPCION2D5+"\n"+Constantes.SALIR);
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    finBucle = 1;
                    break;
                case 2:
                    finBucle = 1;
                    break;
                case 3:
                    finBucle = 1;
                    break;
                case 4:
                    finBucle = 1;
                    break;
                case 5:
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

}

