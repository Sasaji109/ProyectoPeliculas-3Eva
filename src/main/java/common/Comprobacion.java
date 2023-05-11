package common;

public class Comprobacion {

    public static void IdiomaCorrecto(String idioma) throws IdiomaException {
        boolean lenguaje = false;
        Idioma[] aux = Idioma.values();
        for(int i=0; i<aux.length && !lenguaje; i++){
            System.out.println(aux[i].toString() + " - ");
            if (aux[i].toString().equalsIgnoreCase(idioma))
                lenguaje = true;
        }
        if (!lenguaje) {
            throw new IdiomaException(idioma);
        }
    }
}
