package jb.edu.uce.infrastructure;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jb.edu.uce.domain.model.Asignatura;
import jb.edu.uce.domain.repository.AsignaturaRepository;

@ApplicationScoped
@Transactional
public class AsignaturaRepositoryImpl implements AsignaturaRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Asignatura asignatura) {
        this.em.persist(asignatura);
    }

    @Override
    public void eliminar(Asignatura asignatura) {
        this.em.remove(asignatura);
    }

    @Override
    public Asignatura actualizar(Asignatura asignatura) {
       return this.em.merge(asignatura);
    }

    @Override
    public List<Asignatura> seleccionarNivel(Integer nivel) {
        TypedQuery<Asignatura> query=this.em.createQuery("SELECT a FROM Asignatura a WHERE a.nivel=:nivel", Asignatura.class);
        query.setParameter(nivel, nivel);

        return query.getResultList();
    }

    @Override
    public List<Asignatura> contiene(String palabra) {
        TypedQuery<Asignatura> query=this.em.createQuery("SELECT a FROM Asignatura a WHERE a.nombre LIKE :palabra",Asignatura.class);
        query.setParameter("palabra", "%" +palabra+"%");
        return query.getResultList();
    }

    @Override
    public Integer contarAsignaturas() {
        TypedQuery<String> query= this.em.createQuery("SELECT DISTINCT(a.nombre) FROM Asignatura a", String.class);
        
        return query.getResultList().size();
    }

}
