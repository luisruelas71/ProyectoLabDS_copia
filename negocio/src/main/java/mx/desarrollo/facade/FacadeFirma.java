package mx.desarrollo.facade;

import mx.desarrollo.entity.Firma;
import mx.desarrollo.persistence.integration.ServiceLocator;

public class FacadeFirma {

    public boolean registrarFirma(Firma firma) {
        if (firma == null || firma.getProfesor() == null || firma.getUbicacion() == null) {
            throw new IllegalArgumentException("Los datos obligatorios de la firma están incompletos");
        }

        return ServiceLocator.getFirmaDAO().guardar(firma);
    }
}