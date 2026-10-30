package ui;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("firmaController")
@RequestScoped
public class Firma implements Serializable {

    public String regresar() {
        System.out.println("regresando.");
        return null;
    }

    public String cerrar() {
        System.out.println("regresando.");
        return null;
    }

    public void tomarFoto() {
        System.out.println("Foto tomada.");
    }

    public void descartarFoto() {
        System.out.println("Foto descartada.");
    }

    public String aceptarFoto() {
        System.out.println("Foto aceptada.");
        return null;
    }
}