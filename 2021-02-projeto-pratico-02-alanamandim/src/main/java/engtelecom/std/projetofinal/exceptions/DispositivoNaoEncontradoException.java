package engtelecom.std.projetofinal.exceptions;

public class DispositivoNaoEncontradoException extends  RuntimeException{
    public DispositivoNaoEncontradoException(int id){
        super("Não foi possível encontrar o dispositivo com id: "+id);
    }
}
