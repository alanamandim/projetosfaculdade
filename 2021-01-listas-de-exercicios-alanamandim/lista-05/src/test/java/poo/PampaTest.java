import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Pampa;

public class PampaTest {

    @Test
    public void testAcelerar(){
        //ArrayList<poo.Veiculo>veiculos = new ArrayList<>();
        Pampa pampa = new Pampa("teste2");
        pampa.acelerar(50);
        pampa.acelerar(40);
        Assertions.assertEquals(90,pampa.getVelocidade(),"Função acelerar incorreta");

    }

    @Test
    public void testFreia(){
        //ArrayList<poo.Veiculo>veiculos = new ArrayList<>();
        Pampa pampa1 = new Pampa("teste3");
        pampa1.frear(50);
        Assertions.assertEquals(0,pampa1.getVelocidade(),"Função frear com zero de velocidade incorreta");

        Pampa pampa2 = new Pampa("teste3");
        pampa2.acelerar(60);
        pampa2.frear(10);
        Assertions.assertEquals(50,pampa2.getVelocidade(),"Função frear incorreta");

    }
    @Test
    public void testeCacamba(){
        Pampa teste = new Pampa("teste1");
        if(teste.getVelocidade()==0){
            Assertions.assertTrue(teste.abrirCacamba(),"Caçamba pode ser aberta");
        }else{
            Assertions.assertFalse(teste.abrirCacamba(), "Caçamba não pode ser aberta carro em movimento");
        }

    }

    @Test
    public void testeTracao(){
        Pampa pampa3 = new Pampa("teste4");
        pampa3.acelerar(30);
        Assertions.assertFalse(pampa3.ativarDesativarTracao(),"Traçao nao alterada, carro está em movimento");

        Pampa pampa4 = new Pampa("teste5");
        Assertions.assertTrue(pampa4.ativarDesativarTracao(),"Tração ativada");

        pampa4.acelerar(30);
        pampa4.frear(30);
        Assertions.assertTrue(pampa4.ativarDesativarTracao(),"Tração desativada");
    }


}
