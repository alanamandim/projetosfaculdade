package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "produto", path = "produto")
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>, CrudRepository<Produto, Integer> {
    @Query( value = "select produtos_id_produto from modelo_produtos where modelos_id_modelo=?1;", nativeQuery = true)
    List<Produto> porcuraProduto(Integer modelo);

}

