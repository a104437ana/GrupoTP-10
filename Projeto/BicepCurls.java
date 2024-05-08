package Projeto;
import java.time.*;

/**
 * Classe BicepCurls
 *
 * @author Grupo10
 * @version 08/05/24
 * Notas versão : -- falta ver MET e calculaCalorias
 */
public class BicepCurls extends AtivRepsPeso
{
    // variáveis de instância
    private static final int MET = 10;
    /**
     * Construtores de BicepCurls
     */
    
    /**
     * Construtor vazio
     */
    public BicepCurls()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public BicepCurls(LocalTime tempo, int freqCardiaca, int repeticoes, double peso)
    {
        super(tempo, freqCardiaca, repeticoes, peso);
    }
    
    /**
     * Construtor de cópia
     */
    public BicepCurls(BicepCurls bicepCurls)
    {
        super(bicepCurls);
    }
    
    /**
     * Método que calcula o consumo de calorias de uma série de bicep curls
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
        sb.append("Bicep curls\nTempo: ");
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
        BicepCurls b = (BicepCurls) o;
        return (super.equals(b));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        BicepCurls b = new BicepCurls(this);
        return b;
    }
}
