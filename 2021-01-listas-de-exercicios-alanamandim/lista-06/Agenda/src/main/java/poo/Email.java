package poo;

import java.util.HashMap;

public class Email {
    private HashMap<String, String>dados;
    private final String EMAIL_ER = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    public Email(){
        this.dados = new HashMap<>();
    }

    public boolean adiciona(String tipo, String email){
        if((!dados.containsKey(tipo))&& (email.matches(EMAIL_ER))){
            dados.put(tipo,email);
            return true;
        }
        return false;
    }

    public boolean deleta(String tipo){
        String email = dados.remove(tipo);

        if(email !=null){
            return true;
        }else{return false;}
    }

    public boolean modificacao(String tipo ,String email){
        if(email.matches(EMAIL_ER)) {
            String emailAntes = dados.replace(tipo, email);
            if (emailAntes != null) {
                return true;
            }
        }
        return false;

    }

    @Override

    public String toString(){
        StringBuilder texto = new StringBuilder();
        this.dados.forEach((tipo,email)->{
            texto.append(tipo+" : "+email+"\n");
        });

        return texto.toString();
    }
}
