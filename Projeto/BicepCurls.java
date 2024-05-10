package Projeto;
import java.time.*;

/**
 * Classe BicepCurls
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : --
 */
public class BicepCurls extends AtivRepsPeso
{
    // variáveis de classe
    private static final double MET = 4;
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
    public BicepCurls(LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, int repeticoes, double peso)
    {
        super(realizacao, tempo, freqCardiaca, repeticoes, peso);
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
    public double consumoCalorias(Utilizador utilizador){
        double consumoCalorias = BicepCurls.MET * (utilizador.getFatorMultiplicativo() + this.getFatorRepeticoes(0.5, 0.4) + this.getFatorPeso(utilizador, 0.2, 0.4) + this.getFatorFreqCardiaca(utilizador)) 
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
        sb.append("\nTipo de atividade: BicepCurls");
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
