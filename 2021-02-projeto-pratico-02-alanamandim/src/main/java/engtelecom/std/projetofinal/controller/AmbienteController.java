package engtelecom.std.projetofinal.controller;

import engtelecom.std.projetofinal.exceptions.AmbienteNaoEncontradoException;
import engtelecom.std.projetofinal.resources.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {
    public List<Ambientes> ambientes = new ArrayList<>();

   // private final List<Cenario>obterCenario = new ArrayList<>();

   @GetMapping //ok
   public List<Ambientes>listar_ambientes(){return this.ambientes;}

   @GetMapping("/{nome_ambiente}") //ok
   public Ambientes obterAmbiente(@PathVariable String nome_ambiente){
       for(Ambientes a: this.ambientes){
           if(a.getNome().equals(nome_ambiente)){
               return a;
           }
       }
       throw new AmbienteNaoEncontradoException(nome_ambiente);
   }

   @GetMapping("/{nome_ambiente}/dispositivos") //ok
   public ArrayList<Dispositivo> obterTodosDispositivos(@PathVariable String nome_ambiente){
       for(Ambientes a: this.ambientes){
           if(a.getNome().equals(nome_ambiente)){
               return a.getDispositivos();
           }

       }throw new AmbienteNaoEncontradoException(nome_ambiente);
   }

   @GetMapping("/{nome_ambiente}/dispositivos/") //ok
   public Dispositivo dispositivo (@PathVariable String nome_ambiente, @RequestParam (value = "id",defaultValue = "0")int id){
       for(Ambientes a :this.ambientes){
           if(a.getNome().equals(nome_ambiente)){
               return a.buscaDispositivoPeloId(id);
           }
       }throw new AmbienteNaoEncontradoException(nome_ambiente);
    }

    @PostMapping("{nome_ambiente}/dispositivos") //ok
    @ResponseStatus(HttpStatus.CREATED)
    public Ambientes adiconaEquipamento(@PathVariable String nome_ambiente, @RequestParam (value = "id",defaultValue = "0")int id){
       for(Ambientes a: this.ambientes){
           if(a.getNome().equals(nome_ambiente)){
               a.adicionaDispositivo(id);
               return a;

           }
       }throw new AmbienteNaoEncontradoException(nome_ambiente);
    }

   @PostMapping("{nome_ambiente}") //ok
   @ResponseStatus(HttpStatus.CREATED)
   public Ambientes adicionaAmbiente(@PathVariable String nome_ambiente){
       Ambientes x = new Ambientes(nome_ambiente);
       this.ambientes.add(x);
       return x;
   }

   @PutMapping("/{nome_ambiente}") //ok
    public Ambientes atualizarAmbiente(@PathVariable String nome_ambiente, @RequestParam(value = "nome")String nome){

       for (Ambientes a: this.ambientes){
           if (a.getNome().equals(nome_ambiente)){
               a.setNome(nome);
               return a;
           }
       }
       throw new AmbienteNaoEncontradoException(nome_ambiente);
   }

   @PutMapping("/{nome_ambiente}/dispositivos/lampada")//ok
   public Ambientes atualizaDispositivoLampada (@PathVariable String nome_ambiente,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Lampada disp){
       for(Ambientes a: this.ambientes){
           if(Objects.equals(a.getNome(), nome_ambiente)){
               a.setDispositivoLampada(disp, id);
               return a;
           }
       }throw new AmbienteNaoEncontradoException(nome_ambiente);
   }
    @PutMapping("/{nome_ambiente}/dispositivos/cortina")//ok
    public Ambientes atualizaDispositivoCortina (@PathVariable String nome_ambiente,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Cortina disp){
        for(Ambientes a: this.ambientes){
            if(Objects.equals(a.getNome(), nome_ambiente)){
                a.setDispositivoCortina(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_ambiente);
    }
    @PutMapping("/{nome_ambiente}/dispositivos/televisao")//ok
    public Ambientes atualizaDispositivoTelevisao (@PathVariable String nome_ambiente,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Televisao disp){
        for(Ambientes a: this.ambientes){
            if(Objects.equals(a.getNome(), nome_ambiente)){
                a.setDispositivoTelevisao(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_ambiente);
    }
    @PutMapping("/{nome_ambiente}/dispositivos/som")//ok
    public Ambientes atualizaDispositivoSom (@PathVariable String nome_ambiente,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Som disp){
        for(Ambientes a: this.ambientes){
            if(Objects.equals(a.getNome(), nome_ambiente)){
                a.setDispositivoSom(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_ambiente);
    }
    @PutMapping("/{nome_ambiente}/dispositivos/arcondicionado") //ok
    public Ambientes atualizaDispositivoArcondicionado (@PathVariable String nome_ambiente,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody ArCondicionado disp){
        for(Ambientes a: this.ambientes){
            if(Objects.equals(a.getNome(), nome_ambiente)){
                a.setDispositivoArcondicionado(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_ambiente);
    }
    @PutMapping("/{nome_ambiente}/dispositivos/portao") //ok
    public Ambientes atualizaDispositivoPortao (@PathVariable String nome_ambiente,@RequestParam (value = "id",defaultValue = "0")int id,  @RequestBody Portao disp){
        for(Ambientes a: this.ambientes){
            if(Objects.equals(a.getNome(), nome_ambiente)){
                a.setDispositivoPortao(disp, id);
                return a;
            }
        }throw new AmbienteNaoEncontradoException(nome_ambiente);
    }

    @DeleteMapping("/{nome_ambiente}") //ok
    public void excluirAmbiente(@PathVariable String nome_ambiente){
        if (!this.ambientes.removeIf(p-> p.getNome().equals(nome_ambiente))){
            throw new AmbienteNaoEncontradoException(nome_ambiente);
        }
    }

    @DeleteMapping("/{nome_ambiente}/dispositivos") //ok
    public void excluirDispositivo(@PathVariable String nome_ambiente, @RequestParam(value = "id", defaultValue = "0")int id){
       for(Ambientes a : this.ambientes){
           if(a.getNome().equals(nome_ambiente)){
               a.excluiDispositivo(id);
           }//throw new AmbienteNaoEncontradoException(nome_ambiente);
       }
    }





    @ControllerAdvice
    class AmbienteNaoEncontrado {
        @ResponseBody
        @ExceptionHandler(AmbienteNaoEncontradoException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String ambienteNaoEncontrada(AmbienteNaoEncontradoException p){
            return p.getMessage();
        }
    }

}
