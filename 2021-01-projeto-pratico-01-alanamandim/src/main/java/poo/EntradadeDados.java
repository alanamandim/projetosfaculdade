package poo;

import java.util.ArrayList;

public abstract class EntradadeDados {

    private String nome;
    private  String title;
    private String month;
    private String author;
    private String year;
    private String volume;
    private String adress;
    private  String edition;
    private String editor;
    private String publisher;
    private String number;
    private String series;
    private String journal;
    private String pages;
    private String institution;

    public EntradadeDados(String nome) {this.nome = nome;}

    public void setInstitution(String institution) {this.institution = institution;}

    public String getInstitution() {return institution;}

    public void setPages(String pages) {this.pages = pages;}

    public String getPages() {return pages;}

    public void setJournal(String journal) {this.journal = journal;}

    public String getJournal() {return journal;}

    public void setSeries(String series) {this.series = series;}

    public String getSeries() {return series;}

    public void setNumber(String number) {this.number = number;}

    public String getNumber() {return number;}

    public void setPublisher(String publisher) {this.publisher = publisher;}

    public String getPublisher() {return publisher;}

    public void setEditor(String editor) {this.editor = editor;}

    public String getEditor() {return editor;}

    public String getAdress() {return adress;  }

    public void setAdress(String adress) {this.adress = adress;}

    public void setEdition(String edition) {this.edition = edition;}

    public String getEdition() {return edition; }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNome() {
        return nome;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }


    /* public String toString() {
        return "BaseBibliografica{" +
                "artigo=" + artigo.toString() +
                ", livro=" + livro +
                ", misc=" + misc +
                ", tese=" + tese +
                ", relatorio=" + relatorio +
                ", nome='" + nome + '\'' +
                '}';
    }*/
}
