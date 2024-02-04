package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Local;
import engtelecom.projfinal.entities.LocalId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "local", path = "local")
public interface LocalRepository extends CrudRepository<Local, LocalId> {
   // Optional<Local> findByIdLocal(Local idLocal);



}
