package poo;

/**
 * Classe poo.Panther
 */
public class Panther extends Veiculo implements TracaoIntegral, VeiculoAnfibio, Conversivel {

    private int temp;
    /**
     * rodas abertas=true recolhidas=false;
     */
    private boolean rodasAbertas = true;
    /**
     * lastrovazio cheio=1 vazio = 0
     */
    private int lastroVazio=1;
    /**
     * tracao ativa=true desativada=false
     */
    private boolean tracao = false;
    /**
     * capota true = aberta false =fechada
     */
    private boolean capota = false;

    /**
     * metodo construtor
     * @param nome para a panther
     */
    public Panther(String nome){ super(nome);}

    public int getTemp() {
        return temp;
    }

    public int getLastroVazio(){return lastroVazio;}

    public boolean getCapota(){return capota;}




    @Override
    public void esvaziarLastro(){}

    public boolean getRodasAbertas(){ return rodasAbertas; }

    public  boolean getTracao(){ return tracao;}


    public void setTempRefri(int t){
        this.temp = t;

    }

    /**
     * liga e desliga a tracao
     * so pode ativar tracao se rodas estiverem abertas
     * so é possivel ativar e desativar tracao se carro estiver parado
     * @return true se foi possivel realizar a função
     */
    @Override
    public boolean ativarDesativarTracao(){
        if(getVelocidade()>0){
            return false;
        }else{
            if(!tracao){
                if(rodasAbertas){
                    tracao = true;
                    return true;
                }else{return false;}

            }else{
                tracao = false;
                return true;
            }
        }
    }

    /**
     * função para recolher a roda
     * necessario esvaziar lastro assim que recolher a roda
     * @return true se for possivel realizar a função
     */
    @Override
    public boolean recolherRodas() {
        if (rodasAbertas) {
            rodasAbertas = false;
            lastroVazio = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * função para abrir as rodas
     * @return true se for possivel abrir as rodas
     */
    @Override
    public boolean abrirRodas(){
        if(!rodasAbertas) {
            rodasAbertas = true;
            return true;
        }else{return false;}
    }

    /**
     * abre a capota
     * @return true se foi possível fazer a operação
     * veiculo deve estar parado
     */
    @Override
    public boolean abrirCapota(){
        if(getVelocidade()==0){
            capota = true;
            return true;
        }else{
            return false;
        }

    }
    /**
     * fecha a capota
     * @return true se foi possivel fazer a operação
     * veiculo deve estar parado
     */
    @Override
    public boolean fecharCapota(){
        if(getVelocidade()==0){
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
