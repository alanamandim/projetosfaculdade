package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Alocacao;
import engtelecom.projfinal.entities.HistoricoPreco;
import engtelecom.projfinal.entities.HistoricoPrecoId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Timestamp;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "historicopreco", path = "historicopreco")
public interface HistoricoPrecoRepository extends CrudRepository<HistoricoPreco, HistoricoPrecoId> {
@Query (value = "select valor from historico_preco  join produto p on p.id_produto = historico_preco.id_produto join consumo c on p.id_produto = c.id_produto where ?1 >=historico_preco.data_act and c.id_produto=?2 order by  historico_preco.data_act desc limit 1", nativeQuery = true )
    List<Double>ProcuraValor(Timestamp data, Integer idProduto);

    //List<Alocacao>findAlocacaosByDataEntradaBeforeAndDataSaiAfter(Timestamp dataEntrada, Timestamp dataSai);
}
