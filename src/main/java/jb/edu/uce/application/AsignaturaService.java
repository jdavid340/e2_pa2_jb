package jb.edu.uce.application;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jb.edu.uce.domain.model.Asignatura;
import jb.edu.uce.infrastructure.AsignaturaRepositoryImpl;

@ApplicationScoped
public class AsignaturaService {

    @Inject
    private AsignaturaRepositoryImpl as;

    
    public void crear(Asignatura asignatura){
        this.as.crear(asignatura);
    }

    public void eliminar(Asignatura asignatura){
        this.as.eliminar(asignatura);
    }

    public void actualizar(Asignatura asignatura){
        this.as.actualizar(asignatura);
    }

    public List<Asignatura> seleccionarPorNivel(Integer nivel){
        return this.as.seleccionarNivel(nivel);
    }


    public List<Asignatura> contienePalabra(String palabra){
        return this.as.contiene(palabra);
    }

    public Integer numeroAsignaturas(){
        return this.as.contarAsignaturas();
    }

}
