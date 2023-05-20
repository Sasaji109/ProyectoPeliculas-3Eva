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

    public static void IdiomaCorrecto(Idioma idioma) throws IdiomaException {
        for (Idioma aux : Idioma.values()) {
            if (aux == idioma) {
                return;
            }
        }
        throw new IdiomaException(idioma);
    }
}
