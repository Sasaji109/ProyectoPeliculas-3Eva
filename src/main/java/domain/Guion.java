package domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.Idioma;
import lombok.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        Properties properties = new Properties();
        try (InputStream input = Guion.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String jsonFilePath = properties.getProperty("pathGuion");
        if (jsonFilePath == null) {
            System.err.println("No se encontró la propiedad 'pathGuion' en el archivo de propiedades.");
            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src//guion.json")) {
            gson.toJson(guion, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
