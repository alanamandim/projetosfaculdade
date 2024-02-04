package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.sql.Timestamp;
import java.util.List;


@RepositoryRestResource(collectionResourceRel = "consumo", path = "consumo")
public interface ConsumoRepository extends CrudRepository<Consumo, ConsumoId> {

    //List<Consumo>findConsumoByIdConsumoDataActMonth(int month);
    //List<Consumo>findConsumoByIdUsuario(Usuario usuario);

    //int countByIdConsumo_IdUsuario(String id);

    @Query ( value = "SELECT 'Dia: ' as qualquercoisa, day(data_act), 'Total caafe:' as total, count(*) from consumo where id_usuario=?1 and month(data_act)=?2 group by day(data_act);", nativeQuery = true)
    List<Object[]>contadorConsumoMesAgrupDia(String id, int mes);

    @Query (value = "SELECT p.nome as tipoCafe, u.nome as usuario, count(*) as total from consumo join produto p on p.id_produto = consumo.id_produto join usuario u on u.cpf = consumo.id_usuario where id_usuario=?1 and month(data_act)=?2 group by p.nome, u.nome;", nativeQuery = true)
    List<Object[]>contadorUsuarioMesAgrupCafe(String cpf, int mes);

    @Query ( value = "select   e.nome as localizacao, count(*) as totaldecafe from consumo join maquina m on m.id_maquina = consumo.id_maquina\n" +
            "    join alocacao a on m.id_maquina = a.id_maquina_id_maquina join produto p on p.id_produto = consumo.id_produto\n" +
            "    join local l on a.id_local_id_endereco = l.id_endereco and a.id_local_local = l.local join endereco e on e.id_endereco = l.id_endereco\n" +
            "    where id_usuario=?1 and month(data_act)=?2 group by  e.nome;", nativeQuery = true)
    List<Object[]>contadorUsuarioCafeAgrupLocal(String id, int mes);

    // Valor total mes por usuario
    @Query (value = "select  'Valor' as val,sum(hp.valor) from usuario join consumo c on usuario.cpf = c.id_usuario join produto p on p.id_produto = c.id_produto join maquina m on m.id_maquina = c.id_maquina join alocacao a on m.id_maquina = a.id_maquina_id_maquina join historico_preco hp on p.id_produto = hp.id_produto join local l on a.id_local_id_endereco = l.id_endereco and a.id_local_local = l.local join endereco e on e.id_endereco = l.id_endereco where month(c.data_act)=?1 and id_usuario=?2 and c.data_act >= a.data_entrada and hp.data_act=(select max(hp2.data_act) from historico_preco hp2 join consumo c2 on hp2.id_produto = c2.id_produto where c2.data_act >= hp2.data_act);", nativeQuery = true)
    List<Object[]>valorTotalUsuarioMes(Integer mes, String idUsuario);

    @Query(value = "select  'Valor' as val,sum(hp.valor) from usuario join consumo c on usuario.cpf = c.id_usuario join produto p on p.id_produto = c.id_produto\n" +
                "                join historico_preco hp on p.id_produto = hp.id_produto\n" +
                "                where month(c.data_act)<=month(current_date) and month(c.data_act)>=(month(current_date)-2) and id_usuario='106.035.852-83'\n" +
                "                and hp.data_act=(select max(hp2.data_act) from historico_preco hp2 join consumo c2 on hp2.id_produto = c2.id_produto\n" +
                "                where c2.data_act >= hp2.data_act);",nativeQuery = true)
            //@Query(value = "select count(*) from consumo;", nativeQuery = true)
    List<Object[]> valortotalUsuarioMes(Integer quantidade, String idUsuario);










}

