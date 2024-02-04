package poo;

/**
 * interface VeiculoAmfibio
 * herda de poo.VeiculoTerrestre e poo.VeiculoMarinho
 */
public interface VeiculoAnfibio extends VeiculoMarinho, VeiculoTerrestre {
    public boolean recolherRodas();

    public boolean abrirRodas();

}
