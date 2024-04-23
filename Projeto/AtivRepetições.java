package Projeto;
import java.time.*;


/**
 * Classe AtivRepetições - classe abstrata que engloba as atividades em que são feitas repetições de exercícios
 *
 * @author Grupo10
 * @version 23/04/24
 * Notas versão :
 */
public abstract class AtivRepetições extends Atividade
{
    // variáveis de instância
    private int repeticões;

    /**
     * Construtores de AtivRepetições
     * 
     * AtivRepetições é uma classe abstrata, logo, os construtores só vão ser invocados pelas suas sub-classes nos seus próprios construtores, e não para criar instâncias de AtivRepetições
     */

    /**
     * Construtor vazio
     */
    public AtivRepetições()
    {
        super();
        this.repeticões = 0;
    }

    /**
     * Construtor parametrizado
     */
    public AtivRepetições(LocalTime tempo, int freqCardiaca, int repeticões)
    {
        super(tempo, freqCardiaca);
        this.repeticões = repeticões;
    }

    /**
     * Construtor de cópia
     */
    public AtivRepetições(AtivRepetições umaAtivRepetições)
    {
        super(umaAtivRepetições);
        this.repeticões = umaAtivRepetições.getRepetições();
    }

    //Getters e setters
    
    public int getRepetições() {
        return this.repeticões;
    }

    public void setRepetições(int repeticões) {
        this.repeticões = repeticões;
    }

    /**
     * Método equals
     */
    public boolean equals(Object o) {
        if (this==o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        AtivRepetições a = (AtivRepetições) o;
        return ((super.equals(a)) && (this.getRepetições() == a.getRepetições()));
    }
}
