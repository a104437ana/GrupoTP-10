package Projeto;
import java.time.LocalDate;

/**
 * Classe UtilizadorProfissional - classe que engloba todos os utilizadores que sao atletas profissionais.
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas Versão : --
 */
public class UtilizadorProfissional extends Utilizador
{
    private static final double fatorMultiplicativo = 1.5;
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
    public double getFatorMultiplicativo()
    {
        return this.fatorMultiplicativo;
    }
}
