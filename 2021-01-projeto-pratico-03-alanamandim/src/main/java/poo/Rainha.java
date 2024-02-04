package poo;

/**
 * Classe para criar peça Rainha
 */
public class Rainha extends Tabuleiro {
    /**
     * Método para originar a peça Rainha
     * @param jogador 1 para branca 0 para preta
     * @param x coordenada x da peça
     * @param y coordenada y da peça
     * @param picture imagem da peça
     */
    public Rainha(int jogador, double x, double y, String picture){
        super(jogador, x, y, picture);
    }


    @Override
    public boolean checkMovimento(double x, double y) {
            //verificando se é linear ou diagonal
        return ((Math.floor(x) - this.getX()) == 0 & (Math.floor(y) - this.getY()) != 0) || ((Math.floor(x) - this.getX()) != 0 & (Math.floor(y) - this.getY()) == 0) ||
                Math.abs(Math.floor(x) - getX()) == Math.abs(Math.floor(y) - getY());
    }


}
