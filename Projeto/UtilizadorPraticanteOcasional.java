package Projeto;
import java.time.LocalDate;

/**
 * Classe UtilizadorPraticanteOcasional - classe que engloba todos os utilizadores que sao praticantes ocasionais.
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas Versão : --
 */
public class UtilizadorPraticanteOcasional extends Utilizador
{
    private static final double fatorMultiplicativo = 1.25;
    /**
     * Construtor parametrizado
     */
    public UtilizadorPraticanteOcasional(String nome, String morada, String email, int freqCardiaca, int peso, int altura, LocalDate dataNascimento, char genero)
    {
        super(nome,morada,email,freqCardiaca,peso,altura,dataNascimento,genero);
    }
    
    public UtilizadorPraticanteOcasional(UtilizadorPraticanteOcasional u) {
        super(u);
    }
    
    /**
     * Método que calcula o fator multiplicativo de um utilizador praticante ocasional
     *
     * @param
     * @return    fatorMultiplicativo
     */
    public double getFatorMultiplicativo()
    {
        return this.fatorMultiplicativo;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nTipo de Utilizador: Praticante Ocasional");
        return (sb.toString());
    }
    
    /**
     * Método clone
     */
    public Object clone(){
        UtilizadorPraticanteOcasional t = new UtilizadorPraticanteOcasional(this);
        return t;
    }
}
