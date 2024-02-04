public class Principal {
    public static void main(String[] args) {
        //criação do rack e máquinas reais
        Rack rack = new Rack();

        MaquinaReal maq = new MaquinaReal(2500, 16, "maquina1");
        MaquinaReal maq1 = new MaquinaReal(3500, 32, "maquina2");
        MaquinaReal maq2 = new MaquinaReal(1500, 8, "maquina3");
        MaquinaReal maq3 = new MaquinaReal(4500, 12, "maquina4");
        MaquinaReal maq4 = new MaquinaReal(1000, 8, "maquina5");
        MaquinaReal maq5 = new MaquinaReal(7000, 64, "maquina6");

        //adicionando máquinas reais ao rack
        if (rack.adicionaMaqReal(maq)) {
            System.out.println("Máquina adicianada!");
        } else {
            System.out.println("Rack está cheio, não foi possível adicionar.");
        }

        if (rack.adicionaMaqReal(maq1)) {
            System.out.println("Máquina adicianada!");
        } else {
            System.out.println("Rack está cheio, não foi possível adicionar.");
        }

        if (rack.adicionaMaqReal(maq2)) {
            System.out.println("Máquina adicianada!");
        } else {
            System.out.println("Rack está cheio, não foi possível adicionar.");

        }

        if (rack.adicionaMaqReal(maq3)) {
            System.out.println("Máquina adicianada!");
        } else {
            System.out.println("Rack está cheio, não foi possível adicionar.");
        }

        if (rack.adicionaMaqReal(maq4)) {
            System.out.println("Máquina adicianada!");
        } else {
            System.out.println("Rack está cheio, não foi possível adicionar.");
        }
        //essa nao sera possível adicionar
        if (rack.adicionaMaqReal(maq5)) {
            System.out.println("Máquina adicianada!");
        } else {
            System.out.println("Rack está cheio, não foi possível adicionar.");
        }

        //adicionando mv
        if (maq.adicionaMaqVirtual(10, 1, "mv1")){
            System.out.println("Maquina Virtual adicionada!");
        }else{
            System.out.println("Não foi possível adicionar a maquina virtual");
        }

        if (maq1.adicionaMaqVirtual(10, 1, "mv2")){
            System.out.println("Maquina Virtual adicionada!");
        }else{
            System.out.println("Não foi possível adicionar a maquina virtual");
        }

        if (maq2.adicionaMaqVirtual(10, 1, "mv3")){
            System.out.println("Maquina Virtual adicionada!");
        }else{
            System.out.println("Não foi possível adicionar a maquina virtual");
        }

        if (maq3.adicionaMaqVirtual(10, 1, "mv4")){
            System.out.println("Maquina Virtual adicionada!");
        }else{
            System.out.println("Não foi possível adicionar a maquina virtual");
        }

        //Printando o rack com as máquinas adicionadas
        System.out.println(rack);

        //liga mv
        if(maq1.ligarMaqVirtual("mv2")!=0){
            System.out.println(maq1);
        }

        //desliga mv
        if(maq1.desligarMaqVirtual("mv2")!=1){
            System.out.println(maq1);
        }
        //remoção de mv
        if(maq2.removeMaqVirtual("mv3")){
            System.out.println("Maquina virtual removida com sucesso");
        }else{
            System.out.println("Não foi possível a remoção da maquina virtual");
        }

        //Printando servidor com remoção
        System.out.println(maq2);





    }
}
