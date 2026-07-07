package jb.edu.uce;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;
import jb.edu.uce.application.EstudianteService;
import jb.edu.uce.domain.model.Estudiante;

public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {


        @Inject
        private EstudianteService es;

        @Override
        public int run(String... args) throws Exception {
            
             Estudiante e1=new Estudiante();
             
             e1.setNombre("Juan");
             e1.setApellido("Cruz");
             e1.setCarrera("Sistemas");
             System.out.println("Guardando");
            
             es.actualizar(1, e1);

             
            return 0;

        }

    }
}
