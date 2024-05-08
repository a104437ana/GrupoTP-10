package Projeto;
import java.time.*;


/**
 * Classe AtivRepsPeso - classe abstrata que engloba as atividades em que são feitas repetições de exercícios com pesos
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão :
 */
public abstract class AtivRepsPeso extends AtivRepeticoes
{
    // variáveis de instância
    private double peso;

    /**
     * Construtores de AtivRepsPeso
     * 
     * AtivRepsPeso é uma classe abstrata, logo, os construtores só vão ser invocados pelas suas sub-classes nos seus próprios construtores, e não para criar instâncias de AtivRepsPeso
     */

    /**
     * Construtor vazio
     */
    public AtivRepsPeso()
    {
        super();
        this.peso = 0.0;
    }

    /**
     * Construtor parametrizado
     */
    public AtivRepsPeso(LocalTime tempo, int freqCardiaca, int repeticoes, double peso)
    {
        super(tempo, freqCardiaca, repeticoes);
        this.peso = peso;
    }

    /**
     * Construtor de cópia
     */
    public AtivRepsPeso(AtivRepsPeso umaAtivRepsPeso)
    {
        super(umaAtivRepsPeso);
        this.peso = umaAtivRepsPeso.getPeso();
    }
    
    //Getters e setters

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        AtivRepsPeso a = (AtivRepsPeso) o;
        return ((super.equals(a)) && (this.getPeso() == a.getPeso()));
    }
}
