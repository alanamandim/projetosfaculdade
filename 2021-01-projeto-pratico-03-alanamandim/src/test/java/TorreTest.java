import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Torre;
import poo.Pecas;

public class TorreTest {

    @Test
    public void movimentoTeste(){
        Torre torreB = new Torre(1,0,0,Pecas.TORREBRANCA.figura);
        Assertions.assertFalse(torreB.checkMovimento(1,2),"Movimento em L");
        Assertions.assertFalse(torreB.checkMovimento(7,7),"Lugar aleatório");
        Assertions.assertTrue(torreB.checkMovimento(0,3),"mov vertical");
        Assertions.assertTrue(torreB.checkMovimento(6,0),"mov horizontal");
        Assertions.assertFalse(torreB.checkMovimento(2,2),"movimento diagonal");


        Torre torreP = new Torre(0,0,7,Pecas.RAINHAPRETA.figura);
        Assertions.assertFalse(torreP.checkMovimento(1,5),"Movimento em L");
        Assertions.assertFalse(torreP.checkMovimento(7,0),"Lugar aleatório");
        Assertions.assertTrue(torreP.checkMovimento(0,3),"mov vertical");
        Assertions.assertTrue(torreP.checkMovimento(7,7),"mov horizontal");
        Assertions.assertFalse(torreP.checkMovimento(2,5),"movimento diagonal");

    }
}
