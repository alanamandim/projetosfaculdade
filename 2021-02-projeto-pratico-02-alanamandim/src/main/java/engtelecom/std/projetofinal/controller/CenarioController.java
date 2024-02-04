package engtelecom.std.projetofinal.controller;



import engtelecom.std.projetofinal.exceptions.AmbienteNaoEncontradoException;
import engtelecom.std.projetofinal.exceptions.CenarioNaoEncontradoException;
import engtelecom.std.projetofinal.resources.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cenario") //ok
public class CenarioController {

    private final List<Cenario> cenarios = new ArrayList<>();

    @GetMapping
    public List<Cenario>listar_cenarios(){return this.cenarios;}

    @GetMapping("/{nome_cenario}") //ok
    public Cenario obterCenario(@PathVariable String nome_cenario){
        for(Cenario a: this.cenarios){
            if(a.getNome().equals(nome_cenario)){
                return a;
            }
        }
        throw new CenarioNaoEncontradoException(nome_cenario);
    }
    @GetMapping("/{nome_cenario}/dispositivos") //ok
    public ArrayList<Dispositivo> obterTodosDispositivos(@PathVariable String nome_cenario){
        for(Cenario a: this.cenarios){
            if(a.getNome().equals(nome_cenario)){
                return a.getDispositivos();
            }

        }throw new CenarioNaoEncontradoException(nome_cenario);
    }

    @GetMapping("/{nome_cenario}/dispositivos/") //ok
    public Dispositivo buscaDispositivo (@PathVariable String nome_cenario, @RequestParam (value = "id",defaultValue = "0")int id){
        for(Cenario a :this.cenarios){
            if(a.getNome().equals(nome_cenario)){
                return a.buscaDispositivoPeloId(id);
            }
        }throw new CenarioNaoEncontradoException(nome_cenario);
    }


    @PostMapping({"{nome_cenario}/{inicio}/{fim}"}) //ok
    @ResponseStatus(HttpStatus.CREATED)
    public Cenario adicionaCenario(@PathVariable String nome_cenario, @PathVariable int inicio, @PathVariable int fim){
        Cenario x = new Cenario(nome_cenario,inicio,fim);
        this.cenarios.add(x);
        return x;
    }


    @PostMapping("{nome_cenario}/dispositivos") //ok
    @ResponseStatus(HttpStatus.CREATED)
    public Cenario adiconaEquipamento(@PathVariable String nome_cenario, @RequestParam (value = "id",defaultValue = "0")int id){
        for(Cenario a: this.cenarios){
            if(a.getNome().equals(nome_cenario)){
                a.adicionaDispositivo(id);
                return a;

            }
        }throw new CenarioNaoEncontradoException(nome_cenario);
    }

    @PutMapping("/{nome_cenario}") //ok
    public Cenario atualizarCenario(@PathVariable String nome_cenario,@RequestParam(value = "nome")String nome, @RequestParam(value = "inicio")int inicio, @RequestParam(value ="fim" )int fim){

        for (Cenario a: this.cenarios){
            if (a.getNome().equals(nome_cenario)){
                a.setNome(nome);
                a.setInicio(inicio);
                a.setFim(fim);
                return a;
            }
        }
        throw new CenarioNaoEncontradoException(nome_cenario);
    }


    @PutMapping("/{nome_cenario}/dispositivos/lampada")//ok
    public Cenario atualizaDispositivoLampada (@PathVariable String nome_cenario, @RequestParam (value = "id",defaultValue = "0")int id, @RequestBody Lampada disp){
        for(Cenario a: this.cenarios){
            if(Objects.equals(a.getNome(), nome_cenario)){
                a.setDispositivoLampada(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_cenario);
    }
    @PutMapping("/{nome_cenario}/dispositivos/cortina")//ok
    public Cenario atualizaDispositivoCortina (@PathVariable String nome_cenario,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Cortina disp){
        for(Cenario a: this.cenarios){
            if(Objects.equals(a.getNome(), nome_cenario)){
                a.setDispositivoCortina(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_cenario);
    }
    @PutMapping("/{nome_cenario}/dispositivos/televisao")//ok
    public Cenario atualizaDispositivoTelevisao (@PathVariable String nome_cenario,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Televisao disp){
        for(Cenario a: this.cenarios){
            if(Objects.equals(a.getNome(), nome_cenario)){
                a.setDispositivoTelevisao(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_cenario);
    }
    @PutMapping("/{nome_cenario}/dispositivos/som")//ok
    public Cenario atualizaDispositivoSom (@PathVariable String nome_cenario,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Som disp){
        for(Cenario a: this.cenarios){
            if(Objects.equals(a.getNome(), nome_cenario)){
                a.setDispositivoSom(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_cenario);
    }
    @PutMapping("/{nome_cenario}/dispositivos/arcondicionado")//ok
    public Cenario atualizaDispositivoArcondicionado (@PathVariable String nome_cenario,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody ArCondicionado disp){
        for(Cenario a: this.cenarios){
            if(Objects.equals(a.getNome(), nome_cenario)){
                a.setDispositivoArcondicionado(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_cenario);
    }
    @PutMapping("/{nome_cenario}/dispositivos/portao")//ok
    public Cenario atualizaDispositivoPortao (@PathVariable String nome_cenario,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Portao disp){
        for(Cenario a: this.cenarios){
            if(Objects.equals(a.getNome(), nome_cenario)){
                a.setDispositivoPortao(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_cenario);
    }

    @DeleteMapping("/{nome_cenario}") //ok
    public void excluirCenario(@PathVariable String nome_cenario){
        if (!this.cenarios.removeIf(p-> p.getNome().equals(nome_cenario))){
            throw new CenarioNaoEncontradoException(nome_cenario);
        }
    }
    @DeleteMapping("/{nome_cenario}/dispositivos") //ok
    public void excluirDispositivo(@PathVariable String nome_cenario, @RequestParam(value = "id", defaultValue = "0")int id){
        for(Cenario a : this.cenarios){
            if(a.getNome().equals(nome_cenario)){
                a.excluiDispositivo(id);
            }
        }
    }

    @ControllerAdvice
    class CenarioNaoEncontrado {
        @ResponseBody
        @ExceptionHandler(CenarioNaoEncontradoException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String cenarioNaoEncontrada(CenarioNaoEncontradoException p){
            return p.getMessage();
        }
    }



}


