package Projeto;
import java.time.LocalDate;

/**
 * Classe UtilizadorProfissional - classe que engloba todos os utilizadores que sao atletas profissionais.
 *
 * @author Grupo10
 * @version 27/04/24
 */
public class UtilizadorProfissional extends Utilizador
{
    /**
     * Construtor parametrizado
     */
    public UtilizadorProfissional(String nome, String morada, String email, int freqCardiaca, int peso, int altura, LocalDate dataNascimento, char genero)
    {
        super(nome,morada,email,freqCardiaca,peso,altura,dataNascimento,genero);
    }

    /**
     * Método que calcula o fator multiplicativo de um utilizador profissional
     *
     * @param  
     * @return    fatorMultiplicativo
     */
    public int getFatorMultiplicativo()
    {
        return 2 + this.getFreqCardiaca()/200;
    }
}
