package Projeto;
import java.time.*;

/**
 * Classe Ciclismo
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão : Falta definir consumoCalorias
 */
public class Ciclismo extends AtivDistância
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
    public Ciclismo(LocalTime tempo, int freqCardiaca, double distância)
    {
        super(tempo, freqCardiaca, distância);
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
        sb.append(this.getDistância());
        sb.append(" kilómetros\n");
        return (sb.toString());
    }

    /**
     * Método clone
     */
    public Object clone(){
        Ciclismo c = new Ciclismo(this);
        return c;
    }
}
