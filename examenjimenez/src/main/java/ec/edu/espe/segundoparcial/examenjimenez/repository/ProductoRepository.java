package ec.edu.espe.segundoparcial.examenjimenez.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import ec.edu.espe.segundoparcial.examenjimenez.domain.Producto;
import ec.edu.espe.segundoparcial.examenjimenez.dto.ProductoDTO;

public interface ProductoRepository extends MongoRepository<Producto, String> {


    List<Producto> findByRucEmpresaOrderByDescripcion(String rucEmpresa);
    Producto findByCodigoProducto(String codigoProducto);
    Producto save(ProductoDTO productoDTO);
}
