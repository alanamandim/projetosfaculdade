package engtelecom.projfinal.controller;

import engtelecom.projfinal.entities.*;


import engtelecom.projfinal.repository.CartoesRepository;
import engtelecom.projfinal.repository.DependenteRepository;
import engtelecom.projfinal.repository.TitularRepository;
import engtelecom.projfinal.repository.UsuarioRepository;

import engtelecom.projfinal.requests.LimiteRequest;
import engtelecom.projfinal.requests.DependenteRequest;
import engtelecom.projfinal.requests.UsuarioRequest;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UsuarioController {
    @Autowired
    @NonNull UsuarioRepository usuarioRepository;
    @Autowired
    @NonNull TitularRepository titularRepository;
    //@Autowired @NonNull FaturaRepository faturaRepository;
    @Autowired
    @NonNull DependenteRepository dependenteRepository;
    @Autowired
    @NonNull CartoesRepository cartoesRepository;

    // Lista todoo o historico de consumo do usuario
    @GetMapping("/historicoConsumo")
    public ResponseEntity<List<Object[]>> getHistoricoConsumo(@Param(value = "usuario") String usuario) {
        if (usuarioRepository.findHistoricoConsumo(usuario).isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(usuarioRepository.findHistoricoConsumo(usuario));
        }
    }

    @Transactional
    @PutMapping("/modificaLimite") //modifica limite do dependente OK
    public ResponseEntity<Object> alteraLimite(@RequestBody LimiteRequest limiteRequest) {
        var titular = titularRepository.findById(limiteRequest.getIdTitular());
        var dependente = dependenteRepository.findById(limiteRequest.getIdDependente());
        if (titular.isPresent() && dependente.isPresent()) {
            var t = titular.get();
            var d = dependente.get();

            if(d.getTitular().getCpf().equals(t.getCpf())) {

                d.setLimiteMensal(limiteRequest.getLimite());
            }

          // titularRepository.modificaLimite(limiteRequest.getLimite(), limiteRequest.getIdDependente(), limiteRequest.getIdTitular());
            return ResponseEntity.status(HttpStatus.OK).body("Limite alterado para : " + limiteRequest.getLimite());
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Não foi possível alterar o limite");
    }

    @PostMapping("/adicionaUsuario")
    public ResponseEntity<Object> criaUsuario(@RequestBody UsuarioRequest usuarioRequest) {
       // var usuario = new Usuario(usuarioRequest.getIdUsuario(), usuarioRequest.getNome(), usuarioRequest.getSenha(), usuarioRequest.getEmail(), usuarioRequest.getTelefone());
        var titular = new Titular(usuarioRequest.getIdUsuario(),usuarioRequest.getNome(), usuarioRequest.getSenha(), usuarioRequest.getEmail(), usuarioRequest.getTelefone());
        titular.setDiaPagamento(usuarioRequest.getDatapagamento());
        titularRepository.save(titular);
        var cartao = new Cartoes( );
        cartao.setNome(usuarioRequest.getNomeCar());
        cartao.setCodSeg(usuarioRequest.getCodSeg());
        cartao.setNumero(usuarioRequest.getNumCartao());
        cartao.setValidade(usuarioRequest.getValidade());
        cartao.setTitular(titular);
        cartoesRepository.save(cartao);
        titular.setCartaoPref(cartao);
        titularRepository.save(titular);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario adicionado com sucesso");
    }

    @PostMapping("/adicionaDependente")
    public ResponseEntity<Object> criaUsuario(@RequestBody DependenteRequest dependenteRequest) {
        var titular = titularRepository.findById(dependenteRequest.getIdTitular());
        if (titular.isPresent()) {
           var dependete = new Dependente(dependenteRequest.getIdUsuario(), dependenteRequest.getNome(), dependenteRequest.getSenha(), dependenteRequest.getEmail(), dependenteRequest.getTelefone());
           dependete.setTitular(titular.get());
           dependete.setSaldo(dependenteRequest.getSaldo());
           dependenteRequest.setLimite(dependenteRequest.getLimite());
           dependenteRepository.save(dependete);
            return ResponseEntity.status(HttpStatus.CREATED).body("Dependente adicionado com sucesso");




        }
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Não foi possível cadastrar o dependete");

    }

    @Transactional
    @PutMapping("/aumentaSaldo") //modifica limite do dependente OK
    public ResponseEntity<Object> alterasaldo(@RequestBody LimiteRequest limiteRequest) {
        var titular = titularRepository.findById(limiteRequest.getIdTitular());
        var dependente = dependenteRepository.findById(limiteRequest.getIdDependente());
        if (titular.isPresent() && dependente.isPresent()) {
            var t = titular.get();
            var d = dependente.get();

            if(d.getTitular().getCpf().equals(t.getCpf())) {

                d.setSaldo(limiteRequest.getLimite());
            }

            // titularRepository.modificaLimite(limiteRequest.getLimite(), limiteRequest.getIdDependente(), limiteRequest.getIdTitular());
            return ResponseEntity.status(HttpStatus.OK).body("Limite alterado para : " + limiteRequest.getLimite());
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Não foi possível alterar o limite");
    }
}







