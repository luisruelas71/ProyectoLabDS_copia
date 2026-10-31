package mx.desarrollo.delegate;

import mx.desarrollo.entity.Profesor;
import mx.desarrollo.integration.ServiceFacadeLocator;

public class DelegateProfesor {

    public Profesor iniciarSesion(String correo, String contrasena) {
        return ServiceFacadeLocator.getFacadeProfesor().iniciarSesion(correo, contrasena);
    }
}