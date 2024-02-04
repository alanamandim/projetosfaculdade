package poo;

public class Misc extends EntradadeDados {

   public Misc(String nome,String title) {
        super(nome);
        setTitle(title);
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        texto.append( "@Misc{" + getNome()+ ", \n"+
                "title={" + getTitle() + "}");
        if(getAuthor()!=null) {
            texto.append(",\nauthor={" + getAuthor() + "}");
        }
        if(getMonth()!=null) {
            texto.append(",\nmonth={" + getMonth() + "}");
        }
        if(getYear()!=null) {
            texto.append(",\nyear={" + getYear() + "}");
        }
        texto.append(" \n} \n \n");
        return texto.toString();
    }
}
