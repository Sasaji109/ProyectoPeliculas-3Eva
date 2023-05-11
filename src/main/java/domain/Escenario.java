package domain;

import lombok.Data;

@Data
public class Escenario {

    private int id;
    private String lugar;
    private double alquiler;
    private boolean enUso;

    public Escenario(int id, String lugar, double alquiler, boolean enUso) {
        this.id = id;
        this.lugar = lugar;
        this.alquiler = alquiler;
        this.enUso = enUso;
    }
}
