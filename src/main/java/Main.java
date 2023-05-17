import common.Constantes;
import ui.GestionDatos;
import ui.GestionPrograma;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GestionDatos gestionDatos = new GestionDatos();
        GestionPrograma gestionPrograma = new GestionPrograma();
        Scanner lector = new Scanner(System.in);
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUPRINCIPAL+"\n"+Constantes.GESTIONPROGRAMA+"\n"+Constantes.GESTIONDATOS+"\n"+Constantes.SALIR);
            try {
                opcion = lector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Las letras no están permitidas, introduce un número");
                lector.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    gestionPrograma.menuPrograma();
                    finBucle = 1;
                    break;
                case 2:
                    boolean esValido = GestionDatos.validarUsuario();
                    if (esValido) {
                        gestionDatos.menuGestionar();
                        finBucle = 1;
                    } else {
                        System.out.println(Constantes.USUARIOINVALIDO+"\n");
                    }
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

}
