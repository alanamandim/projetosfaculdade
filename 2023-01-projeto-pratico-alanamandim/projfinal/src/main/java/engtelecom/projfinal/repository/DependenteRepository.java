package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Dependente;

import engtelecom.projfinal.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "dependente", path = "dependente")
public interface DependenteRepository extends CrudRepository<Dependente, String>{
    //List<Dependente> findDependenteByIdDependente(String id);
    //List<Dependente>findByIddependente_Cpf(String id);

    @Transactional
    @Modifying
    @Query(value = "update dependente set saldo=?1 where cpf=?2;", nativeQuery = true)
    Optional<Object> modificaLimite(Double limite, String idDependente);




}