package common;

import java.util.Arrays;

public class IdiomaException extends Exception {

    public IdiomaException(String idioma) {
        super("El idioma " + idioma + " no está disponible. Sólo están disponibles:"+ Arrays.toString(Idioma.values()));
    }

}
