package jb.edu.uce.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jb.edu.uce.domain.model.Auditoria;
import jb.edu.uce.infrastructure.AuditoriaRepositoryImpl;

@ApplicationScoped

public class AuditoriaService {

     @Inject
    private AuditoriaRepositoryImpl au;

    public void crear(  Auditoria auditoria){
        this.au.crear(auditoria);
    }
}
