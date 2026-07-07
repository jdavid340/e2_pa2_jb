package jb.edu.uce.interceptor;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jb.edu.uce.domain.model.Auditoria;
import jb.edu.uce.domain.repository.AuditoriaRepository;
import jb.edu.uce.interceptor.anotacion.AuditoriaAnotacion;

@Interceptor
@AuditoriaAnotacion

public class AuditoriaInterceptor {

    @Inject
    private AuditoriaRepository ar;

    @AroundInvoke
    public Object auditar(InvocationContext ctx) throws Exception {
        System.out.println("Iniciando Auditoria");
        String nombre = ctx.getMethod().getName();
        Object[] parametros = ctx.getParameters();

        Auditoria a1 = new Auditoria();
        a1.setArgumentos(Arrays.toString(parametros));
        a1.setNombreMetodo(nombre);
        a1.setFechaHoraEjecucion(LocalDateTime.now());

        Long tiempoInicio = System.currentTimeMillis();
        Object context = ctx.proceed();
        Long tiempoFin = System.currentTimeMillis();

        Long tiempoFinal = tiempoFin - tiempoInicio;
        a1.setTiempoEjecucion(tiempoFinal);

        ar.crear(a1);
        System.out.println("Fin auditoria");
        return context;
    }
}
