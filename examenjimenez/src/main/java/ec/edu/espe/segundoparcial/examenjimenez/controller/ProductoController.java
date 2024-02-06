package ec.edu.espe.segundoparcial.examenjimenez.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.segundoparcial.examenjimenez.domain.Producto;
import ec.edu.espe.segundoparcial.examenjimenez.dto.ProductoDTO;
import ec.edu.espe.segundoparcial.examenjimenez.service.ProductoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<Object> listarProductos() {
        log.info("Obteniendo listado de productos");
        return ResponseEntity.ok(this.productoService.listarProductos());
    }

    @GetMapping("/{codigoProducto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable String codigoProducto) {
        log.info("Obteniendo producto con código: {}", codigoProducto);
        try {
            Producto producto = this.productoService.obtenerProducto(codigoProducto);
            return ResponseEntity.ok(producto);
        } catch(RuntimeException rte) {
            log.error("Error al obtener producto por código", rte);
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/creacionProductos")
    public ResponseEntity<Void> crearProducto(@RequestBody ProductoDTO productoDTO) {
        log.info("Se va a crear el producto: {}", productoDTO);
        try {
            this.productoService.crearProducto(productoDTO);
            return ResponseEntity.noContent().build();
        } catch(RuntimeException rte) {
            log.error("Error al crear el producto", rte);
            return ResponseEntity.badRequest().build();
        }
    }
}
