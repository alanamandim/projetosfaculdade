package engtelecom.projfinal.controller;


import engtelecom.projfinal.entities.*;
import engtelecom.projfinal.repository.AlocacaoRepository;
import engtelecom.projfinal.repository.EnderecoRepository;
import engtelecom.projfinal.repository.LocalRepository;
import engtelecom.projfinal.repository.MaquinaRepository;
import engtelecom.projfinal.requests.AlocacaoRequest;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class AlocacaoController {

    @Autowired @NonNull AlocacaoRepository alocacaoRepository;
    @Autowired @NonNull MaquinaRepository maquinaRepository;
    @Autowired @NonNull LocalRepository localRepository;
    @Autowired @NonNull EnderecoRepository enderecoRepository;

    @Transactional
    @PostMapping("/movimentaMaquina")
    public ResponseEntity<Object>mudaMaquina(@RequestBody AlocacaoRequest alocacaoRequest) {
        var maq = maquinaRepository.findById(alocacaoRequest.getIdMaquina());
        var alocacao = alocacaoRepository.findByDataSaiIsNullAndIdMaquina_IdMaquina(alocacaoRequest.getIdMaquina());
        var endereco = enderecoRepository.findById(alocacaoRequest.getIdEndereco());
       //problema aqui
        var local = localRepository.findById(alocacao.get().getIdLocal().getIdLocal());
        var data = new Timestamp(System.currentTimeMillis());

        if (alocacao.isPresent() && endereco.isPresent() && local.isPresent()) {
            alocacao.get().setDataSai(data);
            alocacaoRepository.save(alocacao.get());
            var loc = new Local(new LocalId(alocacaoRequest.getIdLocal(), alocacaoRequest.getIdEndereco()), local.get().getNome(),endereco.get());
            localRepository.save(loc);
            var aloc = new Alocacao(data, loc, maq.get());
            alocacaoRepository.save(aloc);

            return ResponseEntity.status(HttpStatus.OK).body("Maquina realocada");



//
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível movimentar a maquina");

    }

    @GetMapping("/tempodealocacao")
    public ResponseEntity<List<Object[]>> getTempoAlocacaoMaquina(@RequestBody AlocacaoRequest alocacaoRequest) {
       var alocacao = alocacaoRepository.findByDataSaiNotNullAndIdMaquina_IdMaquinaAndIdLocal_Endereco_IdEndereco(alocacaoRequest.getIdMaquina(), alocacaoRequest.getIdEndereco());

        if(alocacao.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(alocacaoRepository.tempoMaquinaAlocacao(alocacaoRequest.getIdMaquina(), alocacaoRequest.getIdEndereco(), alocacaoRequest.getIdLocal()));
    }
}
