package Projeto;
import java.time.LocalDate;

/**
 * Classe UtilizadorPraticanteOcasional - classe que engloba todos os utilizadores que sao praticantes ocasionais.
 *
 * @author Grupo10
 * @version 27/04/24
 */
public class UtilizadorPraticanteOcasional extends Utilizador
{
    /**
     * Construtor parametrizado
     */
    public UtilizadorPraticanteOcasional(String nome, String morada, String email, int freqCardiaca, int peso, int altura, LocalDate dataNascimento, char genero)
    {
        super(nome,morada,email,freqCardiaca,peso,altura,dataNascimento,genero);
    }

    /**
     * Método que calcula o fator multiplicativo de um utilizador praticante ocasional
     *
     * @param
     * @return    fatorMultiplicativo
     */
    public int getFatorMultiplicativo()
    {
        return getFreqCardiaca()/200;
    }
}
