package dao;

import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class DaoPeliculasFicheros {

    public static void crearFicheroEmpleados() {
        File empleados = new File("empleados");
        if (!empleados.exists()) {
            try {
                empleados.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void escribirFicheroEmpleados() {
        List<Empleado> empleados = DaoBaseDeDatos.getListaEmpleados();
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("empleados");
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
        try (Scanner sc = new Scanner(new File("empleados"))) {
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

    public static void crearFicheroEscenarios() {
        File escenarios = new File("escenarios");
        if (!escenarios.exists()) {
            try {
                escenarios.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void escribirFicheroEscenarios() {
        Set<Escenario> escenarios = DaoBaseDeDatos.getListaEscenarios();
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("escenarios");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Escenario escenario : escenarios) {
            pw.println(escenario.toString());
        }
        pw.close();
    }

    public static Set<Escenario> cargarFicheroEscenarios() {
        Set<Escenario> auxiliar = new HashSet<>();;
        try (Scanner sc = new Scanner(new File("escenarios"))) {
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
        File peliculas = new File("ficheroPelis");
        if (!peliculas.exists()) {
            try {
                peliculas.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void escribirFicheroBinarioPeliculas(Pelicula pelicula) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("ficheroPelis"))) {
            os.writeObject(pelicula);
        } catch (IOException ex) {
            Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static Pelicula cargarFicheroBinarioPeliculas() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("ficheroPelis"))) {
            return (Pelicula) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }

        return null;
    }


    //Pelicula peliculaCargada = cargarFicheroBinarioPeliculas();

}
