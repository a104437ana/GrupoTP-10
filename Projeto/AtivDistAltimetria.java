package Projeto;
import java.time.*;


/**
 * Classe AtivDistAltimetria - classe abstrata que engloba as atividades em que é preciso saber a distância percorrida e a altimetria
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão :
 */
public abstract class AtivDistAltimetria extends AtivDistancia
{
    // variáveis de instância
    private double altimetria;

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
        this.altimetria = 0.0;
    }

    /**
     * Construtor parametrizado
     */
    public AtivDistAltimetria(LocalTime tempo, int freqCardiaca, double distancia, double altimetria)
    {
        super(tempo, freqCardiaca, distancia);
        this.altimetria = altimetria;
    }

    /**
     * Construtor de cópia
     */
    public AtivDistAltimetria(AtivDistAltimetria umaAtivDistAltimetria)
    {
        super(umaAtivDistAltimetria);
        this.altimetria = umaAtivDistAltimetria.getAltimetria();
    }
    
    //Getters e setters

    public double getAltimetria() {
        return this.altimetria;
    }

    public void setAltimetria(double altimetria) {
        this.altimetria = altimetria;
    }

    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        AtivDistAltimetria a = (AtivDistAltimetria) o;
        return ((super.equals(a)) && (this.getAltimetria() == a.getAltimetria()));
    }
}
