import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Rainha;
import poo.Pecas;

public class RainhaTest {

    @Test
    public void movimentoTeste(){
        Rainha rainhaB = new Rainha(1,3,0,Pecas.RAINHABRANCA.figura);
        Assertions.assertFalse(rainhaB.checkMovimento(2,2),"Movimento em L");
        Assertions.assertFalse(rainhaB.checkMovimento(7,7),"Lugar aleatório");
        Assertions.assertTrue(rainhaB.checkMovimento(3,3),"mov vertical");
        Assertions.assertTrue(rainhaB.checkMovimento(6,0),"mov horizontal");
        Assertions.assertTrue(rainhaB.checkMovimento(0,3),"movimento diagonal");
        Assertions.assertTrue(rainhaB.checkMovimento(7,4),"mov diagonal");


        Rainha rainhaP = new Rainha(0,3,7,Pecas.RAINHAPRETA.figura);
        Assertions.assertFalse(rainhaP.checkMovimento(2,5),"Movimento em L");
        Assertions.assertFalse(rainhaP.checkMovimento(0,0),"Lugar aleatório");
        Assertions.assertTrue(rainhaP.checkMovimento(3,3),"mov vertical");
        Assertions.assertTrue(rainhaP.checkMovimento(7,7),"mov horizontal");
        Assertions.assertTrue(rainhaP.checkMovimento(0,4),"movimento diagonal");
        Assertions.assertTrue(rainhaP.checkMovimento(7,3),"mov diagonal");

    }
}
