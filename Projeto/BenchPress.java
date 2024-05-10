package Projeto;
import java.time.*;

/**
 * Classe BenchPress
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : --
 */
public class BenchPress extends AtivRepsPeso
{
    // variáveis de classe
    private static final double MET = 4;
    /**
     * Construtores de BenchPress
     */
    
    /**
     * Construtor vazio
     */
    public BenchPress()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public BenchPress(LocalTime tempo, int freqCardiaca, int repeticoes, double peso)
    {
        super(tempo, freqCardiaca, repeticoes, peso);
    }
    
    /**
     * Construtor de cópia
     */
    public BenchPress(BenchPress benchPress)
    {
        super(benchPress);
    }
    
    /**
     * Método que calcula o consumo de calorias de uma série de bench press
     *
     * @param  utilizador  utilizador que realiza o treino
     * @return    consumo de calorias do treino
     */
    public double consumoCalorias(Utilizador utilizador){
        double consumoCalorias = BenchPress.MET * (utilizador.getFatorMultiplicativo() + this.getFatorRepeticoes(0.25, 0.2) + this.getFatorPeso(utilizador, 0.5, 0.2) + this.getFatorFreqCardiaca(utilizador)) 
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
        sb.append("\nTipo de atividade: Bench press");
        return (sb.toString());
    }
    
    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        BenchPress b = (BenchPress) o;
        return (super.equals(b));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        BenchPress b = new BenchPress(this);
        return b;
    }
}
