package ec.edu.espe.segundoparcial.examenjimenez.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "comentarios")
public class Comentario {

    @Id
    private String codigo;
    
    @Field("calificacion")
    private int calificacion;

    @Field("comentario")
    private String comentario;

    @Field("usuario")
    private String usuario;

    @Field("fechaComentario")
    private Date fechaComentario;

    @Version
    private Long version;

    public Comentario(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comentario other = (Comentario) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Comentario [codigo=" + codigo + ", calificacion=" + calificacion + ", comentario=" + comentario
                + ", usuario=" + usuario + ", fechaComentario=" + fechaComentario + "]";
    }
}
