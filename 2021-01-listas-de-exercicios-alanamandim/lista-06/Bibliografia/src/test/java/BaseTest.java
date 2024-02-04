import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.Article;
import poo.Misc;


public class BaseTest {

    @Test
    public void testCompareto(){
        Article artigo = new Article ("primeiro", "alana", "teste", "allday", "2021");
        Article artigo1 = new Article("segundo","alanaa","testee","alldayy","20211");
        Misc misc = new Misc("terceiro", "testemisc");
        Misc mis1 = new Misc("quarto","seg");

        Assertions.assertEquals(-3,artigo.compareTo(artigo1));
        Assertions.assertEquals(-1,artigo.compareTo(mis1));
        Assertions.assertEquals(-4,artigo.compareTo(misc));


    }
}
