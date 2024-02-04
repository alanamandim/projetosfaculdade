package poo;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.*;
import java.util.Scanner;

/**
 * Classe que controla as peças do jogo, cria peças do jogo e confere e legalidade dos movimentos
 */
public class Play implements DrawListener {
    private final int dimensao;
    private Circulo circulo;
    private Draw draw;
    private Jogador jogador1;
    private Jogador jogador;
    int vez =0;
    int id;
    Scanner input = new Scanner(System.in);

    /**
     * Método que inicia o jogo
     * @param dimensao informa a dimensão do tabuleiro
     */
    public Play(int dimensao) {

        draw = new Draw();

        jogador1 = new Jogador("preto",0);
        jogador = new Jogador("branco",1);

        circulo = new Circulo(0, 0); //informar qual a cor da peça
        // Objeto responsável por fazer a área de desenho (canvas)
       // draw = new Draw();

        // Adicionando objeto desta classe como o
        // objeto que ficará ouvindo por eventos do mouse ou teclado
        draw.addListener(this);

        // Indicando o número de casas da área de desenho
        this.dimensao = dimensao;
        draw.setXscale(0, dimensao);
        draw.setYscale(0, dimensao);
        draw.enableDoubleBuffering();

        // Desenhando os objetos na tela
        desenharTela();
    }

    /**
     * Desenha a grade do tabuleiro e o tabuleiro
     */
    public void desenharTabuleiro(){
        draw.setPenColor(Color.BLACK);
        draw.picture(4,4,"board.gif");
        for (int i = 0; i <= dimensao; i++) draw.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j++) draw.line(0, j, dimensao, j);


    }

    /**
     * Faz o objeto Tabuleiro se desenhar na tela
     */
    public void desenharPecas(){
        circulo.desenhar(draw);
        for (int i = 1; i < 17; i++) {
            if(!jogador1.pecas[i].isCapturado()) {
                jogador1.pecas[i].desenhar(draw);
            }
            if(!jogador.pecas[i].isCapturado()){
                jogador.pecas[i].desenhar(draw);
            }
        }
    }

    /**
     * Limpa a tela, desenha o tabuleiro e as peças
     */
    public void desenharTela(){
        draw.clear(Color.LIGHT_GRAY);
        this.desenharTabuleiro();
        this.desenharPecas();
        draw.show();
    }


    /**
     * Método paga localizar id da peça na coordenada x,y
     * @param x coordenada x do click
     * @param y coordenada y do click
     * @param jog informa qual jogador é, sendo 1(branca) 0(preta)
     * @return retorna o id da peça q contém as coordenada x y passada, caso não haja retorna 0
     */
    public int pegaPeca(double x, double y,int jog ){
    for (int i = 1; i <17 ; i++) {
        if(jog==1) {
            if (Math.floor(x) == jogador.pecas[i].getX() && Math.floor(y) == jogador.pecas[i].getY() && !jogador.pecas[i].isCapturado()) {
                return i;
            }
        }else {
                if (Math.floor(x) == jogador1.pecas[i].getX() && Math.floor(y) == jogador1.pecas[i].getY() && !jogador1.pecas[i].isCapturado()) {
                    return i;
                }
            }
        }

            return 0;
}

    /**
     * Método que verifica se existe peça na coordenada informada
     * @param x coordenada x do click
     * @param y coordenada x do click
     * @param jog informa qual jogador é, sendo 1(branca) 0(preta)
     * @return true se não houver peça e false se encontrar alguma peça
     */
    public boolean verificaNPeca(double x, double y,int jog){
    return pegaPeca(x, y, jog) <= 0;
}

    /**
     * Método que verifica se tem alguma peça selecionada, se houver desmarca
     */
    public void verificaSelecao(){
    for (int i = 1; i <17 ; i++) {
        if (jogador.pecas[i].isSelecionado()) {
            jogador.pecas[i].marcaDesmarca();
        }
        if (jogador1.pecas[i].isSelecionado()) {
            jogador1.pecas[i].marcaDesmarca();
        }
    }
}

    /**
     * Método verifica existência de peça seja ela branca ou preta
     * @param x coordenada x do click
     * @param y coordenada y do click
     * @return true se não houver peça, false se houver
     */
    public  boolean movimentoValido(double x, double y){
        //verifica se tem peça branca
      if(!verificaNPeca(x,y,1)){
         return false;
     }
      return verificaNPeca(x,y,0);
    }

    /**
     * Método para verificar se há peças no caminho ao realizar  movimento horizontal
     * @param x0 coordenada x da peça
     * @param y0 coordenada y da peça
     * @param disX distância entre peça e o local do click no eixo x
     * @return true se não existirem peças no caminho e false caso tenha
     */
    public boolean movX(double x0, double y0, double disX){
        double quantMOv = Math.abs(disX);

        double dirX = disX/quantMOv;

        for (int i = 0; i < quantMOv-1; i++) {
            if(!movimentoValido(x0+dirX,y0))return false;
            x0 += dirX;
        }
        return true;
    }

    /**
     * Método para verificar se há peças no caminho ao realizar movimento na vertical
     * @param x0 coordenada x da peça
     * @param y0 coordenada y da peça
     * @param disY distância entre peça e o local do click no eixo y
     * @return true se não existirem peças no caminho e false caso tenha
     */
    private boolean movY(double x0, double y0,double disY){
        double quantMovY = Math.abs(disY);
        double dirY = disY/quantMovY;
        for (int i = 0; i < quantMovY-1; i++) {
            if(!movimentoValido( x0,y0+dirY))return false;
            y0 += dirY;
        }
        return true;
    }

    /**
     * Método verificar se não peça no caminho ao realizar movimento na diagonal
     * @param x0 coordenada x da peça
     * @param y0 coordenada y da peça
     * @param disX distância entre peça e o local do click no eixo x
     * @param disY distância entre peça e o local do click no eixo y
     * @return true se não existirem peças no caminho e false caso tenha
     */
    public boolean movdiagonal(double x0, double y0, double disX, double disY){
        double quantMov = Math.abs(disX);

        double dirX = disX/quantMov;
        double dirY = disY/quantMov;

        for(int i=0;i<quantMov-1;i++){
            if(!movimentoValido(x0+dirX,y0+dirY))return false;
            x0 = x0 + dirX;
            y0 = y0 + dirY;
        }
        return true;
    }

    /**
     * Método que identifica qual tipo de movimento e se pode ser realizado
     * @param x0  coordenada x da peça
     * @param y0 coordenada y da peça
     * @param x coordenada x do click
     * @param y coordenada y do click
     * @return true se não há peças no caminho a ser percorrido false se há peça
     */
    public boolean verificaMov(double x0,double y0, double x, double y){
        if(vez==0){
            if(jogador.pecas[id] instanceof Cavalo){
                return true;
            }

        }else{
            if(jogador1.pecas[id] instanceof Cavalo){
                return true;
            }
        }
        double disX = (Math.floor(x)-x0);
        double disY = (Math.floor(y)-y0);


        // diagonal
        if(Math.abs(Math.floor(x)-x0)==Math.abs(Math.floor(y)-y0)){
            return movdiagonal(x0, y0, disX, disY);
        }
        // linear
        else{
            if(disX!=0){
                if(!movX(x0,y0, disX))return false;
            }
            if(disY!=0){
                return movY(x0, y0, disY);
            }
        }
        return true;
    }

    /**
     * Método que verifica se o Peão  esta atacando com movimento válido
     * @param x coordenada x do click
     * @param y coordenada y do click
     * @return true se for um ataque permitido do peão, false se nao
     */
    public boolean verificaMovAtaquePeao(double x, double y) {
        if (vez == 0) {
            return (Math.floor(y) - jogador.pecas[id].getY()) == 1 && Math.abs(jogador.pecas[id].getX() - Math.floor(x)) == 1;
        } else {
            return Math.floor(y) == jogador1.pecas[id].getY() - 1 && Math.abs(jogador1.pecas[id].getX() - Math.floor(x)) == 1;

        }
    }

    /**
     * Método que move a peça para destino e muda a vez do jogador
     * @param x coordenada x do click
     * @param y coordenada y do click
     */
    public void movSelecao(double x,double y){
        if(vez==0){
            jogador.pecas[id].setX(x);
            jogador.pecas[id].setY(y);
            jogador.pecas[id].setSelecionado(false);
            vez = 1;
        }else{
            jogador1.pecas[id].setX(x);
            jogador1.pecas[id].setY(y);
            jogador1.pecas[id].setSelecionado(false);
            vez = 0;
        }
    }

    /**
     * Método que troca o peão por outra peça se o mesmo tiver direito
     * @param x coordenada x do click
     * @param y coordenada y do click
     */
    public void upDatePeao(double x, double y) {
        if (vez == 0) {
            if (Math.floor(y) == 7) {
                System.out.println("****Informe qual peça você deseja transformar seu peão****");
                System.out.println("\n1 - Rainha" + "\n 2 - Torre \n 3 - Bispo \n 4 - Cavalo \n 5 - Peão");
                int option = input.nextInt();
                if (option == 1) {
                    jogador.pecas[id] = new Rainha(1, 0, 0, Pecas.RAINHABRANCA.figura);
                }
                if (option == 2) {
                    jogador.pecas[id] = new Torre(1, 0, 0, Pecas.TORREBRANCA.figura);
                }
                if (option == 4) {
                    jogador.pecas[id] = new Cavalo(1, 0, 0, Pecas.CAVALOBRANCA.figura);
                }
                if (option == 3) {
                    jogador.pecas[id] = new Bispo(1, 0, 0, Pecas.BISPOBRANCA.figura);
                }
            }
        }else{
            if (Math.floor(y) == 0) {
                System.out.println("****Informe qual peça você deseja transformar seu peão****");
                System.out.println("\n1 - Rainha" + "\n 2 - Torre \n 3 - Bispo \n 4 - Cavalo \n 5 - Peão");
                int option = input.nextInt();
                if (option == 1) {
                    jogador1.pecas[id] = new Rainha(0, 0, 0, Pecas.RAINHAPRETA.figura);
                }
                if (option == 2) {
                    jogador1.pecas[id] = new Torre(0, 0, 0, Pecas.TORREPRETA.figura);
                }
                if (option == 4) {
                    jogador1.pecas[id] = new Cavalo(0, 0, 0, Pecas.CAVALOPRETA.figura);
                }
                if (option == 3) {
                    jogador1.pecas[id] = new Bispo(0, 0, 0, Pecas.BISPOPRETA.figura);
                }
            }
        }
    }

    /**
     * Método que  seleciona a peça clicada e desmarca caso exista outra
     * @param x coordenada x do click
     * @param y coordenada y do click
     * @param p peça clicada
     */
    public void varreSelecao(double x, double y, Tabuleiro p){
        if(!p.isSelecionado()){
            verificaSelecao();
            p.marcaDesmarca();
        }
    }

    /**
     * Método que verifica se é um Peão e se é um ataque válido
     * @param x coordenada x do click
     * @param y coordenada y do click
     * @param jog informa qual jogador está atacando
     * @return true se for uma ataque permitido false se for inválido
     */
    public boolean verificaAtaquePeao(double x, double y,int jog) {

        if (!verificaNPeca(x, y, 0) && verificaMovAtaquePeao(x, y) && jogador.pecas[id] instanceof Peao
                || !verificaNPeca(x, y,1) && verificaMovAtaquePeao(x, y) && jogador1.pecas[id] instanceof Peao) {
            if(jog==1){
                jogador1.pecas[pegaPeca(x, y, 0)].setCapturado(true);

            }else{
                jogador.pecas[pegaPeca(x, y,1)].setCapturado(true);
            }
            upDatePeao(x, y);
            movSelecao(x, y);
            return true;
        }
        return false;
    }

    /**
     * Método verifica se é uma movimento de ataque exceto do Peão
     * @param x coordenada x do click
     * @param y coordenada y do click
     * @return true se for um ataque false se não
     */
    public boolean verificaAtaque(double x, double y) {
        if (!verificaNPeca(x, y, 1) && !(jogador1.pecas[id] instanceof Peao) && vez ==1 || !verificaNPeca(x, y,0) && !(jogador.pecas[id] instanceof Peao) && vez == 0 ) {
                movSelecao(x, y);
                if(vez==0) {
                    jogador.pecas[pegaPeca(x, y, 1)].setCapturado(true);
                }else{
                    jogador1.pecas[pegaPeca(x,y,0)].setCapturado(true);
                }
                return true;
            }

        return false;
    }

    /**
     * Captura o evento de botão pressionado do mouse
     * @param x coordenada X do cursor do mouse quando o botão foi pressionado
     * @param y coordenada Y do cursor do mouse quando o botão foi pressionado
     */
    public void mousePressed(double x, double y) {

        // Se o usuário clicou dentro da casa do tabuleiro onde está o círculo
            if (vez == 0) {
                //pega o id da peça
                int l=pegaPeca(x,y,1);
                //se o local clicado  tem peça branca
                if(!verificaNPeca(x,y,1)){
                    //seleciona a peça branca clicada e verifica se nao terão mais de uma peça selecionada
                    varreSelecao(x,y,jogador.pecas[l]);
                    //carrega o id da peça
                    this.id = l;
                } else {
                    // se nao for ataque do peao
                    if(!verificaAtaquePeao(x,y,jogador.pecas[id].getJogador())){
                        //verifica se é um movimento permitido
                        if (verificaMov(jogador.pecas[id].getX(), jogador.pecas[id].getY(), x, y) && jogador.pecas[id].checkMovimento(x, y)) {
                            //se for verifica se é um ataque de qualquer peça exceto o peao
                            if (!verificaAtaque(x,y)){
                                //se nao for um ataque, verifica se o peão pode upar
                                upDatePeao(x,y);
                                //realiza o movimento e passa a vez
                                movSelecao(x,y);
                            }
                        }
                    }
                }

            // se for a vez do preto
            } else {

                int i=pegaPeca(x,y,0);
                ;
                //se o local clicado  tem peça preta
                if(!verificaNPeca(x,y,0)){
                    //seleciona a peça preta clicada e verifica se nao terão mais de uma peça selecionada
                    varreSelecao(x,y,jogador1.pecas[i]);
                    //carrega o id da peça selecionada
                    this.id = i;

                } else {
                    if(!verificaAtaquePeao(x,y,jogador1.pecas[id].getJogador())){
                        //verifica se é ataque de outra peça
                        if (verificaMov(jogador1.pecas[id].getX(), jogador1.pecas[id].getY(), x, y) && jogador1.pecas[id].checkMovimento(x, y)) {
                            //verifica se é ataque de alguma peça
                            if(!verificaAtaque(x,y)){
                                upDatePeao(x,y);
                                movSelecao(x,y);
                            }
                        }
                    }
                }

        }

        // Limpa a tela e desenha tudo novamente (tabuleiro e círculo)
        desenharTela();
    }

    @Override
    public void mouseDragged(double v, double v1) {    }
    @Override
    public void mouseReleased(double v, double v1) {    }
    @Override
    public void mouseClicked(double v, double v1) {    }
    @Override
    public void keyTyped(char c) {    }
    @Override
    public void keyPressed(int i) {    }
    @Override
    public void keyReleased(int i) {    }


    public static void main(String[] args) {
        Play p = new Play(8);
    }

}
