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
    // variáveis de classe
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
    public LegPress(LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, int repeticoes, double peso)
    {
        super(realizacao, tempo, freqCardiaca, repeticoes, peso);
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
    public double consumoCalorias(Utilizador utilizador){
        double consumoCalorias = LegPress.MET * (utilizador.getFatorMultiplicativo() + this.getFatorRepeticoes(0.5, 0.2) + this.getFatorPeso(utilizador, 1, 0.2) + this.getFatorFreqCardiaca(utilizador)) 
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
        sb.append("\nTipo de atividade: Leg press");
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
