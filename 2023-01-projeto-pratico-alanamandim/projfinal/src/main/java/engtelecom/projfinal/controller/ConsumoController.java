package engtelecom.projfinal.controller;

import engtelecom.projfinal.entities.*;
import engtelecom.projfinal.repository.*;

import engtelecom.projfinal.requests.ConsumoRequest;
import engtelecom.projfinal.requests.ContadorRequest;
import engtelecom.projfinal.requests.LimiteRequest;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class ConsumoController {
    @Autowired
    @NonNull UsuarioRepository usuarioRepository;
    @Autowired @NonNull TitularRepository titularRepository;
    @Autowired	@NonNull ProdutoRepository produtoRepository;
    @Autowired @NonNull ModeloRepository modeloRepository;
    @Autowired @NonNull MaquinaRepository maquinaRepository;
    @Autowired @NonNull	LocalRepository localRepository;
    @Autowired @NonNull HistoricoPrecoRepository historicoPrecoRepository;
   // @Autowired @NonNull FaturaRepository faturaRepository;
    @Autowired @NonNull	EnderecoRepository enderecoRepository;
    @Autowired @NonNull	DependenteRepository dependenteRepository;
    @Autowired @NonNull ConsumoRepository consumoRepository;
    @Autowired @NonNull	CartoesRepository cartoesRepository;
    @Autowired @NonNull AlocacaoRepository alocacaoRepository;

    //Total de cafés consumidos em um determinado mês, agrupados por dia; OK
    @GetMapping("/contadorCafeMesAgrupDia")
    public ResponseEntity<List<Object[]>>getContadorMesDia(@RequestBody ContadorRequest contadorRequest){
        if(consumoRepository.contadorConsumoMesAgrupDia(contadorRequest.getIdUsuario(),contadorRequest.getMes()).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consumoRepository.contadorConsumoMesAgrupDia(contadorRequest.getIdUsuario(),contadorRequest.getMes()));

    }
    // Total de cafés consumidos em um determinado mês, agrupados por tipo e por usuário; OK
    @GetMapping("/contadorUsuarioMesAgrupCafe")
    public ResponseEntity<List<Object[]>>getContadorMesCafe(@RequestBody ContadorRequest contadorRequest){
        if(consumoRepository.contadorUsuarioMesAgrupCafe(contadorRequest.getIdUsuario(), contadorRequest.getMes()).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consumoRepository.contadorUsuarioMesAgrupCafe(contadorRequest.getIdUsuario(), contadorRequest.getMes()));
    }

    // Total de cafés consumidos em um determinado mês, agrupados por local de consumo; OK
    @GetMapping("/contadorUsuarioCafeMesAgrupLocal")
    public ResponseEntity<List<Object[]>>getContadorUsuarioCafeAgrupLocal(@RequestBody ContadorRequest contadorRequest){
        if(consumoRepository.contadorUsuarioCafeAgrupLocal(contadorRequest.getIdUsuario(), contadorRequest.getMes()).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consumoRepository.contadorUsuarioCafeAgrupLocal(contadorRequest.getIdUsuario(), contadorRequest.getMes()));
    }
    // Valor total de consumo do usuario OK
    @GetMapping("/valorTotalMes")
    public ResponseEntity<List<Object[]>>getConsumoTotal(@RequestBody ContadorRequest contadorRequest){
        if(consumoRepository.valorTotalUsuarioMes(contadorRequest.getMes(), contadorRequest.getIdUsuario()).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consumoRepository.valorTotalUsuarioMes(contadorRequest.getMes(), contadorRequest.getIdUsuario()));
    }


    //Adiciona consumo  OK
    @PostMapping("/adicionaConsumo")
    public ResponseEntity<Object>setConsumo(@RequestBody ConsumoRequest consumoRequest){
        String idUsuario = consumoRequest.getIdUsuario();
        Integer idProduto = consumoRequest.getIdProduto();
        Integer idMaquina = consumoRequest.getIdMaquina();

        var usuario = usuarioRepository.findById(idUsuario);
        var produto = produtoRepository.findById(idProduto);
        var maquina = maquinaRepository.findById(idMaquina);

        if(usuario.isPresent() & produto.isPresent() & maquina.isPresent()) {
            var data = new Timestamp(System.currentTimeMillis());
            for (var modelo : modeloRepository.findAll()) {
              //  if (modelo.getIdModelo().equals(maquina.get().getModelo())) {
                    //    for(var produtoo : produtoRepository.porcuraProduto(modelo.getIdModelo())){
                    //      if(produtoo.getIdProduto().equals(idProduto)){
                    var consumo = new Consumo(new ConsumoId(idUsuario, data), usuario.get(), maquina.get(), produto.get());
                    consumoRepository.save(consumo);
                    for (var valor : historicoPrecoRepository.ProcuraValor(data, consumoRequest.getIdProduto())) {

                        if(usuario.get() instanceof Dependente){
                        var dep=(Dependente)usuario.get();

                            double teste = dep.getSaldo() - valor;
                            dep.setSaldo(teste);
                            dependenteRepository.save(dep);


                        }


                    }
                    return ResponseEntity.status(HttpStatus.CREATED).body("Consumo cadastrado");
                }
            }





        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Não foi possível cadastrar o consumo");

    }




}
