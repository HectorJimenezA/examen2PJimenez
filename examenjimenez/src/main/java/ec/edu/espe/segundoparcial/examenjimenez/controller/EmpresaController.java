package ec.edu.espe.segundoparcial.examenjimenez.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.segundoparcial.examenjimenez.domain.Empresa;
import ec.edu.espe.segundoparcial.examenjimenez.dto.EmpresaDTO;
import ec.edu.espe.segundoparcial.examenjimenez.service.EmpresaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<Object> listarEmpresas() {
        log.info("Obteniendo listado de empresas");
        return ResponseEntity.ok(this.empresaService.listarEmpresas());
    }

    @GetMapping("/{ruc}")
    public ResponseEntity<Empresa> obtenerEmpresa(@PathVariable String ruc) {
        log.info("Obteniendo empresa con RUC: {}", ruc);
        try {
            Empresa empresa = this.empresaService.obtenerEmpresaPorRuc(ruc);
            return ResponseEntity.ok(empresa);
        } catch(RuntimeException rte) {
            log.error("Error al obtener empresa por RUC", rte);
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/creacionEmpresa ")
    public ResponseEntity<Void> crearEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        log.info("Se va a crear la empresa: {}", empresaDTO);
        try {
            this.empresaService.crearEmpresa(empresaDTO);
            return ResponseEntity.noContent().build();
        } catch(RuntimeException rte) {
            log.error("Error al crear la empresa", rte);
            return ResponseEntity.badRequest().build();
        }
    }
}