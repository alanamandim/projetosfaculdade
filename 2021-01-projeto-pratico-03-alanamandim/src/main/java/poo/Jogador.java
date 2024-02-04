package poo;

/**
 * Classe que cria as peças para os jogadores
 */
public class Jogador {

    private String nome;
    private  int jogador;

    public Tabuleiro[] pecas = new Tabuleiro[17];

    /**
     * Método para adiconar as peças
     * @param nome nome do jogador
     * @param jogador 1 para branco 0 para preta
     */
    public Jogador(String nome,int jogador){
        this.nome = nome;
        this.jogador = jogador;
        int i=1;

        for(int c=1;c<17;c++){
            this.pecas[c] = null;
        }

        if(this.jogador==1){
            this.pecas[i] = new Torre(this.jogador,Pecas.TORREBRANCA.x,Pecas.TORREBRANCA.y,Pecas.TORREBRANCA.figura);
            i++;
            this.pecas[i] = new Cavalo(this.jogador, Pecas.CAVALOBRANCA.x,Pecas.CAVALOBRANCA.y,Pecas.CAVALOBRANCA.figura);
            i++;
            this.pecas[i] = new Bispo(this.jogador,Pecas.BISPOBRANCA.x,Pecas.BISPOBRANCA.y,Pecas.BISPOBRANCA.figura);
            i++;
            this.pecas[i] = new Rainha(this.jogador,Pecas.RAINHABRANCA.x,Pecas.RAINHABRANCA.y,Pecas.RAINHABRANCA.figura);
            i++;
            this.pecas[i] = new Rei(this.jogador,Pecas.REIBRANCA.x, Pecas.REIBRANCA.y,Pecas.REIBRANCA.figura);
            i++;
            this.pecas[i] = new Bispo (this.jogador,Pecas.BISPOBRANCA.x+3,Pecas.BISPOBRANCA.y,Pecas.BISPOBRANCA.figura );
            i++;
            this.pecas[i] = new Cavalo(this.jogador, Pecas.CAVALOBRANCA.x+5,Pecas.CAVALOBRANCA.y,Pecas.CAVALOBRANCA.figura);
            i++;
            this.pecas[i] = new Torre(this.jogador,Pecas.TORREBRANCA.x+7,Pecas.TORREBRANCA.y,Pecas.TORREBRANCA.figura);
            i++;
            int j=0;
            while(i<17){

                this.pecas[i] = new Peao(this.jogador, Pecas.PEAOBRANCA.x+j,Pecas.PEAOBRANCA.y,Pecas.PEAOBRANCA.figura);
                j++;
                i++;
            }

        }else{
            this.pecas[i] = new Torre(this.jogador,Pecas.TORREPRETA.x,Pecas.TORREPRETA.y,Pecas.TORREPRETA.figura);
            i++;
            this.pecas[i] = new Cavalo(this.jogador, Pecas.CAVALOPRETA.x,Pecas.CAVALOPRETA.y,Pecas.CAVALOPRETA.figura);
            i++;
            this.pecas[i] = new Bispo(this.jogador,Pecas.BISPOPRETA.x,Pecas.BISPOPRETA.y,Pecas.BISPOPRETA.figura);
            i++;
            this.pecas[i] = new Rainha(this.jogador,Pecas.RAINHAPRETA.x,Pecas.RAINHAPRETA.y,Pecas.RAINHAPRETA.figura);
            i++;
            this.pecas[i] = new Rei(this.jogador,Pecas.REIPRETA.x, Pecas.REIPRETA.y,Pecas.REIPRETA.figura);
            i++;
            this.pecas[i] = new Bispo (this.jogador,Pecas.BISPOPRETA.x+3,Pecas.BISPOPRETA.y,Pecas.BISPOPRETA.figura );
            i++;
            this.pecas[i] = new Cavalo(this.jogador, Pecas.CAVALOPRETA.x+5,Pecas.CAVALOPRETA.y,Pecas.CAVALOPRETA.figura);
            i++;
            this.pecas[i] = new Torre(this.jogador,Pecas.TORREPRETA.x+7,Pecas.TORREPRETA.y,Pecas.TORREPRETA.figura);
            i++;
            int j=0;
            while(i<17){

                this.pecas[i] = new Peao(this.jogador, Pecas.PEAOPRETA.x+j,Pecas.PEAOPRETA.y,Pecas.PEAOPRETA.figura);
                j++;
                i++;
            }
        }

    }


}
