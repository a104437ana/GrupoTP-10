package Projeto;
import java.time.*;

/**
 * Classe Abdominais
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : --
 */
public class Abdominais extends AtivRepeticoes
{
    // variáveis de classe
    private static final double MET = 3;
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
        double consumoCalorias = this.MET * (utilizador.getFatorMultiplicativo() + this.getFatorRepeticoes(1, 0.2) + this.getFatorFreqCardiaca(utilizador)) 
                                          * utilizador.getBMR() / (24 * 60 * 60)
                                          * this.getTempo().toSecondOfDay();
        return (int) consumoCalorias;
    }

    /**
     * Método toString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nTipo de atividade: Abdominais");
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
