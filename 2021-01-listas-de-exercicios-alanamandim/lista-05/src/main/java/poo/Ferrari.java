package poo;

/**
 * classe poo.Ferrari
 */
public class Ferrari extends Veiculo implements Conversivel {
    /**
     * farol de neblina true = ligado false =desligado
     */
    private boolean farolLigado = false;
    /**
     * capota true = aberta false =fechada
     */
    private boolean capota=false;

    /**
     * Metodo construtor
     * @param nome da ferrari
     */
    public Ferrari(String nome){ super(nome);}

    public boolean getCapota(){ return capota;}

    /**
     * liga/desliga farol
     * @return true se foi possivel realizar a funçao
     */
    public boolean ligarFarolNeblina(){
        if(!farolLigado){
            farolLigado = true;
        }else{
            farolLigado = false;
        }

        return true;
    }

    public boolean getFarolLigado(){ return farolLigado;}

    /**
     * abre a capota
     * @return true se foi possível fazer a operação
     * vel deve ser abaixo de 20
     */
    @Override
    public boolean abrirCapota(){
        if(getVelocidade()<20){
            capota = true;
            return true;
        }else{
            return false;
        }

    }

    /**
     * fecha a capota
     * @return true se foi possivel fazer a operação
     * vel deve ser igual ou abaixo de 20
     */
    @Override
    public boolean fecharCapota(){
        if(getVelocidade()<20){
            capota = false;
            return true;
        }else{return false;}
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
