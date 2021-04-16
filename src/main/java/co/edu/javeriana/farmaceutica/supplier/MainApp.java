package co.edu.javeriana.farmaceutica.supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Clase de entrada para ejecutar el proyecto Spring Boot.
 * 
 * @author Juan Carlos Castellanos <jccastellanos@grupoasd.com.co>
 */
@SpringBootApplication
@EnableScheduling
public class MainApp {

    /**
     * Punto de entrada.
     * 
     * @param args Argumentos.
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

}
