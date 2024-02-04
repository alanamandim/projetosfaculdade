import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Cavalo;
import poo.Pecas;

public class CavaloTest {

    @Test
    public void movimentoTeste(){
        Cavalo CavaloB = new Cavalo(1,1,0, Pecas.CAVALOBRANCA.figura);
        Assertions.assertFalse(CavaloB.checkMovimento(2,1),"não anda na diagonal se nao for ataque");
        Assertions.assertFalse(CavaloB.checkMovimento(0,1),"Mov diagonal...");
        Assertions.assertFalse(CavaloB.checkMovimento(1,1),"Movimento para frente");
        Assertions.assertTrue(CavaloB.checkMovimento(2,2),"movimento duas casas na pos inicicial");
        Assertions.assertTrue(CavaloB.checkMovimento(0,2),"movimento uma casa");
        Assertions.assertFalse(CavaloB.checkMovimento(1,5),"Andar mais de uma casa pra frente");

        Cavalo CavaloP = new Cavalo(0,1,7,Pecas.PEAOPRETA.figura);
        Assertions.assertFalse(CavaloP.checkMovimento(0,6),"Peão não anda na diagonal se nao for ataque");
        Assertions.assertFalse(CavaloP.checkMovimento(2,6),"Mov diagonal...");
        Assertions.assertFalse(CavaloP.checkMovimento(1,6),"Movimento para frente");
        Assertions.assertTrue(CavaloP.checkMovimento(0,5),"movimento duas casas na pos inicicial");
        Assertions.assertTrue(CavaloP.checkMovimento(2,5),"movimento uma casa");
        Assertions.assertFalse(CavaloP.checkMovimento(0,4),"Andar mais de uma casa pra frente");



    }
}

