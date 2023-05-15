package dao;

import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class DaoPeliculasFicheros {

    public static void crearFicheroEmpleados() throws IOException {
        File empleados = new File("Descargas");
        if (!empleados.exists()) {
            empleados.createNewFile();
        }
    }

    public static void escribirFicheroEmpleados(List<Empleado> empleados) throws IOException {
        PrintWriter pw = new PrintWriter("empleados");
        for (Empleado empleado : empleados) {
            pw.println(empleado.toString());
        }
        pw.close();
    }

    public void comprobacionFicheroEmpleados() throws IOException {
        File empleados = new File("empleados");
        if (!empleados.exists()) {
            crearFicheroEmpleados();
            escribirFicheroEmpleados(DaoBaseDeDatos.getListaEmpleados());
        }
    }

    public static List<Empleado> cargarFicheroEmpleados() throws IOException {
        List<Empleado> auxiliar = new LinkedList<>();
        try (Scanner sc = new Scanner(new File("Descargas"))) {
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

    public static void crearFicheroEscenarios() throws IOException {
        File escenarios = new File("ficheroEsc");
        if (!escenarios.exists()) {
            escenarios.createNewFile();
        }
    }

    public static void escribirFicheroEscenarios(Set<Escenario> escenarios) throws IOException {
        crearFicheroEscenarios();
        PrintWriter pw = new PrintWriter("ficheroEmp");
        for (Escenario escenario : escenarios) {
            pw.println(escenario.toString());
        }
        pw.close();
    }

    public void comprobacionFicheroEscenarios() throws IOException {
        File escenarios = new File("ficheroEsc");
        if (!escenarios.exists()) {
            crearFicheroEscenarios();
            escribirFicheroEscenarios(DaoBaseDeDatos.getListaEscenarios());
        }
    }

    public static Set<Escenario> cargarFicheroEscenarios() throws IOException {
        Set<Escenario> auxiliar = null;
        try (Scanner sc = new Scanner(new File("ficheroEsc"))) {
            auxiliar = new HashSet<>();
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
        crearFicheroBinarioPeliculas();
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("ficheroPelis"))) {
            os.writeObject(pelicula);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static Pelicula cargarFicheroBinarioPeliculas() {
        Pelicula pelicula = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("ficheroPelis"))) {
            pelicula = (Pelicula) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return pelicula;
    }

    //Pelicula peliculaCargada = cargarFicheroBinarioPeliculas();

}
