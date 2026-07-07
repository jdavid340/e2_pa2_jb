package jb.edu.uce.interceptor;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jb.edu.uce.domain.model.Auditoria;
import jb.edu.uce.domain.repository.AuditoriaRepository;
import jb.edu.uce.interceptor.anotacion.AuditoriaEliminar;

@Interceptor
@AuditoriaEliminar
public class AuditoriaEliminarInterceptor {

    @Inject
    private AuditoriaRepository ar;

    @AroundInvoke
    public Object auditar(InvocationContext ctx) throws Exception {

        Auditoria a = new Auditoria();

        a.setNombreMetodo(ctx.getMethod().getName());
        a.setArgumentos(Arrays.toString(ctx.getParameters()));
        a.setFechaHoraEjecucion(LocalDateTime.now());

        long inicio = System.currentTimeMillis();

        Object resultado = ctx.proceed();

        long fin = System.currentTimeMillis();

        a.setTiempoEjecucion(fin - inicio);

        ar.crear(a);

        return resultado;
    }
}
