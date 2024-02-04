package poo;

public class Book extends EntradadeDados {

    public Book(String nome,String author, String publisher, String title, String year) {
        super(nome);
        setAuthor(author);
        setPublisher(publisher);
        setTitle(title);
        setYear(year);
    }

    @Override
    public String toString() {

        StringBuilder texto = new StringBuilder();
        texto.append("@Book{" +getNome()+",\n"+
                "title={" + getTitle() + "},\n" +
                "author={" + getAuthor() + "},\n"+
                "year={" + getYear()  + "},\n"+
                "publisher={" + getPublisher() + "}");
        if(getAdress()!=null){
            texto.append(",\naddress={" + getAdress() + "}");
        }
        if(getEdition()!=null) {
            texto.append(",\nedition={" + getEdition() + "}");
        }
        if(getEditor()!=null){
            texto.append(",\neditor={" + getEditor() +"}" );
        }
        if(getMonth()!=null){
            texto.append(",\nmonth={"+getMonth()+"}");
        }
        if(getNumber()!=null) {
            texto.append(",\nnumber={" + getNumber() + "}");
        }
        if(getSeries()!=null) {
            texto.append(",\nseries={" + getSeries() + "}");
        }
        if(getVolume()!=null) {
            texto.append(",\nvolume={" + getVolume() + "}");
        }
        texto.append(" \n}\n\n");
        return texto.toString();

    }
}
