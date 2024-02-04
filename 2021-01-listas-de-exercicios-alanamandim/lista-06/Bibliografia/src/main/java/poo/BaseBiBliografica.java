package poo;

import java.util.ArrayList;
import java.util.Collections;


public class BaseBiBliografica<T extends EntradadeDados> {



    private ArrayList<T> entradadeDados;

    public BaseBiBliografica(){
        this.entradadeDados = new ArrayList<>();
    }

    public void adicionaArtigo(String nome, String author,String title, String journal, String year){
        Article article = new Article(nome,author,title,journal,year);
        entradadeDados.add((T) article);
    }

    public void adicionaMisc(String nome,String title){
        Misc misc = new Misc(nome,title);
        entradadeDados.add((T) misc);
    }

    public void adicionaBook(String nome,String author, String publisher, String title, String year){
        Book book = new Book(nome,author,publisher,title,year);
        entradadeDados.add((T) book);
    }

    public void adicionaMasterthesis(String nome, String autor, String title, String year){
        Masterthesis masterthesis = new Masterthesis(nome,autor,title,year);
        entradadeDados.add((T) masterthesis);
    }

    public void adicionaTechreport(String nome,String author, String institution, String title, String year){
        Techreport techreport = new Techreport(nome, author,institution,title,year);
        entradadeDados.add((T) techreport);

    }

    public ArrayList<T> getEntradadeDados() {
        return (ArrayList<T>) entradadeDados;
    }

    public void adicionaMes(int i,String month){entradadeDados.get(i).setMonth(month);}
    public void removeMonth(int i){entradadeDados.get(i).setMonth(null);}

    public int tamanhoEntradaDados(){
        return entradadeDados.size();
    }

    public String listaIndex(int i) {
            return ("Index: " + i +" "+ entradadeDados.get(i).getNome());
    }

    public void adicionaVolume(int i, String volume){entradadeDados.get(i).setVolume(volume);

    }
    public void removeVolume(int i){entradadeDados.get(i).setVolume(null);}

    public void adicionaAdress(int i, String adress){entradadeDados.get(i).setAdress(adress);
    }
    public void removeAdress(int i){entradadeDados.get(i).setAdress(null);}

    public void adicionaAuthor(int i, String author){
        entradadeDados.get(i).setAuthor(author);}
    public void removeAuthor(int i){entradadeDados.get(i).setAuthor(null);}

    public void adicionaEdition(int i,String edition){entradadeDados.get(i).setEdition(edition);}
    public void removeEdition(int i){entradadeDados.get(i).setEdition(null);}

    public void adicionaEditor(int i, String editor){entradadeDados.get(i).setEditor(editor);}
    public void removeEditor(int i){entradadeDados.get(i).setEditor(null);}


    public void adicionaNumber(int i, String number){entradadeDados.get(i).setNumber(number);}
    public void removeNumber(int i){entradadeDados.get(i).setNumber(null);}

    public void adicionaSeries(int i, String series){entradadeDados.get(i).setSeries(series);}
    public void removeSeries(int i){entradadeDados.get(i).setSeries(null);}


    public void adicionaPages(int i, String pages){entradadeDados.get(i).setPages(pages);}
    public void removePages(int i){entradadeDados.get(i).setPages(null);}

    public void adicionaInstitution(int i, String institution){entradadeDados.get(i).setInstitution(institution);}
    public void removeInstitution(int i){entradadeDados.get(i).setInstitution(null);}

    public void adicionaYear(int i, String year){entradadeDados.get(i).setYear(year);}
    public void removeYear(int i){entradadeDados.get(i).setYear(null);}

    public String listaBase(int i){
        Collections.sort(entradadeDados);
       return entradadeDados.get(i).toString();

    }
    public void removeEntradadeDados(int i){entradadeDados.remove(i);}
}
