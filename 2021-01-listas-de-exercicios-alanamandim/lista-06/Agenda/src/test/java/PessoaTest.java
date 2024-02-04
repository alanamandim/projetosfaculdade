
import org.junit.jupiter.api.Assertions;
import poo.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    private Pessoa pessoa;
    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;

    ArrayList<Pessoa> pessoass;

    @Test
    public void testePessoa() {
        this.pessoass = new ArrayList<>();

        pessoa = new Pessoa("Alana", "Mandim", LocalDate.of(1994, 05, 10));
        pessoa1 = new Pessoa("Ana", "Mandim", LocalDate.of(1966, 01, 31));
        pessoa2 = new Pessoa("Alana", "Silva", LocalDate.of(2000, 04, 10));
        pessoa3 = new Pessoa("Alana", "Mandim", LocalDate.of(1994, 05, 10));

        pessoass.add(pessoa);
        pessoass.add(pessoa1);
        pessoass.add(pessoa2);
        pessoass.add(pessoa3);

          Assertions.assertEquals(0,pessoa.compareTo(pessoa3),"teste com pessoas iguais");
          Assertions.assertEquals(-2,pessoa.compareTo(pessoa1),"teste com pessoas diferentes");
          Assertions.assertEquals(-6,pessoa.compareTo(pessoa2),"teste sobrenome diferente");


    }
}
