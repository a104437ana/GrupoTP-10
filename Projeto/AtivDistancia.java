package Projeto;
import java.time.*;

/**
 * Classe AtivDistancia - classe abstrata que engloba as atividades em que é preciso saber a distância percorrida
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : --
 */
public abstract class AtivDistancia extends Atividade
{
    // variáveis de instância
    private double distancia;

    /**
     * Construtores de AtivDistancia
     *
     * AtivDistância é uma classe abstrata, logo, os construtores só vão ser invocados pelas suas sub-classes nos seus próprios construtores, e não para criar instâncias de AtivDistancia
     */
    
    /**
     * Construtor vazio
     */
    public AtivDistancia()
    {
        super();
        this.distancia = 0.0;
    }
    
    /**
     * Construtor parametrizado
     */
    public AtivDistancia(LocalTime tempo, int freqCardiaca, double distancia)
    {
        super(tempo, freqCardiaca);
        this.distancia = distancia;
    }
    
    /**
     * Construtor de cópia
     */
    public AtivDistancia(AtivDistancia umaAtivDistancia)
    {
        super(umaAtivDistancia);
        this.distancia = umaAtivDistancia.getDistancia();
    }
    
    //Getters e setters

    public double getDistancia(){
        return this.distancia;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    /**
     * Método que calcula o fator de intensidade pela velocidade a que é percorrida a distância
     * 
     * 
     * @param valorNulo velocidade para a qual o fator deve ser nulo
     * @param valorIncremento valor no qual uma unidade de velocidade aumenta o fator
     * @return fator de intensidade da velocidade a que é realizada a atividade
     */
    public double getFatorVelocidade(double valorNulo, double valorIncremento){
        double velocidade = this.distancia / this.getTempo().toSecondOfDay();
        return (velocidade - valorNulo) * valorIncremento;
    }

    /**
     * Método equals
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if ((o==null)||(this.getClass()!=o.getClass())) return false;
        AtivDistancia a = (AtivDistancia) o;
        return ((super.equals(a))&&(this.getDistancia()==a.getDistancia()));
    }
}
