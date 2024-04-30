package Projeto;
import java.time.*;

/**
 * Classe Ciclismo
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão : Falta definir consumoCalorias
 */
public class Ciclismo extends AtivDistancia
{
    /**
     * Construtores de Ciclismo
     */
    
    /**
     * Construtor vazio
     */
    public Ciclismo()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public Ciclismo(LocalTime tempo, int freqCardiaca, double distancia)
    {
        super(tempo, freqCardiaca, distancia);
    }
    
    /**
     * Construtor de cópia
     */
    public Ciclismo(Ciclismo ciclismo)
    {
        super(ciclismo);
    }
    
    /**
     * Método que calcula o consumo de calorias de um treino de ciclismo
     *
     * @param  utilizador  utilizador que realiza o treino
     * @return    consumo de calorias do treino
     */
    public int consumoCalorias(Utilizador utilizador){
        return 0; //provisório
    }

    /**
     * Método toString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ciclismo:\nTempo: ");
        sb.append(this.getTempo().toString());
        sb.append("\nFrequência Cardíaca: ");
        sb.append(this.getFreqCardiaca());
        sb.append(" bpm\nDistância: ");
        sb.append(this.getDistancia());
        sb.append(" metros\n");
        return (sb.toString());
    }

    /**
     * Método equals
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if ((o==null)||(this.getClass()!=o.getClass())) return false;
        Ciclismo c = (Ciclismo) o;
        return (super.equals(c));
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        Ciclismo c = new Ciclismo(this);
        return c;
    }
}
