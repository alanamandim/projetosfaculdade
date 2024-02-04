import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.*;

public class GrafoTeste {
    @Test
    public void testeAddEquipa(){
        Grafo grafo = new Grafo("rede","Teste");
        No internet = new No("wan", Equipamentos.INTERNET);
        grafo.adicionaNo(internet);

        Assertions.assertTrue(grafo.verificaNo("wan"));
    }

    @Test
    public void testeaddArco(){
        Grafo grafo = new Grafo("rede","Teste");
        No internet = new No("wan", Equipamentos.INTERNET);
        No router = new No("roteador",Equipamentos.ROUTERBLUE);
        No desktop = new No("desktop",Equipamentos.DESKTOP);
        No switchh = new No("switch",Equipamentos.SWITCH);
        grafo.adicionaNo(internet);
        grafo.adicionaNo(router);
        grafo.adicionaNo(desktop);
        grafo.adicionaNo(switchh);
        Arco a = new Arco("a","wan","roteador");
        Arco b = new Arco("b","roteador","desktop");
        Arco c = new Arco("c","desktop","switch");

        Assertions.assertTrue(grafo.adicionaArco(a));
        grafo.adicionaArco(b);
        Assertions.assertFalse(grafo.adicionaArco(c));


    }

    @Test
    public void testeRemoveArco(){
        Grafo grafo = new Grafo("rede","Teste");
        No internet = new No("wan", Equipamentos.INTERNET);
        No router = new No("roteador",Equipamentos.ROUTERBLUE);
        Arco a = new Arco("a","wan","roteador");
        grafo.adicionaArco(a);

        Assertions.assertTrue(grafo.deletaArco("a"));

    }

  
}
