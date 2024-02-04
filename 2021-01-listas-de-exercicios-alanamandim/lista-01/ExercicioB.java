import java.util.Scanner;

public class ExercicioB {
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);

        while(info.hasNext()){
            String linha = info.nextLine();
            String [] stringSeparada = linha.split(" ");
            double listas = 1;
            double mediaProjetos = 1;
            double mediaFinal;
            mediaProjetos= Math.pow(Double.parseDouble(stringSeparada[1]),3.0)* Math.pow(Double.parseDouble(stringSeparada[2]),4.0) * Math.pow(Double.parseDouble(stringSeparada[3]),2.0);
            mediaProjetos = Math.pow(mediaProjetos,(double)1/9);
            
            for(int i =4; i < stringSeparada.length; i++){
                    listas *= Double.parseDouble(stringSeparada[i]);
                }

            listas = Math.pow(listas,(double) 1/7);
            mediaFinal = mediaProjetos*0.9 + listas*0.1;

            if (mediaFinal <6) {
                System.out.println(stringSeparada[0] + " : " + mediaFinal + " " +  "REPROVADO");
             }
            else {
                System.out.println(stringSeparada[0] + " : " + mediaFinal + " " +  "APROVADO");
            }

        }
    }
}