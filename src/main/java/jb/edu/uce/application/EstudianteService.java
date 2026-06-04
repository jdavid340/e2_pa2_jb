package jb.edu.uce.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jb.edu.uce.domain.model.Estudiante;
import jb.edu.uce.domain.repository.EstudianteRepository;
import jb.edu.uce.interceptor.anotacion.AuditoriaAnotacion;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository er;

    @AuditoriaAnotacion
    public void crear(Estudiante estudiante){
        this.er.crear(estudiante);
    }


    public void actualizar(Estudiante estudiante){
        this.er.actualizar(estudiante);
    }


    public void eliminar(Estudiante estudiante){
        this.er.eliminar(estudiante);
    }
}
