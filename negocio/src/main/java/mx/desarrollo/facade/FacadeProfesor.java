package mx.desarrollo.facade;

import java.util.regex.Pattern;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.persistence.integration.ServiceLocator;
import org.mindrot.jbcrypt.BCrypt;

public class FacadeProfesor {

    private static final Pattern FORMATO_CORREO =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");


    public Profesor iniciarSesion(String correo, String contrasena) {
        if (correo == null || correo.isBlank() || contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException("Completa todos los campos");
        }
        String correoLimpio = correo.trim();
        if (correoLimpio.length() > 60 || !FORMATO_CORREO.matcher(correoLimpio).matches()) {
            throw new IllegalArgumentException("El formato del correo no es válido");
        }
        // Pendiente de confirmar con el cliente: restringir al dominio institucional.

        Profesor profesor = ServiceLocator.getProfesorDAO().buscarPorCorreo(correoLimpio);
        if (profesor == null || !contrasenaValida(contrasena, profesor.getContrasena())) {
            return null;
        }
        return profesor;
    }

    private boolean contrasenaValida(String plana, String hash) {
        try {
            return BCrypt.checkpw(plana, hash);
        } catch (IllegalArgumentException e) {
            return false; // el hash guardado no tiene formato BCrypt
        }
    }
}