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

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GestionPrograma {

    private final IGestionPeliculas iGestionPeliculas;

    public GestionPrograma() {
        this.iGestionPeliculas = new GestionPeliculas();
    }

    public void menuPrograma(){
        Scanner lector = new Scanner(System.in);
        int finBucle = 0;
        int opcion;

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
                    finBucle = 1;
                    break;
                case 2:
                    calcularPresupuesto(cargarPelicula());
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



        Pelicula pelicula = new Pelicula(nombre, guion, presupuesto);

        iGestionPeliculas.crearFicheroBinarioPeliculas();
        iGestionPeliculas.escribirFicheroBinarioPeliculas(pelicula);

        return pelicula;
    }

    public Pelicula cargarPelicula(){
        return iGestionPeliculas.cargarFicheroBinarioPeliculas();
    }

    public void calcularPresupuesto(Pelicula pelicula){
        Map<Integer, Empleado> costesEmpleados = new HashMap<>();
        Map<Integer, Escenario> costesEscenarios = new HashMap<>();
    }

}

