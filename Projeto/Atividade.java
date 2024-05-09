package Projeto;
import java.time.*;
import java.io.*;


/**
 * Classe Atividade - classe abstrata que engloba os vários tipos de atividades desportivas
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : --
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
     * Método que calcula um fator de intensidade pela razão entre a frequência cardíaca a que é feita a atividade e a frequência cardíaca normal
     * 
     * @param utilizador utilizador que realiza a atividade
     * @return fator de intensidade da frequência cardíaca realizada durante a atividade
     */
    public double getFatorFreqCardiaca(Utilizador utilizador){
        double razaoFreqCardiaca = utilizador.getFreqCardiaca() / this.freqCardiaca;
        return (razaoFreqCardiaca - 2) * 0.4; //cada unidade da razão aumenta o fator em 0.4
    }

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
