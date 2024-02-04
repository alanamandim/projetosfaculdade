package poo;

public class Techreport extends EntradadeDados {

    public Techreport(String nome,String author, String institution, String title, String year) {
        super(nome);
        setAuthor(author);
        setInstitution(institution);
        setTitle(title);
        setYear(year);
    }


    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        texto.append("@Techreport{" +getNome()+",\n"+
                "author={" + getAuthor() + "},\n" +
                "institution={" + getInstitution() + "},\n" +
                "title={" + getTitle() +"},\n" +
                "year='" + getYear() + "}");
        if(getAdress()!=null){
            texto.append(",\naddress={" + getAdress() + "}" );
        }
        if(getMonth()!=null){
            texto.append(",\nmonth={" + getMonth() + "}");
        }
        texto.append(" \n}\n\n");
        return texto.toString();
    }
}
