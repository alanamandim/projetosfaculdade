package auditor;

import pack.IAUD;
import pack.IMON;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Jogo implements IAUD, IMON {
    private int id = 0;
    private Robo robo;
    private Robo robo1;
    private final Tabuleiro tabuleiro;
    private Bandeira bandeira1;
    private Bandeira bandeira2;
    private Bandeira bandeira3;
    private int vez;
    public int movi=0;
    public int idcapt=0;


    public Jogo(){
        this.tabuleiro = new Tabuleiro();
        this.bandeira1 = new Bandeira(6,3);
        this.bandeira2 = new Bandeira(3,3);
        this.bandeira3 = new Bandeira(0,3);
        // this.robo = new Robo();
    }


    @Override
    public int logar() throws RemoteException {
        if(this.id<2){
            id++;
            //this.robo = new Robo(id);
            if(id==1) {
                this.robo = new Robo(id);
            }
            if(id==2){
                this.robo1 = new Robo(id);
            }
            return id;

        }
        return 0;
    }

    @Override
    public boolean jogar() throws RemoteException {
        if(id==2){
            this.vez=1;
            return true;
        }
        return false;
    }

    @Override
    public boolean terminar() throws RemoteException {
        int j=0;
        for(int i=1;i<4;i++){
            if(escolheBandeira(i).getCapturado()){
                j++;
            };
            if(j==3){
                return false;
            }
        }
        return true;
    }
    public boolean verificaid(int idd){
        if(idd==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean verificamovimento(int id, String mov) throws RemoteException {
        if (Objects.equals(mov, "frente")) {
            if (verificaid(id)) {
                if (tabuleiro.verificaMov(robo.getX(), robo.getY()+1)) {
                    robo.setY((int) (robo.getY() + 1));
                    movi++;
                    return true;
                }

                // return tabuleiro.verificaMov((robo.getX() + 1), robo.getY());
            } else {
                if (tabuleiro.verificaMov(robo1.getX() , robo1.getY()-1)) {
                    robo1.setY(robo1.getY() - 1);
                    movi++;
                    return true;
                }
                return false;

            }
        }

        if (Objects.equals(mov, "direita")) {
            if (verificaid(id)) {
                if (tabuleiro.verificaMov((robo.getX()+1), robo.getY() )) {
                    robo.setX((int) (robo.getX() + 1));
                    movi++;
                    return true;
                }
            } else {
                if (tabuleiro.verificaMov(robo1.getX()-1, robo1.getY())) {
                    robo1.setX((int) (robo1.getX() - 1));
                    movi++;
                    return true;
                }

            }
            return false;
        }

        if (Objects.equals(mov, "esquerda")) {
            if (verificaid(id)) {
                if (tabuleiro.verificaMov((robo.getX()-1), robo.getY())) {
                    robo.setX((int) (robo.getX() - 1));
                    movi++;
                    return true;
                }
            } else {
                if (tabuleiro.verificaMov(robo1.getX()+1, robo1.getY())) {
                    robo1.setX((int) (robo1.getX() + 1));
                    movi++;
                    return true;
                }

            }return false;
        }
        if (Objects.equals(mov, "trás")) {
            if (verificaid(id)) {
                if (tabuleiro.verificaMov(robo.getX(), robo.getY()-1 )) {
                    robo.setY(robo.getY() - 1);
                    movi++;
                    return true;
                }
            } else {
                if (tabuleiro.verificaMov(robo1.getX(), robo1.getY()+1)) {
                    robo1.setY(robo1.getY() + 1);
                    movi++;
                    return true;
                }

            }
        }
        return false;

    }



    @Override
    public boolean bandeiraCapturada(double x, double y,int id) {
        if (x == bandeira1.getX() && y == bandeira1.getY()) {
            bandeira1.setCapturado();
            computabandeira(id);
            return bandeira1.getCapturado();
        }
        if(x == bandeira2.getX() && y == bandeira2.getY()){
            bandeira2.setCapturado();
            computabandeira(id);
            return bandeira2.getCapturado();
        }
        if(x == bandeira3.getX() && y == bandeira3.getY()){
            bandeira3.setCapturado();
            computabandeira(id);
            return bandeira3.getCapturado();
        }
        return false;
    }
    public void computabandeira(int id){
        if(verificaid(id)){
            robo.setBandeira();
        }else{
            robo1.setBandeira();
        }
    }



    @Override
    public int getvez() throws RemoteException {
        return vez;
    }

    @Override
    public void setvez(int vez) throws RemoteException {
        this.vez=vez;
    }

    @Override
    public double getX(int id) throws RemoteException {
        if (verificaid(id)) {
            return robo.getX();
        } else {
            return robo1.getX();
        }
    }

    @Override
    public double getY(int id) throws RemoteException {
        if (verificaid(id)) {
            return robo.getY();
        } else {
            return robo1.getY();
        }
    }

    /*@Override
    public int getBandeira(int id) throws RemoteException {
        if( verificaid(id)) {
            return robo.getBandeira();
        }else{
            return robo1.getBandeira();
        }
    }*/

    public int getVez() {
        return vez;
    }

    public void setVez(int vez) {
        this.vez = vez;
    }
    public Bandeira escolheBandeira(int var1 ){
        if(var1==1){
            return bandeira1;
        }
        if(var1==2){
            return bandeira2;
        }else{
            return bandeira3;
        }

    }


    @Override
    public double getBandeirasX(int var1) throws RemoteException {
        return escolheBandeira(var1).getX();

    }

    @Override
    public double getBandeirasY(int var1) throws RemoteException {
       return escolheBandeira(var1).getY();
    }

    @Override
    public boolean bandeiraCapturada(int var1) throws RemoteException {
        return escolheBandeira(var1).getCapturado();

    }



  /*   @Override
   public int getid() throws RemoteException {
       //verificar
        return robo.getId();
    }*/

    @Override
    public int getdiimensao() throws RemoteException {
        return (int) tabuleiro.getDimensaoX();
    }

    @Override
    public int getmov() throws RemoteException {
        return movi;
    }

    @Override
    public void informacaptura(int id) throws RemoteException {
        idcapt=id;

    }

    public int  verificacapt() throws RemoteException{
        return idcapt;
    }

    @Override
    public void setidcapt() throws RemoteException {
        idcapt=0;

    }
    public String informavencedor() {
        int x = robo.getBandeira();
        int y = robo1.getBandeira();
        if (x > y) {
            return ("O robo 1 capturou : " + robo.getBandeira() + "bandeiras\n" + "O robo 2 capturou : " + robo1.getBandeira() + " bandeiras\n" + " O robo 1 venceu a partida");
        } else {
            return ("O robo 1 capturou : " + robo.getBandeira() + "bandeiras\n" + "O robo 2 capturou : " + robo1.getBandeira() + " bandeiras\n" + " O robo 2 venceu a partida");
        }
    }

    public void reinicia() throws RemoteException, InterruptedException {
        TimeUnit.SECONDS.sleep(6);
        for(int k=1;k<4;k++){
            escolheBandeira(k).setCapturado1();
            this.bandeira1 = new Bandeira(6,3);
            this.bandeira2 = new Bandeira(3,3);
            this.bandeira3 = new Bandeira(0,3);
            robo.setX(0);
            robo.setY(0);
            robo.setBandeira();

            robo1.setX(6);
            robo1.setY(6);
            robo1.setBandeira1();
            id=0;

        }
    }
    public String vencedor() {
        int x = robo.getBandeira();
        int y = robo1.getBandeira();
        if (x > y) {
            return ("O robo 1 venceu a partida");

        }else {
            return ("O robo 2 venceu a partida");
        }
    }

}
