package mx.desarrollo.persistence.dao;
import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Firma;
import mx.desarrollo.persistence.persistence.hibernateUtils;

public class FirmaDAO {

    public boolean guardar(Firma firma) {
        EntityManager em = hibernateUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(firma);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}