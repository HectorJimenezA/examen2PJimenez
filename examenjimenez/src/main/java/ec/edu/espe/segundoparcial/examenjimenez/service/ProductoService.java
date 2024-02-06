package ec.edu.espe.segundoparcial.examenjimenez.service;

import java.util.List;

import ec.edu.espe.segundoparcial.examenjimenez.domain.Comentario;
import ec.edu.espe.segundoparcial.examenjimenez.domain.Producto;
import ec.edu.espe.segundoparcial.examenjimenez.dto.ProductoDTO;
import ec.edu.espe.segundoparcial.examenjimenez.repository.ProductoRepository;

public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProductosPorRuc(String rucEmpresa) {
        return productoRepository.findByRucEmpresaOrderByDescripcion(rucEmpresa);
    }

    public Producto obtenerProducto(String codigoProducto) {
        return productoRepository.findByCodigoProducto(codigoProducto);
    }

    public Producto crearProducto(ProductoDTO productoDTO) {
        return productoRepository.save(productoDTO);
    }

    public void agregarComentario(String codigoProducto, Comentario comentario) {
        Producto producto = productoRepository.findByCodigoProducto(codigoProducto);
        producto.getComentarios().add(comentario);
        productoRepository.save(producto);
    }

    public Object listarProductos() {
        return productoRepository.findAll();
    }

}
