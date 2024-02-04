import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Rei;
import poo.Pecas;

public class ReiTest {

    @Test
    public void movimentoTeste(){
        Rei reiB = new Rei(1,4,0,Pecas.REIBRANCA.figura);
        Assertions.assertFalse(reiB.checkMovimento(3,2),"Movimento em L");
        Assertions.assertFalse(reiB.checkMovimento(7,7),"Lugar aleatório");
        Assertions.assertFalse(reiB.checkMovimento(4,4),"movimento maior q uma casa");
        Assertions.assertTrue(reiB.checkMovimento(4,1),"mov vertical de uma casa");
        Assertions.assertTrue(reiB.checkMovimento(5,0),"mov horizontal");
        Assertions.assertTrue(reiB.checkMovimento(5,1),"movimento diagonal");
        Assertions.assertTrue(reiB.checkMovimento(3,1),"mov diagonal");


        Rei reiP = new Rei(0,4,7,Pecas.REIPRETA.figura);
        Assertions.assertFalse(reiP.checkMovimento(3,5),"Movimento em L");
        Assertions.assertFalse(reiP.checkMovimento(0,0),"Lugar aleatório");
        Assertions.assertTrue(reiP.checkMovimento(4,6),"mov vertical");
        Assertions.assertTrue(reiP.checkMovimento(3,7),"mov horizontal");
        Assertions.assertTrue(reiP.checkMovimento(5,6),"movimento diagonal");
        Assertions.assertTrue(reiP.checkMovimento(3,6),"mov diagonal");

    }
}
