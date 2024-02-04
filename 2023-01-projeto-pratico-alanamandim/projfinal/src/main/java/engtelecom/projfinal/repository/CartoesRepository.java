package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Cartoes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cartoes", path = "cartoes")
public interface CartoesRepository extends CrudRepository<Cartoes, Integer> {
}
