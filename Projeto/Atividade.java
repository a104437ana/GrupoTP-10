package Projeto;
import java.time.*;


/**
 * Classe Atividade - classe abstrata que engloba os vários tipos de atividades desportivas
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão : Mudado tempo para LocalTime em vez de int
 */
public abstract class Atividade
{
    // variáveis de instância
    private LocalDateTime dataRealizacao; 
    private LocalTime tempo;
    private int freqCardiaca;

    /**
     * Construtores de Atividade
     *
     * Atividade é uma classe abstrata, logo, os construtores só vão ser invocados pelas suas sub-classes nos seus próprios construtores, e não para criar instâncias de Atividade
     */
    
    /**
     * Construtor vazio
     */
    public Atividade()
    {
        this.tempo = LocalTime.of(0,0);
        this.freqCardiaca = 0;
    }
    
    /**
     * Construtor parametrizado
     */
    public Atividade(LocalTime tempo, int freqCardiaca)
    {
        this.tempo = tempo;
        this.freqCardiaca = freqCardiaca;
    }
    
    /**
     * Construtor de cópia
     */
    public Atividade(Atividade umaAtividade)
    {
        this.tempo = umaAtividade.getTempo();
        this.freqCardiaca = umaAtividade.getFreqCardiaca();
    }
    
    // Getters e setters

    public LocalTime getTempo(){
        return this.tempo;
    }

    public int getFreqCardiaca(){
        return this.freqCardiaca;
    }

    public void setTempo(LocalTime tempo){
        this.tempo = tempo;
    }
    
    public void setFreqCardiaca(int freqCardiaca){
        this.freqCardiaca = freqCardiaca;
    }
    
    /**
     * Método que calcula o consumo de calorias de uma atividade, da maneira definida para essa atividade - deve ser implementado pelas sub-classes
     *
     * @param  utilizador  utilizador que realiza a atividade
     * @return    consumo de calorias da atividade
     */
    public abstract int consumoCalorias(Utilizador utilizador);

    /**
     * Método toString, deve ser implementado pelas sub-classes
     */
    public abstract String toString();

    /**
     * Método equals
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if ((o==null)||(this.getClass()!=o.getClass())) return false;
        Atividade a = (Atividade) o;
        return (((this.getTempo()).equals(a.getTempo()))&&(this.getFreqCardiaca()==a.getFreqCardiaca()));
    }

    /**
     * Método clone, deve ser implementado pelas sub-classes
     */
    public abstract Object clone();
}
