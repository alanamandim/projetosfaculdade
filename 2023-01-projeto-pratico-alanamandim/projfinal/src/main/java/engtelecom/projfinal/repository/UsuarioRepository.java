package engtelecom.projfinal.repository;


import engtelecom.projfinal.entities.Consumo;
import engtelecom.projfinal.entities.Dependente;
import engtelecom.projfinal.entities.HistoricoPreco;
import engtelecom.projfinal.entities.Usuario;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuario")
public interface UsuarioRepository extends CrudRepository<Usuario,String> {
  //  @Query(value = "SELECT * from usuario join consumo c on usuario.cpf = c.id_usuario join historico_preco hp on c.id_produto = hp.id_produto where cpf = ?1", nativeQuery = true)
  //  List<Usuario>ConsumoPorUsuario(String cpf);
    List<Usuario>findUsuarioByCpf(String id);

    @Query( value = "select 'Usuario' as usuer, usuario.nome, 'Maquina' as maq, m.nome, 'Local' as loc, e.nome,'Tipo de Café' as cafe, p.nome, 'Valor' as val, hp.valor,'Data de consumo' as data_cons, c.data_act from usuario join consumo c on usuario.cpf = c.id_usuario join produto p on p.id_produto = c.id_produto join maquina m on m.id_maquina = c.id_maquina join alocacao a on m.id_maquina = a.id_maquina_id_maquina join historico_preco hp on p.id_produto = hp.id_produto join local l on a.id_local_id_endereco = l.id_endereco and a.id_local_local = l.local join endereco e on e.id_endereco = l.id_endereco where id_usuario=?1 and c.data_act >= a.data_entrada and hp.data_act=(select max(hp2.data_act) from historico_preco hp2 join consumo c2 on hp2.id_produto = c2.id_produto where c2.data_act >= hp2.data_act);",nativeQuery = true)
    List<Object[]>findHistoricoConsumo(String id);









}
