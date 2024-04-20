package Projeto;


/**
 * Classe Utilizador - classe que engloba os vários utilizadores da aplicação
 *
 * @author Grupo10
 * @version 20/04/24
 * Notas versão: --
 */
public class Utilizador
{
    // variáveis de instância
    private int codUtilizador;
    private String nome;
    private String morada;
    private String email;
    private int freqCardiaca;
//    private Map<String,List<PlanoDeTreino>> atividadesEfetuadas;

    /**
     * Construtores de Utilizador
     */

    /**
     * Construtor vazio
     */
    public Utilizador()
    {
        this.codUtilizador = 0;
        this.nome = "";
        this.morada = "";
        this.email = "";
        this.freqCardiaca = 0;
    }

    /**
     * Construtor parametrizado
     */
    public Utilizador(int codUtilizador, String nome, String morada, String email, int freqCardiaca)
    {
        this.codUtilizador = codUtilizador;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.freqCardiaca = freqCardiaca;
    }

    /**
     * Construtor de cópia
     */
    public Utilizador(Utilizador umUtilizador)
    {
        this.codUtilizador = umUtilizador.getCodUtilizador();
        this.nome = umUtilizador.getNome();
        this.morada = umUtilizador.getMorada();
        this.email = umUtilizador.getEmail();
        this.freqCardiaca = umUtilizador.getFreqCardiaca();
    }

    /**
     * Getters e setters
     */

    public int getCodUtilizador() {
        return this.codUtilizador;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public String getEmail() {
        return this.email;
    }

    public int getFreqCardiaca() {
        return this.freqCardiaca;
    }

    public void setCodUtilizador(int codUtilizador) {
        this.codUtilizador = codUtilizador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFreqCardiaca(int freqCardiaca) {
        this.freqCardiaca = freqCardiaca;
    }

    /**
     * Método que calcula o fator multiplicativo de um utilizador, utilizado no cálculo do consumo de calorias durante a realização de uma atividade
     *
     * @param  utilizador  utilizador
     * @return    fator multiplicativo do utilizador
     */
    public int fatorMultiplicativo() {
        return 1;
    }
}
