package jb.edu.uce.domain.repository;

import jb.edu.uce.domain.model.Estudiante;

public interface  EstudianteRepository {

    void crear(Estudiante est);

    void actualizar(Estudiante est);

    void eliminar(Estudiante est);
}
