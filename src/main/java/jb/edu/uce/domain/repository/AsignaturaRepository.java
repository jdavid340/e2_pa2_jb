package jb.edu.uce.domain.repository;

import java.util.List;

import jb.edu.uce.domain.model.Asignatura;

public interface AsignaturaRepository {

    void crear(Asignatura asignatura);
    void eliminar(Asignatura asignatura);
    Asignatura actualizar(Asignatura asignatura);
    List<Asignatura> seleccionarNivel(Integer nivel);
    List<Asignatura> contiene(String palabra);
    Integer contarAsignaturas();   
    

}
