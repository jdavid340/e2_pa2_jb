package jb.edu.uce.interceptor;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jb.edu.uce.application.AuditoriaService;
import jb.edu.uce.domain.model.Auditoria;
import jb.edu.uce.interceptor.anotacion.Auditar;

@Interceptor
@Auditar
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService as;

    @AroundInvoke
    public Object auditar(InvocationContext ctx) throws Exception {
        System.out.println("Iniciando Auditoria");
        String nombre = ctx.getMethod().getName();

        Long tiempoInicio = System.currentTimeMillis();
        Object context = ctx.proceed();
        Object[] parametros = ctx.getParameters();
        Long tiempoFin = System.currentTimeMillis();

        Auditoria a1 = new Auditoria();
        a1.setArgumentos(Arrays.toString(parametros));
        a1.setNombreMetodo(nombre);
        a1.setFechaHoraEjecucion(LocalDateTime.now());

        Long tiempoFinal = tiempoFin - tiempoInicio;
        a1.setTiempoEjecucion(tiempoFinal);

        as.crear(a1);
        System.out.println("Fin auditoria");
        return context;
    }
}
