package jb.edu.uce.domain.repository;

import jb.edu.uce.domain.model.Estudiante;

public interface  EstudianteRepository {

    void crear(Estudiante est);

    void actualizar(Integer id,Estudiante est);

    void eliminar(Integer id);

    Estudiante buscarPorId(Integer id);
}
