package jb.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_asignatura")
    @SequenceGenerator(name="seq_asignatura", allocationSize=1, sequenceName="seq_asignatura")
    private Long id;

    @Column(name="asig_nombre")
    private String nombre;

    @Column(name="asig_nivel")
    private Integer nivel;

    @Column(name="asig_num_creditos")
    private Integer numCreditos;

    @Column(name="asig_fecha_creacion")
    private LocalDate fechaCreacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public Integer getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(Integer numCreditos) {
        this.numCreditos = numCreditos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asignatura{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", nivel=").append(nivel);
        sb.append(", numCreditos=").append(numCreditos);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append('}');
        return sb.toString();
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    

}
