import mx.desarrollo.entity.Profesor;
import mx.desarrollo.persistence.integration.ServiceLocator;
import mx.desarrollo.persistence.persistence.hibernateUtils;

public class testDAO {

    public static void main(String[] args) {
        Profesor p = ServiceLocator.getProfesorDAO().buscarPorCorreo("prueba@uabc.edu.mx");
        if (p == null) {
            System.out.println("No se encontró el profesor");
        } else {
            System.out.println("Encontrado: " + p.getCorreoInstitucional()
                    + " | tipo: " + p.getTipo().getNombreTipo());
        }

        Profesor noExiste = ServiceLocator.getProfesorDAO().buscarPorCorreo("noexiste@uabc.edu.mx");
        System.out.println("Correo inexistente devuelve null: " + (noExiste == null));

        hibernateUtils.cerrar();
    }
}