package mx.desarrollo.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_profesor")
public class TipoProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer id;

    @Column(name = "nombre_tipo", nullable = false, length = 30, unique = true)
    private String nombreTipo;

    @Column(name = "limite_firmas")
    private Integer limiteFirmas;

    @OneToMany(mappedBy = "tipo")
    private List<Profesor> profesores = new ArrayList<>();

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombreTipo() { return nombreTipo; }
    public void setNombreTipo(String nombreTipo) { this.nombreTipo = nombreTipo; }

    public Integer getLimiteFirmas() { return limiteFirmas; }
    public void setLimiteFirmas(Integer limiteFirmas) { this.limiteFirmas = limiteFirmas; }

    public List<Profesor> getProfesores() { return profesores; }
    public void setProfesores(List<Profesor> profesores) { this.profesores = profesores; }
}