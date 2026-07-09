package jb.edu.uce.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jb.edu.uce.domain.model.Estudiante;
import jb.edu.uce.domain.repository.EstudianteRepository;
import jb.edu.uce.interceptor.anotacion.Auditar;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository er;

    @Auditar
    public void crear(Estudiante estudiante){
        this.er.crear(estudiante);
    }


    public void actualizar(Integer id,Estudiante estudiante){
        this.er.actualizar(id,estudiante);
    }


    public void eliminar(Integer id){
        this.er.eliminar(id);
    }
}
