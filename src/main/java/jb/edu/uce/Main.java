package jb.edu.uce;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;
import jb.edu.uce.application.AsignaturaService;
import jb.edu.uce.application.EstudianteService;
import jb.edu.uce.domain.model.Asignatura;

public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication{

        @Inject
        private AsignaturaService as;

        @Inject
        private EstudianteService es;

        @Override
        public int run(String... args) throws Exception {

            //Parte 1
            Asignatura a1=new Asignatura();

            a1.setNivel(1);
            a1.setNombre("Progra Avanzada");
            a1.setNumCreditos(120);
            a1.setFechaCreacion(LocalDate.now());

            as.crear(a1);

           // as.seleccionarPorNivel(1).forEach(System.out::println);
           // as.contienePalabra("Progra").forEach(System.out::println);

            System.out.println("Asignaturas totales: "+as.numeroAsignaturas());

            //Parte 2
          /*   Estudiante e1=new Estudiante();

            e1.setNombre("Juan");
            e1.setApellido("Cruz");
            e1.setCarrera("Computacion");
            System.out.println("Guardando");
            es.crear(e1);*/
           return 0;

           
            
        }


    }
}
