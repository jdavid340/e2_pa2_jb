package jb.edu.uce.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jb.edu.uce.domain.model.Auditoria;
import jb.edu.uce.domain.repository.AuditoriaRepository;


@ApplicationScoped
@Transactional
public class AuditoriaRepositoryImpl implements  AuditoriaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Auditoria auditoria) {
        this.em.persist(auditoria);
    }


}
