package poo;

public class Article extends EntradadeDados {

    public Article(String nome, String author,String title, String journal, String year) {
        super(nome);
        setTitle(title);
        setAuthor(author);
        setJournal(journal);
        setYear(year);
    }

    @Override
    public String toString() {

        StringBuilder texto = new StringBuilder();
        texto.append("@article{" +getNome()+",\n"+
                "title= {" + getTitle() + "},\n" +
                "author= {" + getAuthor() + "},\n" +
                "year={" + getYear() + "} \n"+
                "journal={" + getJournal() + "}");

                if(getMonth()!=null) {
                    texto.append(",\nmonth={" + getMonth() + "}");
                }
                if(getNumber()!=null) {
                    texto.append(",\nnumber={" + getNumber() + "}");
                }
                 if(getPages()!=null) {
                     texto.append(",\npages={" + getPages() + "}");
                 }
                 if(getVolume()!=null) {
                     texto.append(",\nvolume={" + getVolume() + "}");
                 }
                 texto.append(" \n}\n\n");
                 return texto.toString();
    }
}
