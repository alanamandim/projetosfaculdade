package poo;

/**
 * Classe para criar a peça cavalo
 */
public class Cavalo extends Tabuleiro {
    /**
     * Método para originar a peça cavalo
     * @param jogador 1 para branca 0 para preta
     * @param x coordenada x da peça
     * @param y coordenada y da peça
     * @param picture imagem da peça
     */
    public Cavalo(int jogador, double x, double y, String picture){
        super(jogador, x, y,picture);
    }


    @Override
    public boolean checkMovimento(double x, double y) {
        return (Math.abs(Math.floor(x) - this.getX()) == 2 & Math.abs(Math.floor(y) - this.getY()) == 1) || (Math.abs(Math.floor(x) - this.getX()) == 1 & Math.abs(Math.floor(y) - this.getY()) == 2);
    }
}
