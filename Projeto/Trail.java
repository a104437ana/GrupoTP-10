package Projeto;
import java.time.*;

/**
 * Classe Trail
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : --
 */
public class Trail extends AtivDistAltimetria
{
    // variáveis de classe
    private static final double MET = 10;
    /**
     * Construtores de Trail
     */
    
    /**
     * Construtor vazio
     */
    public Trail()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public Trail(LocalTime tempo, int freqCardiaca, double distancia, double altimetria)
    {
        super(tempo, freqCardiaca, distancia, altimetria);
    }
    
    /**
     * Construtor de cópia
     */
    public Trail(Trail umTrail)
    {
        super(umTrail);
    }
    
    /**
     * Método que calcula o consumo de calorias de um trail
     *
     * @param  utilizador  utilizador que realiza o trail
     * @return    consumo de calorias do trail
     */
    public double consumoCalorias(Utilizador utilizador){
        double consumoCalorias = Trail.MET * (utilizador.getFatorMultiplicativo() + this.getFatorVelocidade(2.2, 0.22) + this.getFatorFreqCardiaca(utilizador) + this.getFatorAltimetria()) 
                                           * utilizador.getBMR() / (24 * 60 * 60)
                                           * this.getTempo().toSecondOfDay();
        return consumoCalorias;
    }

    /**
     * Método toString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nTipo de atividade: Trail");
        return (sb.toString());
    }

    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        Trail t = (Trail) o;
        return (super.equals(t));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        Trail t = new Trail(this);
        return t;
    }
}
