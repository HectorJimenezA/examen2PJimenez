package ec.edu.espe.segundoparcial.examenjimenez.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "empresas")
public class Empresa {

    @Id
    private String id;

    @Field("rucEnpresa")
    private String ruc;

    @Field("razonSocial")
    private String razonSocial;

    @Field("fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Version
    private Long version;

    public Empresa(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Empresa other = (Empresa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", fechaCreacion="
                + fechaCreacion + ", version=" + version + "]";
    }
}

    

