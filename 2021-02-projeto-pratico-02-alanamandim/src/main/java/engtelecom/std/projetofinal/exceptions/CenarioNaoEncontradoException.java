package engtelecom.std.projetofinal.exceptions;

public class CenarioNaoEncontradoException extends  RuntimeException{
        public CenarioNaoEncontradoException(String nome){
            super("Não foi possível encontrar o cenário com o nome: "+nome);
        }


}
