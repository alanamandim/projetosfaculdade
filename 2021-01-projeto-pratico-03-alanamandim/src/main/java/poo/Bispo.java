package poo;

/**
 * Classe para criar a peça bispo
 */
public class Bispo extends Tabuleiro {

    /**
     * Método para originar a peça bispo
     * @param jogador 1 para branca 0 para preta
     * @param x coordenada x da peça
     * @param y coordenada y da peça
     * @param picture imagem da peça
     */
    public Bispo(int jogador,double x , double y,String picture) {

        super(jogador, x, y,picture);

    }


    @Override
    public boolean checkMovimento(double x, double y) {
        if (Math.abs(Math.floor(x) - getX()) == Math.abs(Math.floor(y) - getY())){
            return true;
        }
        return false;

    }


}