package ec.edu.espe.segundoparcial.examenjimenez.dto;

import java.util.List;
import java.util.ArrayList;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductoDTO {

    private String codigoProducto;
    private String rucEmpresa;
    private String descripcion;
    private double precio;
    private List<ComentarioDTO> comentarios;

    public void addComentario(ComentarioDTO comentario) {
        if (this.comentarios == null) {
            this.comentarios = new ArrayList<>();
        }
        this.comentarios.add(comentario);
    }

    public void removeComentario(ComentarioDTO comentario) {
        if (this.comentarios != null) {
            this.comentarios.remove(comentario);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoProducto == null) ? 0 : codigoProducto.hashCode());
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
        ProductoDTO other = (ProductoDTO) obj;
        if (codigoProducto == null) {
            if (other.codigoProducto != null)
                return false;
        } else if (!codigoProducto.equals(other.codigoProducto))
            return false;
        return true;
    }

    

}
