package poo;

/**
 * Enum para guardar as posições inicias e suas respectivas imagens
 */
public enum Pecas {
    RAINHABRANCA("qw.png",3.0,0.0),
    REIBRANCA("kw.png",4.0,0.0),
    TORREBRANCA("tw.png",0.0,0.0),
    BISPOBRANCA("bw.png",2.0,0.0),
    CAVALOBRANCA("hw.png",1.0,0.0),
    PEAOBRANCA("pw.png",0.0,1.0),

    RAINHAPRETA("Qb.png",3.0,7.0),
    REIPRETA("Kb.png",4.0,7.0),
    TORREPRETA("Tb.png",0.0,7.0),
    BISPOPRETA("Bb.png",2.0,7.0),
    CAVALOPRETA("Hb.png",1.0,7.0),
    PEAOPRETA("Pb.png",0.0,6.0);

    public String figura;
    public double x;
    public double y;

    Pecas(String fig, double x,double y){
        this.figura = fig;
        this.x = x;
        this.y = y;
    }

}
