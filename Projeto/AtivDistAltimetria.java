package Projeto;
import java.time.*;


/**
 * Classe AtivDistAltimetria - classe abstrata que engloba as atividades em que é preciso saber a distância percorrida e a altimetria
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão :
 */
public abstract class AtivDistAltimetria extends AtivDistância
{
    // variáveis de instância
    private double altitude;

    /**
     * Construtores de AtivDistAltimetria
     * 
     * AtivDistAltimetria é uma classe abstrata, logo, os construtores só vão ser invocados pelas suas sub-classes nos seus próprios construtores, e não para criar instâncias de AtivDistAltimetria
     */

    /**
     * Construtor vazio
     */
    public AtivDistAltimetria()
    {
        super();
        this.altitude = 0.0;
    }

    /**
     * Construtor parametrizado
     */
    public AtivDistAltimetria(LocalTime tempo, int freqCardiaca, double distancia, double altitude)
    {
        super(tempo, freqCardiaca, distancia);
        this.altitude = altitude;
    }

    /**
     * Construtor de cópia
     */
    public AtivDistAltimetria(AtivDistAltimetria umaAtivDistAltimetria)
    {
        super(umaAtivDistAltimetria);
        this.altitude = umaAtivDistAltimetria.getAltitude();
    }
    
    //Getters e setters

    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        AtivDistAltimetria a = (AtivDistAltimetria) o;
        return ((super.equals(a)) && (this.getAltitude() == a.getAltitude()));
    }
}
