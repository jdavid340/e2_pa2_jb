package jb.edu.uce.interceptor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jb.edu.uce.interceptor.anotacion.Archivo;

@Interceptor
@Archivo
public class ArchivoInterceptor {

    private static final Path ARCHIVO = Path.of("auditoria.log");
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @AroundInvoke
    public Object auditar(InvocationContext ctx) throws Exception {

        String registro = String.format(
                "[%s] Método: %s%n",
                LocalDateTime.now().format(FORMATO),
                ctx.getMethod().getName()
        );

        Files.writeString(
                ARCHIVO,
                registro,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );

        return ctx.proceed();
    }
}