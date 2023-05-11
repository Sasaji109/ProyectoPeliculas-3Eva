package domain;

import common.Idioma;
import lombok.Data;

@Data
public class Guion {

    private int numPag;
    private Empleado escritor;
    private Idioma idioma;

    public Guion(int numPag, Empleado escritor, Idioma idioma) {
        this.numPag = numPag;
        this.escritor = escritor;
        this.idioma = idioma;
    }

    public void imprimirGuion(Guion guion) {

    }
}
