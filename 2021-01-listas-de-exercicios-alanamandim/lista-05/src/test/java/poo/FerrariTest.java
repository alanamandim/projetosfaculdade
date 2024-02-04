import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Ferrari;

public class FerrariTest {
    @Test
    public void testAcelerar(){
        //ArrayList<poo.Veiculo>veiculos = new ArrayList<>();
        Ferrari ferrari = new Ferrari("teste");
        ferrari.acelerar(50);
        ferrari.acelerar(40);
        Assertions.assertEquals(90,ferrari.getVelocidade(),"Função acelerar incorreta");

    }

    @Test
    public void testFreia(){
        //ArrayList<poo.Veiculo>veiculos = new ArrayList<>();
        Ferrari ferrari1 = new Ferrari("teste1");
        ferrari1.frear(50);
        Assertions.assertEquals(0,ferrari1.getVelocidade(),"Função frear com zero de velocidade incorreta");

        Ferrari ferrari2 = new Ferrari("teste3");
        ferrari2.acelerar(60);
        ferrari2.frear(10);
        Assertions.assertEquals(50,ferrari2.getVelocidade(),"Função frear incorreta");

    }

    @Test
    public void testLigarFarol(){
        Ferrari ferrari2 = new Ferrari("teste4");
        Assertions.assertFalse(ferrari2.getFarolLigado(),"Farol desl ok");
        ferrari2.ligarFarolNeblina();
        Assertions.assertTrue(ferrari2.getFarolLigado(),"Farol lig ok");

    }

    @Test
    public void testeCapota(){
        Ferrari ferrari3 = new Ferrari("teste5");
        ferrari3.acelerar(40);
        ferrari3.abrirCapota();
        Assertions.assertFalse(ferrari3.getCapota(),"Teste capota acima da vel");
        ferrari3.frear(25);
        ferrari3.abrirCapota();
        Assertions.assertTrue(ferrari3.getCapota(), "teste capota  abaixo da vel");
        ferrari3.fecharCapota();
        Assertions.assertFalse(ferrari3.getCapota(),"teste capota abaixo da vel");
        ferrari3.acelerar(30);
        ferrari3.abrirCapota();
        Assertions.assertFalse(ferrari3.getCapota(),"teste fehcar capota acima da vel");
        ferrari3.frear(45);
        ferrari3.abrirCapota();
        Assertions.assertTrue(ferrari3.getCapota(),"teste capota parada");
    }



}
