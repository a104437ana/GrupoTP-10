package Projeto;
import java.time.*;

/**
 * Classe AtivDistância - classe abstrata que engloba as atividades em que é preciso saber a distância percorrida
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão :
 */
public abstract class AtivDistância extends Atividade
{
    // variáveis de instância
    private double distância;

    /**
     * Construtores de AtivDistância
     *
     * AtivDistância é uma classe abstrata, logo, os construtores só vão ser invocados pelas suas sub-classes nos seus próprios construtores, e não para criar instâncias de AtivDistância
     */
    
    /**
     * Construtor vazio
     */
    public AtivDistância()
    {
        super();
        this.distância = 0.0;
    }
    
    /**
     * Construtor parametrizado
     */
    public AtivDistância(LocalTime tempo, int freqCardiaca, double distância)
    {
        super(tempo, freqCardiaca);
        this.distância = distância;
    }
    
    /**
     * Construtor de cópia
     */
    public AtivDistância(AtivDistância umaAtivDistância)
    {
        super(umaAtivDistância);
        this.distância = umaAtivDistância.getDistância();
    }
    
    //Getters e setters

    public double getDistância(){
        return this.distância;
    }

    public void setDistância(double distância){
        this.distância = distância;
    }
    
    /**
     * Método equals
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if ((o==null)||(this.getClass()!=o.getClass())) return false;
        AtivDistância a = (AtivDistância) o;
        return ((super.equals(a))&&(this.getDistância()==a.getDistância()));
    }
}
