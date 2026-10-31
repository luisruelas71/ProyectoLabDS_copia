package mx.desarrollo.persistence.integration;

import mx.desarrollo.persistence.dao.profesorDAO;

public class ServiceLocator {

    private static profesorDAO daoProfesor;

    private ServiceLocator() {
    }

    public static synchronized profesorDAO getProfesorDAO() {
        if (daoProfesor == null) {
            daoProfesor = new profesorDAO();
        }
        return daoProfesor;
    }
}