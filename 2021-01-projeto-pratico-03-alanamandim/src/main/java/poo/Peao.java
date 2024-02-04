package poo;

/**
 * Classe para criar a peça Peão
 */
public class Peao extends Tabuleiro {
    /**
     * Método para originar a peça peao
     * @param jogador 1 para branca 0 para preta
     * @param x coordenada x da peça
     * @param y coordenada y da peça
     * @param picture imagem da peça
     */
    public Peao(int jogador, double x, double y, String picture) {
        super(jogador, x, y, picture);
    }

    @Override
    public boolean checkMovimento(double x, double y) {
        //branca

        if (this.getY() == 1 && getJogador() == 1 || this.getY() == 6 && getJogador() == 0) {
            if (getJogador() == 1) {
                return (Math.floor(x) == this.getX()) & (Math.floor(y) == this.getY() + 1) || (Math.floor(x) == this.getX()) & (Math.floor(y) == this.getY() + 2);

            } else {
                return Math.floor(x) == this.getX() & Math.floor(y) == this.getY() - 1 || Math.floor(x) == this.getX() & Math.floor(y) == this.getY() - 2;
            }


        } else {
            if (getJogador() == 1) {
                    return Math.floor(x) == this.getX() & Math.floor(y) == this.getY() + 1;

            } else {
                    return Math.floor(x) == this.getX() & Math.floor(y) == this.getY() - 1;

            }

        }
    }

}