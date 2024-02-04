import java.util.ArrayList;

public class Camera {

    private ArrayList<String>foto;
    private ArrayList<String>video;

    public Camera(){
        this.foto = new ArrayList<>();
        this.video = new ArrayList<>();
    }

    public void tirarFoto(String retrato){
        this.foto.add(retrato);
    }

    public void capturaVideo(String capvideo){
        this.video.add(capvideo);
    }

    @Override
    public String toString(){
        StringBuilder tira = new StringBuilder();

        tira.append("\n"+ "Fotos tiradas: "+ foto);
        tira.append(("\n"+ "Vídeos gravados: "+ video));
        return tira.toString();
    }
}
