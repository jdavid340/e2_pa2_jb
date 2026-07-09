package jb.edu.uce.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jb.edu.uce.domain.model.Estudiante;
import jb.edu.uce.domain.repository.EstudianteRepository;
import jb.edu.uce.interceptor.anotacion.Archivo;
import jb.edu.uce.interceptor.anotacion.Auditar;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements EstudianteRepository {

    @Inject
    private EntityManager em;

    @Auditar
    @Archivo
    @Override
    public void crear(Estudiante est) {
        em.persist(est);
    }

    @Auditar
    @Archivo
    @Override
    public void actualizar(Integer id, Estudiante est) {
        Estudiante existente = buscarPorId(id);

        if (existente != null) {
            if (est.getNombre() != null) {
                existente.setNombre(est.getNombre());
            }

            if (est.getApellido() != null) {
                existente.setApellido(est.getApellido());
            }

            if (est.getCarrera() != null) {
                existente.setCarrera(est.getCarrera());
            }

            em.merge(existente);
        }
    }

    @Auditar
    @Archivo
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
