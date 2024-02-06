package ec.edu.espe.segundoparcial.examenjimenez.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmpresaDTO {

    private String ruc;
    private String razonSocial;
    private Date fechaCreacion;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ruc == null) ? 0 : ruc.hashCode());
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
        EmpresaDTO other = (EmpresaDTO) obj;
        if (ruc == null) {
            if (other.ruc != null)
                return false;
        } else if (!ruc.equals(other.ruc))
            return false;
        return true;
    }

    



}
