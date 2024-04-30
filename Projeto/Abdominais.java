package Projeto;
import java.time.*;

/**
 * Classe Abdominais
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão : -- falta ver MET e calculaCalorias
 */
public class Abdominais extends AtivRepeticoes
{
    // variáveis de instância
    private static final int MET = 10;
    /**
     * Construtores de Abdominais
     */
    
    /**
     * Construtor vazio
     */
    public Abdominais()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public Abdominais(LocalTime tempo, int freqCardiaca, int repeticoes)
    {
        super(tempo, freqCardiaca, repeticoes);
    }
    
    /**
     * Construtor de cópia
     */
    public Abdominais(Abdominais abdominais)
    {
        super(abdominais);
    }
    
    /**
     * Método que calcula o consumo de calorias de uma série de abdominais
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
        sb.append("Abdominais\nTempo: ");
        sb.append(this.getTempo().toString());
        sb.append("\nFrequência Cardíaca: ");
        sb.append(this.getFreqCardiaca());
        sb.append(" bpm\nRepetições: ");
        sb.append(this.getRepeticoes());
        sb.append("\n");
        return (sb.toString());
    }
    
    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        Abdominais a = (Abdominais) o;
        return (super.equals(a));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        Abdominais a = new Abdominais(this);
        return a;
    }
}
