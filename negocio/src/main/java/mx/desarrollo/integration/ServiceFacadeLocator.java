package mx.desarrollo.integration;

import mx.desarrollo.facade.FacadeProfesor;

public class ServiceFacadeLocator {

    private static FacadeProfesor facadeProfesor;

    private ServiceFacadeLocator() {
    }

    public static synchronized FacadeProfesor getFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
        }
        return facadeProfesor;
    }
}