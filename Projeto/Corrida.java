package Projeto;
import java.time.*;

/**
 * Classe Corrida
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão : --
 */
public class Corrida extends AtivDistância
{
    // variáveis de instância
    private static final int MET = 8;
    /**
     * Construtores de Corrida
     */
    
    /**
     * Construtor vazio
     */
    public Corrida()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public Corrida(LocalTime tempo, int freqCardiaca, double distância)
    {
        super(tempo, freqCardiaca, distância);
    }
    
    /**
     * Construtor de cópia
     */
    public Corrida(Corrida umaCorrida)
    {
        super(umaCorrida);
    }
    
    /**
     * Método que calcula o consumo de calorias de uma corrida
     *
     * @param  utilizador  utilizador que realiza a corrida
     * @return    consumo de calorias da corrida
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
        sb.append("Corrida:\nTempo: ");
        sb.append(this.getTempo().toString());
        sb.append("\nFrequência Cardíaca: ");
        sb.append(this.getFreqCardiaca());
        sb.append(" bpm\nDistância: ");
        sb.append(this.getDistância());
        sb.append(" kilómetros\n");
        return (sb.toString());
    }

    /**
     * Método equals
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if ((o==null)||(this.getClass()!=o.getClass())) return false;
        Corrida c = (Corrida) o;
        return (super.equals(c));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        Corrida c = new Corrida(this);
        return c;
    }
}
