package poo;

/**
 * Classe que cria a peça Torre
 */
public class Torre extends Tabuleiro {
    /**
     * Método para originar a peça Torre
     * @param jogador 1 para branca 0 para preta
     * @param x coordenada x da peça
     * @param y coordenada y da peça
     * @param picture imagem da peça
     */
    public Torre(int jogador, double x, double y,String picture) {
        super(jogador, x, y,picture);

    }

    @Override
    public boolean checkMovimento(double x, double y) {
        return ((Math.floor(x) - this.getX()) == 0 && (Math.floor(y) - this.getY()) != 0)
                || ((Math.floor(x) - this.getX()) != 0 && (Math.floor(y) - this.getY()) == 0);
    }

}
