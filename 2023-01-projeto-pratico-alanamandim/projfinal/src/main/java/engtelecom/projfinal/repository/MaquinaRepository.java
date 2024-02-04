package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Maquina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Objects;

@RepositoryRestResource(collectionResourceRel = "maquina", path = "maquina")
public interface MaquinaRepository extends CrudRepository<Maquina,Integer> {



}
