package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Modelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "modelo", path = "modelo")
public interface ModeloRepository extends CrudRepository<Modelo,Integer> {


}
