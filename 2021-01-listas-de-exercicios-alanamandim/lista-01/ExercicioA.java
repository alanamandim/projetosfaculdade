import static java.lang.Double.parseDouble;

public class ExercicioA{
    public static void main(String[] args) {        
        double mediaProjetos;
        double mediaFinal;
        double mediaListas;
        double listas=1;
        double[] notas;
        notas = new double[10];
        double z1 = 3.0;
        double z2 = 4.0;
        double z3 = 2.0;
        int i=0;
    
        for(String argumentos: args){

            if(i<3){
                notas[i]=parseDouble(argumentos);

            }else{
                notas[i]=parseDouble(argumentos);
                listas*=notas[i];

            }
            i++;
        }

        mediaProjetos = Math.pow(notas[0],z1) * Math.pow(notas[1],z2) * Math.pow(notas[2],z3);
        mediaProjetos = Math.pow(mediaProjetos,(double)1/(z1+z2+z3));

        //listas = notas[3] * notas[4] * notas[5] * notas[6] * notas[7] * notas[8] * notas[9];
        mediaListas = (Math.pow(listas, (double) 1/7));

        System.out.println(mediaListas*0.1);
        System.out.println(mediaProjetos);
        mediaFinal = mediaListas*0.1 + mediaProjetos*0.9;

        System.out.println("Conceito final= " + mediaFinal);

        if (mediaFinal < 6){
            System.out.println("REPROVADO");
        }
        else{
            System.out.println("APROVADO");
        }
    }
}
    
