package Projeto;
import java.time.*;

/**
 * Classe LegPress
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : --
 */
public class LegPress extends AtivRepsPeso
{
    // variáveis de instância
    private static final double MET = 4;
    /**
     * Construtores de LegPress
     */
    
    /**
     * Construtor vazio
     */
    public LegPress()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public LegPress(LocalTime tempo, int freqCardiaca, int repeticoes, double peso)
    {
        super(tempo, freqCardiaca, repeticoes, peso);
    }
    
    /**
     * Construtor de cópia
     */
    public LegPress(LegPress legPress)
    {
        super(legPress);
    }
    
    /**
     * Método que calcula o consumo de calorias de uma série de leg press
     *
     * @param  utilizador  utilizador que realiza o treino
     * @return    consumo de calorias do treino
     */
    public int consumoCalorias(Utilizador utilizador){
        double consumoCalorias = this.MET * (utilizador.getFatorMultiplicativo() + this.getFatorRepeticoes(0.5, 0.2) + this.getFatorPeso(utilizador, 1, 0.2) + this.getFatorFreqCardiaca(utilizador)) 
                                          * utilizador.getBMR() / (24 * 60 * 60)
                                          * this.getTempo().toSecondOfDay();
        return (int) consumoCalorias;
    }

    /**
     * Método toString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Leg press\nTempo: ");
        sb.append(this.getTempo().toString());
        sb.append("\nFrequência Cardíaca: ");
        sb.append(this.getFreqCardiaca());
        sb.append(" bpm\nRepetições: ");
        sb.append(this.getRepeticoes());
        sb.append("\nPeso: ");
        sb.append(this.getPeso());
        sb.append(" kilos\n");
        return (sb.toString());
    }
    
    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        LegPress l = (LegPress) o;
        return (super.equals(l));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        LegPress l = new LegPress(this);
        return l;
    }
}
