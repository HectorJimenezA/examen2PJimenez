package ec.edu.espe.segundoparcial.examenjimenez.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.segundoparcial.examenjimenez.domain.Empresa;
import ec.edu.espe.segundoparcial.examenjimenez.dto.EmpresaDTO;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {

    Empresa findByRuc(String ruc);

    Empresa save(EmpresaDTO empresaDTO);

}
