package poo;

/**
 * classe poo.Pampa
 */
public class Pampa extends Veiculo implements TracaoIntegral {
    /**
     * tracao ativada=true desativada=false
     */
    private boolean tracao=false;
    /**
     * caçamba fechada=false aberta=true
     */
    private boolean cacamba=false;

    public boolean getTracao(){return tracao;}

    /**
     * metodo construtor
     * @param nome do pampa
     */
    public Pampa(String nome){super(nome);}


    /**
     * função para abrir a cacamba
     * @return true se for possivel abrir
     * veiculo tem q estar parado
     */
    public boolean abrirCacamba(){
        if(!cacamba && getVelocidade()==0){
            cacamba=true;
            return true;
        }else{return false;}
    }

    /**
     * função para fechar a caçamba
     * @return true se for possivel fechar;
     * veiculo tem q estar parado
     */
    public boolean fecharCacamba(){
        if(cacamba && getVelocidade()==0){
            cacamba=false;
            return true;
        }else{return false;}
    }

    /**
     * liga e desliga a tracao
     * so é possivel ativar e desativar tracao se carro estiver parado
     * @return true se foi possivel realizar a função
     */
    @Override
    public boolean ativarDesativarTracao(){
        if(getVelocidade()>0){
            return false;
        }else{
            if(!tracao){
                    tracao = true;
                    return true;
            }else{
                tracao = false;
                return true;
            }
        }
    }


    /**
     * Reduz a velocidade do veiculo de acordo com o valor passado
     * @param i valor a ser decrementado na velocidade
     */
    @Override
    public void frear(int i) {
        if(getVelocidade()<=i){
            velocidade = 0;
        }else{
            velocidade = velocidade -i;
        }
    }

    /**
     * aumenta a velocidde do veiculo de acordo com o valor passado
     * @param i valor a ser incrementado a velocidade
     */
    @Override
    public void acelerar(int i) {
        velocidade=velocidade+i;

    }

}
