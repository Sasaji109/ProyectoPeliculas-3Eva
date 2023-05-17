package domain;

import lombok.Data;

@Data
public class Empleado {
    private String NIF;
    private String nombre;
    private double salario;
    private String trabajo;
    private boolean trabajando;

    public Empleado(String NIF, String nombre, double salario, String trabajo, boolean trabajando) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.salario = salario;
        this.trabajo = trabajo;
        this.trabajando = trabajando;
    }

    @Override
    public String toString() {
        return NIF + ";" + nombre + ";" + salario + ";" + trabajo + ";" + trabajando;
    }
}
