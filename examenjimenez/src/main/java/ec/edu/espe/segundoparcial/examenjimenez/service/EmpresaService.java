package ec.edu.espe.segundoparcial.examenjimenez.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.segundoparcial.examenjimenez.domain.Empresa;
import ec.edu.espe.segundoparcial.examenjimenez.dto.EmpresaDTO;
import ec.edu.espe.segundoparcial.examenjimenez.repository.EmpresaRepository;


@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public Empresa obtenerEmpresaPorRuc(String ruc) {
        return empresaRepository.findByRuc(ruc);
    }
    
    public Empresa crearEmpresa(EmpresaDTO empresaDTO) {
        return empresaRepository.save(empresaDTO);
    }

    public Object listarEmpresas() {
        return empresaRepository.findAll();
    }
}
