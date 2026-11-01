package ui;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Map;
import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.entity.Profesor;
//import org.hibernate.Hibernate;

@Named("loginController")
@RequestScoped
public class Login implements Serializable {

    private String correo;
    private String contraseña;

    public String iniciarSesion() {
        if (correo == null || correo.isBlank() || contraseña == null || contraseña.isEmpty()) {
            mostrarError("Completa todos los campos");
            return null;
        }
        try {
            Profesor profesor = new DelegateProfesor().iniciarSesion(correo, contraseña);
            if (profesor == null) {
                mostrarError("Correo o contraseña incorrectos");
                return null;
            }
            Map<String, Object> sesion =
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sesion.put("profesorId", profesor.getId());
            sesion.put("profesorCorreo", profesor.getCorreoInstitucional());

            //if (profesor.getTipo() != null && Hibernate.isInitialized(profesor.getTipo())) {
                sesion.put("profesorTipo", profesor.getTipo().getNombreTipo());
                sesion.put("profesorLimiteFirmas", profesor.getTipo().getLimiteFirmas());
            //}
            return "inicio?faces-redirect=true";
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            mostrarError("No se pudo iniciar sesión. Intenta más tarde.");
            return null;
        }
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    private void mostrarError(String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null));
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
