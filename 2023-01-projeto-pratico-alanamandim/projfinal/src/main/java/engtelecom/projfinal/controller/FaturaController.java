package engtelecom.projfinal.controller;

import engtelecom.projfinal.repository.*;
import engtelecom.projfinal.requests.FaturaResquest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class FaturaController {
    @Autowired @NonNull UsuarioRepository usuarioRepository;
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

    @GetMapping("/valorTotalNFaturas")
    public ResponseEntity<List<Object[]>> getConsumoFaturaTotal(@RequestBody FaturaResquest faturaResquest){
        if(consumoRepository.valortotalUsuarioMes(faturaResquest.getQuantidade(),faturaResquest.getIdUsuario()).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consumoRepository.valortotalUsuarioMes(faturaResquest.getQuantidade(), faturaResquest.getIdUsuario()));
    }



}
