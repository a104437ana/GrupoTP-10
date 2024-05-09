package Projeto;
import java.time.LocalDate;


/**
 * Classe Utilizador - classe abstrata que engloba os vários utilizadores da aplicação
 *
 * @author Grupo10
 * @version 27/04/24
 * Notas versão: --
 */
public abstract class Utilizador
{
    // variáveis de classe
    private static int proximoCodigo = 1;
    // variáveis de instância
    private int codUtilizador;
    private String nome;
    private String morada;
    private String email;
    private int freqCardiaca;
    private double peso;
    private int altura;
    private LocalDate dataNascimento;
    private char genero;
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
        this.peso = 0;
        this.altura = 0;
        this.dataNascimento = LocalDate.now();
        this.genero = 0;
    }

    /**
     * Construtor parametrizado
     */
    public Utilizador(String nome, String morada, String email, int freqCardiaca, int peso, int altura, LocalDate dataNascimento, char genero)
    {
        this.codUtilizador = proximoCodigo++;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.freqCardiaca = freqCardiaca;
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
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
        this.peso = umUtilizador.getPeso();
        this.altura = umUtilizador.getAltura();
        this.dataNascimento = umUtilizador.getDataNascimento();
        this.genero = umUtilizador.getGenero();
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

    public double getPeso() {
        return this.peso;
    }

    public int getAltura() {
        return this.altura;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public char getGenero() {
        return this.genero;
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

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Metodo que calcula a idade de um utilizador
     * 
     * @param utilizador
     * @return idade do utilizador
     */
    public int getIdade() {
        return LocalDate.now().getYear() - this.dataNascimento.getYear();
    }

    /**
     * Método que calcula o fator multiplicativo de um utilizador, utilizado no cálculo do consumo de calorias durante a realização de uma atividade
     *
     * @param  utilizador  utilizador
     * @return    fator multiplicativo do utilizador
     */
    public abstract double getFatorMultiplicativo();

    /**
     * Metodo que calcula o BMR - basal metabolic rate, calorias gastas num dia em repouso - de um utilizador, utilizado no calculo do consumo de calorias durante a realizaçao de uma atividade
     * 
     * @param utilizador utilizador
     * @return BMR do utilizador
     */
    public double getBMR() {
        double bmr = 0;
        char genero = this.getGenero();
        int s = genero == 'M' ? 5 : (genero == 'F' ? -161 : 0);
        bmr = 10*this.getPeso() + 6.25*this.getAltura() + 5*this.getIdade() + s;
        return bmr;
    }

}
