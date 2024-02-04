package engtelecom.projfinal.repository;

import engtelecom.projfinal.entities.*;
import engtelecom.projfinal.repository.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RequiredArgsConstructor
public class AplicacaoRunner implements CommandLineRunner {
    @Autowired
    @NonNull  UsuarioRepository usuarioRepository;
    @Autowired @NonNull TitularRepository titularRepository;
    @Autowired	@NonNull ProdutoRepository produtoRepository;
    @Autowired @NonNull	ModeloRepository modeloRepository;
    @Autowired @NonNull	MaquinaRepository maquinaRepository;
    @Autowired @NonNull	LocalRepository localRepository;
    @Autowired @NonNull HistoricoPrecoRepository historicoPrecoRepository;
   // @Autowired @NonNull FaturaRepository faturaRepository;
    @Autowired @NonNull	EnderecoRepository enderecoRepository;
    @Autowired @NonNull	DependenteRepository dependenteRepository;
    @Autowired @NonNull ConsumoRepository consumoRepository;
    @Autowired @NonNull	CartoesRepository cartoesRepository;
    @Autowired @NonNull AlocacaoRepository alocacaoRepository;



    private void listarDados(){

       usuarioRepository.findAll().forEach(System.out::println);
        titularRepository.findAll().forEach(System.out::println);
        produtoRepository.findAll().forEach(System.out::println);
        modeloRepository.findAll().forEach(System.out::println);
        maquinaRepository.findAll().forEach(System.out::println);
        localRepository.findAll().forEach(System.out::println);
        historicoPrecoRepository.findAll().forEach(System.out::println);
        enderecoRepository.findAll().forEach(System.out::println);
        dependenteRepository.findAll().forEach(System.out::println);
        consumoRepository.findAll().forEach(System.out::println);
        cartoesRepository.findAll().forEach(System.out::println);
        alocacaoRepository.findAll().forEach(System.out::println);
    }



    @Override
    public void run(String... args) throws Exception {
        try {
        //    listarDados();
        //    System.out.println(dependenteRepository.findById("106.123.456-78"));


        } catch (Exception e) {
            log.error(e.toString());
        }

    }
}
