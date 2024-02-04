public class Rotores {

        private int velRot1;
        private int velRot2;
        private int velRot3;
        private int velRot4;



    public Rotores(){
        this.velRot1 = 0;
        this.velRot2 = 0;
        this.velRot3 = 0;
        this.velRot4 = 0;
    }

    public void setVelRot1(int velRot1) {
        this.velRot1 = velRot1;
    }

    public void setVelRot2(int velRot2) {
        this.velRot2 = velRot2;
    }

    public void setVelRot3(int velRot3) {
        this.velRot3 = velRot3;
    }

    public void setVelRot4(int velRot4) {
        this.velRot4 = velRot4;
    }

    public int getVelRot1() {
        return velRot1;
    }

    public int getVelRot2() {
        return velRot2;
    }

    public int getVelRot3() {
        return velRot3;
    }

    public int getVelRot4() {
        return velRot4;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append( "O rotor: 1 "+ "está com a rotação: "+ velRot1 +"\n"+
                "O rotor: 2 "+ "está com a rotação: "+ velRot2 +"\n"+
                "O rotor: 3 "+ "está com a rotação: "+ velRot3 +"\n"+
                "O rotor: 4 "+ "está com a rotação: "+ velRot4 +"\n");

        return sb.toString();
    }
}
