import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Bispo;
import poo.Pecas;

class BispoTest {

    @Test
    public void movimentoTest(){
        //casa preta
        Bispo bispoTest = new Bispo(1,2,0, Pecas.BISPOBRANCA.figura);
        Assertions.assertFalse(bispoTest.checkMovimento(2,2),"Não anda para frente");
        Assertions.assertFalse(bispoTest.checkMovimento(3,0),"Não anda para o lado ");
        Assertions.assertTrue(bispoTest.checkMovimento(0,2),"Movimento diagonal");
        Assertions.assertTrue(bispoTest.checkMovimento(6,4),"Movimento diagonal");

        //casa branca
        Bispo bispo2 = new Bispo(0,2,7, Pecas.BISPOPRETA.figura);
        Assertions.assertFalse(bispo2.checkMovimento(2,6));
        Assertions.assertFalse(bispo2.checkMovimento(1,7));
        Assertions.assertTrue(bispo2.checkMovimento(5,4));
        Assertions.assertTrue(bispo2.checkMovimento(0,5));

    }
}