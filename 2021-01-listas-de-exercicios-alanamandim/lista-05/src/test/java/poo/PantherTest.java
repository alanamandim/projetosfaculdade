import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Panther;

public class PantherTest {
    @Test
    public void testAcelerar(){
        //ArrayList<poo.Veiculo>veiculos = new ArrayList<>();
        Panther panther = new Panther("teste2");
        panther.acelerar(50);
        panther.acelerar(40);
        Assertions.assertEquals(90,panther.getVelocidade(),"Função acelerar incorreta");

    }

    @Test
    public void testFreia(){
        //ArrayList<poo.Veiculo>veiculos = new ArrayList<>();
        Panther panther1 = new Panther("teste3");
        panther1.frear(50);
        Assertions.assertEquals(0,panther1.getVelocidade(),"Função frear com zero de velocidade incorreta");

        Panther panther2 = new Panther("teste3");
        panther2.acelerar(60);
        panther2.frear(10);
        Assertions.assertEquals(50,panther2.getVelocidade(),"Função frear incorreta");

    }

    @Test
    public void testeRodaseLastro(){
        Panther panther8 = new Panther("testee");
        panther8.recolherRodas();
        Assertions.assertFalse(panther8.getRodasAbertas(),"as rodas estão fechando");
        Assertions.assertEquals(0,panther8.getLastroVazio(),"e esvaziando o lastro");
        panther8.abrirRodas();
        Assertions.assertTrue(panther8.getRodasAbertas(),"rodas abrem");

    }

    @Test
    public void testeTracao(){
        Panther panther3 = new Panther("teste4");
        panther3.acelerar(30);
        panther3.ativarDesativarTracao();
        Assertions.assertFalse(panther3.getTracao(),"Traçao nao alterada, carro está em movimento");

        Panther panther4 = new Panther("teste5");
        panther4.ativarDesativarTracao();
        Assertions.assertTrue(panther4.getTracao(),"Tração ativada");
        Assertions.assertTrue(panther4.getRodasAbertas()," e rodas abertas");

        panther4.acelerar(30);
        panther4.frear(30);
        panther4.ativarDesativarTracao();
        Assertions.assertFalse(panther4.getTracao(),"Tração desativada");

        panther4.recolherRodas();
        panther4.ativarDesativarTracao();
        Assertions.assertFalse(panther4.getTracao(),"traçao nao ativada com rodas fechadas");

    }


    @Test
    public void testeCapota(){
        Panther panther7 = new Panther("teste7");
        panther7.acelerar(40);
        panther7.abrirCapota();
        Assertions.assertFalse(panther7.getCapota(),"Teste capota acima da vel");
        panther7.frear(40);
        panther7.abrirCapota();
        Assertions.assertTrue(panther7.getCapota(), "teste  abrir capota  parado");
        panther7.fecharCapota();
        Assertions.assertFalse(panther7.getCapota(),"teste fechar capota parado");
        panther7.abrirCapota();
        panther7.acelerar(30);
        panther7.fecharCapota();
        Assertions.assertTrue(panther7.getCapota(),"teste fechar capota acima da vel");


    }

    @Test
    public void testeTemp(){
        Panther panther9 = new Panther("testeee");
        panther9.setTempRefri(40);
        Assertions.assertEquals(40,panther9.getTemp());
    }


}
