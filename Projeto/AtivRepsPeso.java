package Projeto;


/**
 * Classe AtivRepsPeso - classe abstrata que engloba as atividades em que são feitas repetições de exercícios com pesos
 *
 * @author Grupo10
 * @version 20/04/24
 * Notas versão : Não compila, porque a classe Atividade não está acabada
 */
public abstract class AtivRepsPeso extends AtivRepetições
{
    // variáveis de instância
    private int peso;

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
        this.peso = 0;
    }

    /**
     * Construtor parametrizado
     */
    public AtivRepsPeso(int tempo, int freqCardiaca, int repetições, int peso)
    {
        super(tempo, freqCardiaca, repetições);
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

    /**
     * Getters e setters
     */

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
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
