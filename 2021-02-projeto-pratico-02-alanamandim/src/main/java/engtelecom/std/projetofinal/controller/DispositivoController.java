package engtelecom.std.projetofinal.controller;


import engtelecom.std.projetofinal.exceptions.DispositivoNaoEncontradoException;
import engtelecom.std.projetofinal.resources.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {



        BancoDeDados dispositivo = new BancoDeDados();


        @GetMapping //ok
        public ArrayList<Dispositivo> obterTodosDispositivos(){return BancoDeDados.bancodeDados;}

        @GetMapping("/{id}") //ok
        public Dispositivo obterDispositivoPeloId(@PathVariable int id){
                    return dispositivo.buscaPeloId(id);
        }


        @PutMapping("/lampada/{id}") //ok
        public Lampada atualizarDispositivoLampada(@RequestBody Lampada disp, @PathVariable int id) {
            return  dispositivo.verificaLampada(disp,id);
        }
        @PutMapping("/cortina/{id}")//ok
        public Cortina atualizarDispositivoCortina(@RequestBody Cortina disp, @PathVariable int id) {
            return  dispositivo.verificaCortina(disp,id);
        }
    @PutMapping("/televisao/{id}")//ok
    public Televisao atualizarDispositivoTelevisao(@RequestBody Televisao disp, @PathVariable int id) {
        return dispositivo.verificaTelevisao(disp,id);
    }

    @PutMapping("/som/{id}")//ok
    public Som atualizarDispositivoSom(@RequestBody Som disp, @PathVariable int id) {
        return dispositivo.verificaSom(disp,id);
    }

    @PutMapping("/arcondicionado/{id}")//ok
    public ArCondicionado atualizarDispositivoArcondicionado(@RequestBody ArCondicionado disp, @PathVariable int id) {
        return dispositivo.verificaArcondicionado(disp,id);
    }
    @PutMapping("/portao/{id}")//ok
    public Portao atualizarDispositivoPortao(@RequestBody Portao disp, @PathVariable int id) {
        return dispositivo.verificaPortao(disp,id);
    }


            @ControllerAdvice
            class DispositivoNaoEncontrado {
                @ResponseBody
                @ExceptionHandler(DispositivoNaoEncontradoException.class)
                @ResponseStatus(HttpStatus.NOT_FOUND)
                String dispositivoNaoEncontrado(DispositivoNaoEncontradoException p) {
                    return p.getMessage();
                }
            }
        }













