package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.Alocacao;
import engtelecom.projfinal.entities.AlocacaoId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "alocacao", path = "alocacao")
public interface AlocacaoRepository extends CrudRepository<Alocacao, AlocacaoId> {
    List<Alocacao>findAlocacaoByDataSaiIsNullAndDataEntradaBefore(Timestamp data);

    Optional<Alocacao> findByDataSaiIsNullAndIdMaquina_IdMaquina(Integer idMaquina);

    List<Alocacao>findAlocacaoByDataSaiNotNull();


    List<Alocacao>findAlocacaosByDataEntradaBeforeAndDataSaiAfter(Timestamp dataEntrada, Timestamp dataSai);
    List<Alocacao>findByDataSaiNotNullAndIdMaquina_IdMaquinaAndIdLocal_Endereco_IdEndereco(Integer idMaquina, Integer idEndereco);

    @Query(value = "select 'idMAquina' as maq, id_maquina_id_maquina 'Dias alocados' as dias, DATEDIFF(data_sai, data_entrada) from alocacao where  id_maquina_id_maquina=?1 and id_local_local=?2 and id_local_id_endereco=?3;", nativeQuery = true)
    List<Object[]> calculatempoalocacao(Integer idMaquina, Integer idLocal, Integer idEndereco);

    @Query (value = "select DATEDIFF(data_sai, data_entrada) from alocacao where  id_maquina_id_maquina=?1;",nativeQuery = true)
    List<Object[]>teste(Integer idMaquina);

    @Query(value = "select m.nome as nome_maquina, 'Dias alocada:' as aloc, DATEDIFF(a.data_sai, a.data_entrada) as tempo_alocacao from alocacao a join maquina m on a.id_maquina_id_maquina = m.id_maquina join local l on l.id_endereco = a.id_local_id_endereco and l.local = a.id_local_local where m.id_maquina =1  and l.id_endereco=1 and l.local=1;", nativeQuery = true)
    List<Object[]> tempoMaquinaAlocacao(Integer maquina, Integer endereco, Integer local);


}
