package dao;

import domain.Empleado;
import domain.Escenario;
import domain.Pelicula;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class DaoPeliculasFicheros {

    public static void crearFicheroEmpleados() throws IOException {
        File empleados = new File("ficheroEmp");
        if (!empleados.exists()) {
            empleados.createNewFile();
        }
    }

    public static void escribirFicheroEmpleados(List<Empleado> empleados) throws IOException {
        crearFicheroEmpleados();
        PrintWriter pw = new PrintWriter("ficheroEmp");
        for (Empleado empleado : empleados) {
            pw.println(empleado.toString());
        }
        pw.close();
    }

    public static List<Empleado> cargarFicheroEmpleados(String fichero) throws IOException {
        List<Empleado> auxiliar = null;
        try (Scanner sc = new Scanner(new File("ficheroEmp"))) {
            auxiliar = new LinkedList<>();
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

    public static void cargarFicheroBinarioPeliculas() {
        Pelicula auxiliar = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("ficheroPelis"))) {
            auxiliar = (Pelicula) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPeliculasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

        }
    }

}
