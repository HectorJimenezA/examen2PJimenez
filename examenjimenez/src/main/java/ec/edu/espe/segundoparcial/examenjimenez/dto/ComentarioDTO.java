package ec.edu.espe.segundoparcial.examenjimenez.dto;


import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ComentarioDTO {

    private int calificacion;
    private String comentario;
    private String usuario;
    private Date fechaComentario;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + calificacion;
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
        ComentarioDTO other = (ComentarioDTO) obj;
        if (calificacion != other.calificacion)
            return false;
        return true;
    }

    

}
