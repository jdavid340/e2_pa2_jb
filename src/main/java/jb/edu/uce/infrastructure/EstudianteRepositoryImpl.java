package jb.edu.uce.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jb.edu.uce.domain.model.Estudiante;
import jb.edu.uce.domain.repository.EstudianteRepository;
import jb.edu.uce.interceptor.anotacion.AuditoriaActualizar;
import jb.edu.uce.interceptor.anotacion.AuditoriaAnotacion;
import jb.edu.uce.interceptor.anotacion.AuditoriaEliminar;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements EstudianteRepository {

    @Inject
    private EntityManager em;

    @AuditoriaAnotacion
    @Override
    public void crear(Estudiante est) {
        em.persist(est);
    }

    @AuditoriaActualizar
    @Override
    public void actualizar(Integer id,Estudiante est) {
        Estudiante existente = buscarPorId(id);

        if (existente != null) {
            existente.setNombre(est.getNombre());
            existente.setCarrera(est.getCarrera());
            existente.setApellido(est.getApellido());
        }
        em.merge(est);
    }

    @AuditoriaEliminar
    @Override
    public void eliminar(Integer id) {
        Estudiante e = buscarPorId(id);

        if (e != null) {
            em.remove(e);
        }
    }

    @Override
    public Estudiante buscarPorId(Integer id) {
        return em.find(Estudiante.class, id);
    }

}
