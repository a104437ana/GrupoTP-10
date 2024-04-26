package Projeto;
import java.time.*;

/**
 * Classe Btt
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão : --
 */
public class Btt extends AtivDistAltimetria
{
    // variáveis de instância
    private static final int MET = 10;
    /**
     * Construtores de Btt
     */
    
    /**
     * Construtor vazio
     */
    public Btt()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public Btt(LocalTime tempo, int freqCardiaca, double distância, double altitude)
    {
        super(tempo, freqCardiaca, distância, altitude);
    }
    
    /**
     * Construtor de cópia
     */
    public Btt(Btt btt)
    {
        super(btt);
    }
    
    /**
     * Método que calcula o consumo de calorias de um treino de BTT
     *
     * @param  utilizador  utilizador que realiza o treino
     * @return    consumo de calorias do treino
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
        sb.append("BTT\nTempo: ");
        sb.append(this.getTempo().toString());
        sb.append("\nFrequência Cardíaca: ");
        sb.append(this.getFreqCardiaca());
        sb.append(" bpm\nDistância: ");
        sb.append(this.getDistância());
        sb.append(" kilómetros\nAltitude: ");
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
        Btt b = (Btt) o;
        return (super.equals(b));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        Btt c = new Btt(this);
        return c;
    }
}
