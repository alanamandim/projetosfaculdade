package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "endereco", path = "endereco")
public interface EnderecoRepository extends CrudRepository<Endereco,Integer> {
}
