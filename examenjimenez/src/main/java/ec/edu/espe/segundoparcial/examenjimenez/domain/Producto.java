package ec.edu.espe.segundoparcial.examenjimenez.domain;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "productos")
public class Producto {

    @Id
    private String codigoUnico;

    @Field("rucEnpresa")
    private String rucEmpresa;

    @Field("descripcion")
    private String descripcion;

    @Field("precio")
    private double precio;

    @Field("comantarios")
    private List<Comentario> comentarios;

    @Version
    private Long version;




    

}
