package poo;

public class Masterthesis extends EntradadeDados {

    public Masterthesis(String nome, String autor, String title, String year) {
        super(nome);
        setAuthor(autor);
        setTitle(title);
        setYear(year);
    }

    @Override
    public String toString() {


        StringBuilder texto = new StringBuilder();
        texto.append("@Masterthesis{" +getNome()+",\n"+
                "title= {" + getTitle() + "},\n" +
                "year={" + getYear() + "}");

        if(getMonth()!=null) {
            texto.append(",\nmonth={" + getMonth() + "}");
        }
        if(getAdress()!=null) {
            texto.append(",\naddress={" + getAdress() + "}");
        }
        texto.append(" \n}\n\n");
        return texto.toString();
    }

}
