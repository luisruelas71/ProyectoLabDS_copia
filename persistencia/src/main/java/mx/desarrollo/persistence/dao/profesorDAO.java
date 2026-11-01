package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.persistence.persistence.hibernateUtils;

public class profesorDAO {


    public Profesor buscarPorCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            return null;
        }
        EntityManager em = hibernateUtils.getEntityManager();
        try {
            return  em.createQuery(
                            "SELECT p FROM Profesor p JOIN FETCH p.tipo "
                                    + "WHERE LOWER(p.correoInstitucional) = :correo",
                            Profesor.class)
                    .setParameter("correo", correo.trim().toLowerCase())
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

        } finally {
            em.close();
        }
    }
}