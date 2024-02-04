package poo;

import java.util.ArrayList;

public class Principal {

    public BaseBiBliografica base[];
  public void criaBase(int i){
            base = new BaseBiBliografica[i];
            for(int j=0;j<i;j++){
                base[j] = new BaseBiBliografica();
            }
       System.out.printf("Criada");
   }

   public void adicionaArtigonaBase(int id,String nome, String author,String title, String journal, String year) {
       base[id].adicionaArtigo( nome, author,title, journal, year);
   }

  public void adicionaMiscnaBase(int id,String nome, String title) {
        base[id].adicionaMisc(nome,title);

   }

   public void adiconaMasterthesisnaBase(int id,String nome, String autor, String title, String year ){
       base[id].adicionaMasterthesis(nome,autor,title,year);
   }

   public void adicionaTechreportnaBase(int id,String nome,String author, String institution, String title, String year){
       base[id].adicionaTechreport(nome,author,institution,title,year);
   }
   public void adicionaBooknaBase(int id,String nome,String author, String publisher, String title, String year){
       base[id].adicionaBook(nome,author,publisher,title,year);
   }

   public void listabases(){
      int j=base.length;
      for(int i=0;i<j;i++){
          if(base[i]==null){
              j--;
          }
      }
      System.out.println("Existem um total de : "+ j+" bases ");

   }
   public void excluiBase(int id){
      base[id]=null;
   }
   public void listaEntradadeDadosdaBase(int id){
       System.out.println("Base: "+id+"\n");
       int i=base[id].tamanhoEntradaDados();
       for(int j=0;j<i;j++)
       System.out.println(base[id].listaBase(j));
       //System.out.println(base[id].getEntradadeDados());
   }

   public void adicionames(int id,int index,String month){
      base[id].adicionaMes(index,month);
   }
   public void removeMoth(int id, int index){base[id].removeMonth(index);}

   public void listaindex(int id) {
       int i = base[id].tamanhoEntradaDados();
       for (int j = 0; j < i; j++) {
           System.out.println(base[id].listaIndex(j));
       }
   }

   public void adicionavolume(int id, int index, String volume){
      base[id].adicionaVolume(index,volume);
   }
   public void removeVolume(int id, int index){base[id].removeVolume(index);}

   public void adicinaAdress(int id, int index, String adress){base[id].adicionaAdress(index, adress);}
    public void removeAdress(int id, int index){base[id].removeAdress(index);}

   public void adicionaAutor(int id, int index, String author){
      base[id].adicionaAuthor(index,author);
   }
   public void removeAuthor(int id, int index){base[id].removeAuthor(index);}

   public void adcionaYear(int id, int index, String year){base[id].adicionaYear(index, year);}
   public void removeYear(int id, int index){base[id].removeYear(index);}

    public void adicionaEdition(int id, int index, String edition){ base[id].adicionaEdition(index, edition);}
    public void removeEdition(int id, int index){base[id].removeEdition(index);}

    public void adicionaEditor(int id, int index, String editor){base[id].adicionaEditor(index,editor);}
    public void removeEditor(int id, int index){base[id].removeEditor(index);}

    public  void adicionaNumber(int id, int index, String number){base[id].adicionaNumber(index, number);}
    public void removeNumber(int id, int index){base[id].removeNumber(index);}

    public void adicionaSeries(int id, int index, String series){base[id].adicionaSeries(index, series);}
    public void removeSeries(int id, int index){base[id].removeSeries(index);}


    public void adicionaPages(int id, int index, String pages){ base[id].adicionaPages(index, pages);}
    public void removePages(int id, int index){base[id].removePages(index);}

    public void adicionaInstitution(int id, int index, String institution){base[id].adicionaInstitution(index,institution);}
    public void removeInstitution(int id, int index){base[id].removeInstitution(index);}

    public void removeEntradadeDados(int id, int index){base[id].removeEntradadeDados(index);}




    public static void main(String[] args) {

        Principal p =new Principal();

        //cria um numero informado de  bases bibliograficas
        p.criaBase(2);

        //adicona artigo na base informada
        p.adicionaArtigonaBase(0,"primeiro","alana","teste","allday","2021");
        p.adicionaArtigonaBase(1,"segundo","alanaa","testee","alldayy","20211");

        //adiciona o Misc na base informada
        p.adicionaMiscnaBase(0,"terceiro", "testemisc");
        p.adicionaMiscnaBase(1,"quarto","seg");

        //adiciona Masterthesis na base informada
        p.adiconaMasterthesisnaBase(0,"quinto","alanaB","continua","2022");
        p.adiconaMasterthesisnaBase(1,"sexto", "alanabr","faltapouco","2030");

        //adiciona Techreport na base informada
        p.adicionaTechreportnaBase(0,"setimo", "alanabrm","ifsc","boraaa","2025");
        p.adicionaTechreportnaBase(1,"oitavo","alanabrma","ufsc","acabando","2029");


        //adicona Book na base informada
        p.adicionaBooknaBase(0,"nono","brmalana","naosei","faltamaisum","2019");
        p.adicionaBooknaBase(1,"decimo","bralana","thelast","finish","2018");


        //lista as bases
        p.listabases();

        //lista todas as entradas de dados de cada base informada
        p.listaEntradadeDadosdaBase(0);
        p.listaEntradadeDadosdaBase(1);

        //lista os index das entradas de dados com seus respectivos nomes
        System.out.println("entrada de dados base 0 ");
        p.listaindex(0);
        System.out.println("Entrada de dados base 1");
        p.listaindex(1);


        //adiciona itens opcionais na base informada e no index passado da entrada de dados
        p.adicionames(0,0,"maio");
        p.adicionavolume(0,4,"oitavo");
        p.adicinaAdress(1,3,"www");
        p.adicionaInstitution(0,3,"IFSC");
        p.adcionaYear(1,2,"2031");
        p.adicionaPages(0,0,"80");
        p.adicionaAutor(1,0,"Steven");
        p.adicionaEdition(0,4,"3 edição");
        p.adicionaEditor(1,4,"aurora");
        p.adicionaNumber(0,0,"5");
        p.adicionaSeries(1,4,"seis");


        //lista as entradas de dados com seus respectivos index
        p.listaEntradadeDadosdaBase(0);
        p.listaEntradadeDadosdaBase(1);


        //remove as entradas de dados dos itens opcionais
        p.removeMoth(0,0);
        p.removeVolume(0,4);
        p.removeAdress(1,3);
        p.removeInstitution(0,3);
        p.removeYear(1,2);
        p.removePages(0,0);
        p.removeAuthor(1,0);
        p.removeEdition(0,4);
        p.removeEditor(1,4);
        p.removeNumber(0,0);
        p.removeSeries(1,4);

        //lista as entradas de dados das bases
        p.listaEntradadeDadosdaBase(0);
        p.listaEntradadeDadosdaBase(1);

        //remove a entrada de dados informada da base informada
        p.removeEntradadeDados(0,0);

        //lista as entradas de dados das bases
        p.listaEntradadeDadosdaBase(0);
        p.listaEntradadeDadosdaBase(1);

        //excluir base
        p.excluiBase(0);
        p.listabases();




    }


}
