package engtelecom.std.projetofinal.exceptions;

public class AmbienteNaoEncontradoException extends  RuntimeException{
    public AmbienteNaoEncontradoException(String nome){
        super("Não foi possível encontrar ambiente com o nome: "+nome);
    }
}
