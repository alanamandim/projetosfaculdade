package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Titular;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "titular", path = "titular")
public interface TitularRepository extends CrudRepository<Titular, String> {

    @Transactional
    @Modifying
    @Query(value = "update dependente set limite_mensal=?1 where cpf=?2 and titular_cpf=?3;", nativeQuery = true)
    Optional<Object> modificaLimite(Double limite, String idDependente, String idUsuario);



}
