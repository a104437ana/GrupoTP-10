package Projeto;
import java.time.*;

/**
 * Classe Trail
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão : --
 */
public class Trail extends AtivDistAltimetria
{
    // variáveis de instância
    private static final int MET = 10;
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
    public Trail(LocalTime tempo, int freqCardiaca, double distancia, double altitude)
    {
        super(tempo, freqCardiaca, distancia, altitude);
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
    public int consumoCalorias(Utilizador utilizador){
        double consumoCalorias = this.MET * utilizador.getFatorMultiplicativo() * utilizador.getBMR() * this.getTempo().toSecondOfDay() / (24 * 60 * 60);
        return (int) consumoCalorias;
    }

    /**
     * Método toString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Trail\nTempo: ");
        sb.append(this.getTempo().toString());
        sb.append("\nFrequência Cardíaca: ");
        sb.append(this.getFreqCardiaca());
        sb.append(" bpm\nDistância: ");
        sb.append(this.getDistancia());
        sb.append(" metros\nAltitude: ");
        sb.append(this.getAltitude());
        sb.append(" metros\n");
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
        Trail c = new Trail(this);
        return c;
    }
}
