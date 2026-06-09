package jb.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_estudiante")
    @SequenceGenerator(name="seq_estudiante", allocationSize=1, sequenceName="seq_estudiante")
    private Long id;


    @Column(name="estu_nombre")
    private String nombre;

    @Column(name="estu_apelldio")
    private String apellido;

    @Column(name="estu_carrera")
    private String carrera;

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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante{");
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", carrera=").append(carrera);
        sb.append('}');
        return sb.toString();
    }

    

    
}
