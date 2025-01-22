package es.upgrade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;

import es.upgrade.entidades.Ordenador;

@SpringBootApplication
public class EjercicioJsonApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;
    

    public static void main(String[] args) {
        SpringApplication.run(EjercicioJsonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Ordenador o = context.getBean(Ordenador.class);
        System.out.println("Objeto Ordenador inicial: " + o);

        File file = new File("ordenador.json");

        if (!file.exists()) {
            System.err.println("El archivo ordenador.json no existe.");
            return;
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                jsonBuilder.append(line);
            }

            String json = jsonBuilder.toString();
            Gson gson = new Gson();
            o = gson.fromJson(json, Ordenador.class);

            System.out.println("Objeto Ordenador deserializado: " + o);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
