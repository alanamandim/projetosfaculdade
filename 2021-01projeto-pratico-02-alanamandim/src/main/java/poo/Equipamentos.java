package poo;

import java.io.Serializable;

public enum Equipamentos implements Serializable {
    DESKTOP("img/desktop.png",0,1),
    FIREWALL("img/firewall.png",2,15),
    ROUTERGREEN("img/green-router.png",2,15),
    ROUTERBLUE("img/blue-router.png",2,15),
    SWITCH("img/switch.png",1,15),
    CAMERAIP("img/ip-camera.png",0,1),
    SERVIDOR("img/rack-server.png",0,1),
    INTERNET("img/cloud.png",1,15);

    public String figura;
    public int qtdMin;
    public int qtdMax;


    Equipamentos(String fig,int min, int max){
        this.figura = fig;
        this.qtdMin = min;
        this.qtdMax = max;

    }



}
