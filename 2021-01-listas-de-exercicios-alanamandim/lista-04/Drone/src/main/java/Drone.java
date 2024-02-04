import java.util.ArrayList;

public class Drone {

    final int velmax=100;
    final int velmin=50;

    private int bateria;
    private Camera camera;
    private Gps cordenadas;
    private Rotores rotor;

    public Drone( Camera camera, Gps cordenadas, Rotores motor){
        this.bateria=100;
        this.camera = camera;
        this.cordenadas = cordenadas;
        this.rotor = motor;

    }

    public boolean decolagem(){
        this.rotor.setVelRot1(velmax);
        this.rotor.setVelRot2(velmax);
        this.rotor.setVelRot3(velmax);
        this.rotor.setVelRot4(velmax);
        this.bateria -= 5;
        return true;

    }
    public boolean verficor(double des){
        if(this.cordenadas.getZ1()>=des){
            return true;
        }else{
            return false;
        }
    }

    public boolean movDrone(int escolha, double deslc) {
        switch (escolha) {
            //direita
            case 1:
                if (this.bateria > 10) {
                    this.rotor.setVelRot1(velmin);
                    this.rotor.setVelRot2(velmax);
                    this.rotor.setVelRot3(velmin);
                    this.rotor.setVelRot4(velmax);
                    this.cordenadas.setY1(Math.abs(this.cordenadas.getY1() + deslc));
                    this.bateria -= 5;
                    return true;
                }
                break;

            //esquerda
            case 2:
                if (this.bateria > 10) {
                    rotor.setVelRot1(velmax);
                    rotor.setVelRot2(velmin);
                    rotor.setVelRot3(velmax);
                    rotor.setVelRot4(velmin);
                    this.cordenadas.setY1(Math.abs(this.cordenadas.getY1() - deslc));
                    this.bateria -= 5;
                    return true;
                }
                break;
            //frente
            case 3:
                if (this.bateria > 10) {
                    rotor.setVelRot1(velmin);
                    rotor.setVelRot2(velmin);
                    rotor.setVelRot3(velmax);
                    rotor.setVelRot4(velmax);
                    this.cordenadas.setX1(Math.abs(this.cordenadas.getX1() + deslc));
                    this.bateria -= 5;
                    return true;
                }
                break;
            //trás
            case 4:
                if (this.bateria > 10) {
                    rotor.setVelRot1(velmax);
                    rotor.setVelRot2(velmax);
                    rotor.setVelRot3(velmin);
                    rotor.setVelRot4(velmin);
                    this.cordenadas.setX1(Math.abs(this.cordenadas.getX1() - deslc));
                    this.bateria -= 5;
                    return true;
                }
                break;

        }
        return false;
    }

    public boolean alterarAltiitude(int escolha,double deslc) {

        switch (escolha) {
            //sobe
            case 1:
                if (this.bateria > 10) {
                    this.cordenadas.setZ1(Math.abs(this.cordenadas.getZ1() + deslc));
                    this.bateria -= 5;
                    return true;
                }
            //desce
            case 2:
                if (this.bateria > 10) {
                        this.cordenadas.setZ1(Math.abs(this.cordenadas.getZ1() - deslc));
                        this.bateria -= 5;
                        return true;
                }
        }
        return false;
    }

    public String localAtual(){
        return this.cordenadas.toString();
    }

    public int getBateria() {
        return bateria;
    }

    //drone retorna para ponto inicial
    public boolean retorno(){
        this.cordenadas.setX1(this.cordenadas.getX0());
        this.cordenadas.setY1(this.cordenadas.getY0());
        this.cordenadas.setZ1(this.cordenadas.getZ0());
        return true;
    }

    public String gravaVideo(String video){
        String x = String.valueOf(this.cordenadas.getX1());
        String y = String.valueOf(this.cordenadas.getY1());
        String z = String.valueOf(this.cordenadas.getZ1());
        this.bateria -= 5;
        this.camera.capturaVideo(video + ".mp4 : Coordenadas (" + x + "," + y + "," + z + ")" + "\n");

        return camera.toString();
    }

    public String tiraFoto(String foto){
        String x = String.valueOf(this.cordenadas.getX1());
        String y = String.valueOf(this.cordenadas.getY1());
        String z = String.valueOf(this.cordenadas.getZ1());
        this.camera.tirarFoto(foto + ".png : Coordenadas (" + x + "," + y + "," + z + ")" + "\n");
        this.bateria -= 5;
        return camera.toString();
    }

    public void planoVoo( String [] movimentos) {

        for (int j = 0; j < movimentos.length; j += 2) {
            Double des = Double.parseDouble(movimentos[j]);
            String direcao = movimentos[j + 1];

            if (direcao.equals("Frente")) {
                movDrone(3, des);
            }
            if (direcao.equals("Atrás")) {
                movDrone(4, des);
            }
            if (direcao.equals("Direita")) {
                movDrone(1, des);
            }
            if (direcao.equals("Esquerda")) {
                movDrone(2, des);
            }
            if (direcao.equals("Cima")) {
                alterarAltiitude(1, des);
            }
            if (direcao.equals("Baixo")) {
                alterarAltiitude(2, des);
            }
        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Bateria : "+ this.getBateria() + "\n");
        sb.append(this.rotor.toString());
        return sb.toString();
    }





}
