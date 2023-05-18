package common;

public class Comprobacion {

    public static void IdiomaCorrecto(String idioma) throws IdiomaException {
        for (Idioma aux : Idioma.values()) {
            if (aux.toString().equalsIgnoreCase(idioma)) {
                return;
            }
        }
        throw new IdiomaException(idioma);
    }
}
