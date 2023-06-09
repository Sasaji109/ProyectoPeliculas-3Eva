package dao;

import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class DaoPeliculasFicheros {

    public void crearFicheroEmpleados() {
        File empleados = new File("src//empleados");
        if (!empleados.exists()) {
            try {
                empleados.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void escribirFicheroEmpleados(List<Empleado> empleados) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("src//empleados");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Empleado empleado : empleados) {
            pw.println(empleado.toString());
        }
        pw.close();
    }

    public static List<Empleado> cargarFicheroEmpleados() {
        List<Empleado> auxiliar = new LinkedList<>();
        try (Scanner sc = new Scanner(new File("src//empleados"))) {
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                Empleado empleado = new Empleado(trozos[0], trozos[1], Double.parseDouble(trozos[2]), trozos[3], Boolean.parseBoolean(trozos[4]));
                auxiliar.add(empleado);
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, e.getMessage(), e);

        }
        return auxiliar;
    }

    public void crearFicheroEscenarios() {
        File escenarios = new File("src//escenarios");
        if (!escenarios.exists()) {
            try {
                escenarios.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void escribirFicheroEscenarios(Set<Escenario> escenarios) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("src//escenarios");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Escenario escenario : escenarios) {
            pw.println(escenario.toString());
        }
        pw.close();
    }

    public static Set<Escenario> cargarFicheroEscenarios() {
        Set<Escenario> auxiliar = new HashSet<>();
        try (Scanner sc = new Scanner(new File("src//escenarios"))) {
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                Escenario escenario = new Escenario(Integer.parseInt(trozos[0]), trozos[2], Double.parseDouble(trozos[1]), Boolean.parseBoolean(trozos[3]));
                auxiliar.add(escenario);
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, e.getMessage(), e);

        }
        return auxiliar;
    }

    public static void crearFicheroBinarioPeliculas() {
        File peliculas = new File("src//ficheroPelis");
        if (!peliculas.exists()) {
            try {
                peliculas.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void escribirFicheroBinarioPeliculas(Pelicula pelicula) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src//ficheroPelis"))) {
            os.writeObject(pelicula);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            java.util.logging.Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public Pelicula cargarFicheroBinarioPeliculas() {
        Pelicula pelicula = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("src//ficheroPelis"))) {
            pelicula = (Pelicula) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return pelicula;
    }

}
