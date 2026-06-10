package jb.edu.uce.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jb.edu.uce.domain.model.Estudiante;
import jb.edu.uce.domain.repository.EstudianteRepository;
import jb.edu.uce.interceptor.anotacion.AuditoriaAnotacion;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements EstudianteRepository{

    @Inject
    private EntityManager em;

    @AuditoriaAnotacion
    @Override
    public void crear(Estudiante est) {
        em.persist(est);
    }

    @AuditoriaAnotacion
    @Override
    public void actualizar(Estudiante est) {
        em.merge(est);
    }

    @AuditoriaAnotacion
    @Override
    public void eliminar(Estudiante est) {
       em.remove(est);
    }

}
