import common.Constantes;
import ui.GestionDatos;
import ui.GestionPrograma;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUPRINCIPAL+"\n"+Constantes.GESTIONPROGRAMA+"\n"+Constantes.GESTIONDATOS+"\n"+Constantes.SALIR);
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    //GestionPrograma.menuPrograma();
                    finBucle = 1;
                    break;
                case 2:
                    boolean esValido = GestionDatos.validarUsuario();
                    if (esValido) {
                        //GestionDatos.menuGestionar();
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
