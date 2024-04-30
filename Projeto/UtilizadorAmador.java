package Projeto;
import java.time.LocalDate;

/**
 * Classe UtilizadorAmador - classe que engloba todos os utilizadores que sao atletas amadores.
 *
 * @author Grupo10
 * @version 27/04/24
 */
public class UtilizadorAmador extends Utilizador
{
    /**
     * Construtor parametrizado
     */
    public UtilizadorAmador(String nome, String morada, String email, int freqCardiaca, int peso, int altura, LocalDate dataNascimento, char genero)
    {
        super(nome,morada,email,freqCardiaca,peso,altura,dataNascimento,genero);
    }

    /**
     * Método que calcula o fator multiplicativo de um utilizador amador
     *
     * @param
     * @return    fatorMultiplicativo
     */
    public int getFatorMultiplicativo()
    {
        return 1 + getFreqCardiaca()/200;
    }
}
