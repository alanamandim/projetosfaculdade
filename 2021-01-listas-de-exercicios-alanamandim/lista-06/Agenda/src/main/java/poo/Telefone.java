package poo;

import java.text.ParseException;
import java.util.HashMap;
import javax.swing.text.MaskFormatter;

public class Telefone {

    private HashMap<String, String> dados;

    public Telefone() {
        this.dados = new HashMap<>();
    }

    public String formatacao( String numero){
        String formato ="";

        try {
            MaskFormatter mask = new MaskFormatter("(##) ####-####");
            mask.setValueContainsLiteralCharacters(false);
            mask.setPlaceholderCharacter(' ');
            formato = mask.valueToString(numero);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return formato;
    }

    public boolean adiciona(String tipo, String numero) {
        String num = formatacao(numero);
        if (dados.containsKey(tipo)) {
            return false;
        }
        dados.put(tipo, num);
        return true;
    }

    public boolean deleta(String tipo) {
        String numero = dados.remove(tipo);
        if (numero != null) {
            return true;
        }else{return false;}
    }

    public boolean modifica(String tipo, String numero){
        String num=formatacao(numero);
        String numeroAntes = dados.replace(tipo,num);
        if(numeroAntes!= null){
            return true;
        }else{ return false;}
    }




    @Override
    public String toString(){
        StringBuilder texto = new StringBuilder();
        this.dados.forEach((tipo,numero)-> {
            texto.append(tipo + " : " + numero + "\n");
        });
        return texto.toString();
        }
}

