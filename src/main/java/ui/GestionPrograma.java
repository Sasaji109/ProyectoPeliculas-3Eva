package ui;

import common.Constantes;
import service.IGestionPeliculas;

import java.util.Scanner;

public class GestionPrograma {

    private final IGestionPeliculas iGestionPeliculas;

    public GestionPrograma(IGestionPeliculas iGestionPeliculas) {
        this.iGestionPeliculas = iGestionPeliculas;
    }

    public void menuPrograma(){
        Scanner lector = new Scanner(System.in);
        int finBucle = 0;
        int opcion;
        do {
            System.out.println(Constantes.MENUPROGRAMA+"\n"+Constantes.OPCION1P+"\n"+Constantes.OPCION2P+"\n"+Constantes.SALIR);
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
                default:
                    System.out.println(Constantes.OPCIONINCORRECTA);
                    break;
            }
        } while (finBucle!=1);
    }

}

