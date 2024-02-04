import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Peao;
import poo.Pecas;

public class PeaoTest {

    @Test
    public void movimentoTeste(){
        Peao peaoB = new Peao(1,2,1, Pecas.PEAOBRANCA.figura);
        Assertions.assertFalse(peaoB.checkMovimento(3,2),"Peão não anda na diagonal se nao for ataque");
        Assertions.assertFalse(peaoB.checkMovimento(1,2),"Mov diagonal...");
        Assertions.assertFalse(peaoB.checkMovimento(2,0),"Movimento para trás");
        Assertions.assertTrue(peaoB.checkMovimento(2,3),"movimento duas casas na pos inicicial");
        Assertions.assertTrue(peaoB.checkMovimento(2,2),"movimento uma casa");
        Assertions.assertFalse(peaoB.checkMovimento(2,5),"Andar mais de uma casa pra frente");

        Peao peaoP = new Peao(0,2,6,Pecas.PEAOPRETA.figura);
        Assertions.assertFalse(peaoP.checkMovimento(3,5),"Peão não anda na diagonal se nao for ataque");
        Assertions.assertFalse(peaoP.checkMovimento(1,5),"Mov diagonal...");
        Assertions.assertFalse(peaoP.checkMovimento(2,7),"Movimento para trás");
        Assertions.assertTrue(peaoP.checkMovimento(2,4),"movimento duas casas na pos inicicial");
        Assertions.assertTrue(peaoP.checkMovimento(2,5),"movimento uma casa");
        Assertions.assertFalse(peaoP.checkMovimento(2,3),"Andar mais de uma casa pra frente");



    }
}
