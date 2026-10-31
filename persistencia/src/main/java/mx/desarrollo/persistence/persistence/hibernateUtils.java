package mx.desarrollo.persistence.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class hibernateUtils {

    private static final String UNIDAD = "persistencePU";
    private static EntityManagerFactory emf;

    private hibernateUtils() {
    }

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(UNIDAD);
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static synchronized void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}