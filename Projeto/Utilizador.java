package Projeto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;

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
    private Set<PlanoTreino> atividadesPlanoTreino;
    private Set<Atividade> atividadesIsoladas;

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
        this.atividadesPlanoTreino = new TreeSet<PlanoTreino>();
        this.atividadesIsoladas = new TreeSet<Atividade>();
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
        this.atividadesPlanoTreino = new TreeSet<PlanoTreino>();
        this.atividadesIsoladas = new TreeSet<Atividade>();
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
        this.atividadesPlanoTreino = new TreeSet<PlanoTreino>(); //cópia
        this.atividadesIsoladas = new TreeSet<Atividade>(); //cópia
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

    /* estao certas, mas fiz funcoes melhores embaixo, isto vai ser pa eliminar
    public List<PlanoTreino> planosTreinoEfetuados(LocalDate dataInicial, LocalDate dataFinal){
        List<PlanoTreino> pt = new ArrayList<PlanoTreino>();
        pt = this.atividadesPlanoTreino.stream().filter(b -> b.getDataRealizacao().compareTo(dataInicial) >= 0 && b.getDataRealizacao().compareTo(dataFinal) <= 0)
        .collect(Collectors.toList());
        return pt;
    }

    public List<Atividade> atividadesIsoladasEfetuadas(LocalDate dataInicial, LocalDate dataFinal){
        List<Atividade> at = new ArrayList<Atividade>();
        LocalDateTime data_inicial = LocalDateTime.of(dataInicial, LocalTime.MIDNIGHT);
        LocalDateTime data_final = LocalDateTime.of(dataFinal, LocalTime.MIDNIGHT);
        at = this.atividadesIsoladas.stream().filter(b -> b.getDataRealizacao().compareTo(data_inicial) >= 0 && b.getDataRealizacao().compareTo(data_final) <= 0)
        .collect(Collectors.toList());
        return at;
    }
    */
   
    /** 
     * Numero de calorias gastas pelo utilizador
     * Requisito 3.2
     * ponto 1
        */
    public double totalCaloriasDispendidas (LocalDate dataInicial, LocalDate dataFinal) {
        Predicate<Atividade> p = atividade -> true;
        Utilizador u = this;
        Function<Atividade,Integer> f = atividade -> atividade.consumoCalorias(u);
        List<Integer> calorias = infoDasAtividadesNumPeriodoQueRespeitamP(dataInicial, dataFinal, p, f);
        double total_calorias = calorias.stream().mapToInt(h -> h).sum();
        return total_calorias;
    }
   
    /** 
     * Numero de atividades do utilizador
     * Requisito 3.2
     * ponto 2
        */
    public int numeroAtividades (LocalDate dataInicial, LocalDate dataFinal) {
        Predicate<Atividade> p = atividade -> true;
        List<Atividade> atividades = atividadesNumPeriodoQueRespeitamP(dataInicial, dataFinal, p);
        return atividades.size();
    }
   
    /**
     * Requisito 3.2
     * ponto 4
        */
    public double allKmsDistancia (LocalDate dataInicial, LocalDate dataFinal) {
        Predicate<Atividade> p = atividade -> atividade instanceof AtivDistancia;
        Function<Atividade,Double> f = atividade -> ((AtivDistancia) atividade).getDistancia();
        List<Double> distancias = infoDasAtividadesNumPeriodoQueRespeitamP(dataInicial, dataFinal, p, f);
        double distancia_metros = distancias.stream().mapToDouble(h->h).sum();
        return distancia_metros/1000;
    }
    
    /**
     * Requisito 3.2
     * ponto 5
       */
    public double allMetrosAltimetria(LocalDate dataInicial, LocalDate dataFinal) {
        Predicate<Atividade> p = atividade -> atividade instanceof AtivDistAltimetria;
        Function<Atividade,Double> f = atividade -> ((AtivDistAltimetria) atividade).getAltimetria();
        List<Double> altimetrias = infoDasAtividadesNumPeriodoQueRespeitamP(dataInicial, dataFinal, p, f);
        return altimetrias.stream().mapToDouble(h->h).sum();
    }
      
    /**
     * Requisito 3.2
     * ponto 7
       */
    public List<Atividade> allAtividades(LocalDate dataInicial, LocalDate dataFinal){
        Predicate<Atividade> p = atividade -> true;
        List<Atividade> atividades = atividadesNumPeriodoQueRespeitamP(LocalDate.MIN,LocalDate.MAX,p);
        return atividades;
    }
    
    
    public <R> List<R> infoDasAtividadesNumPeriodoQueRespeitamP(LocalDate dataInicio, LocalDate dataFim, Predicate<Atividade> p, Function<Atividade,R> f){
        List<Atividade> atividades = atividadesNumPeriodoQueRespeitamP(dataInicio, dataFim, p);
        
        List<R> infoDasAtividades = new ArrayList<>();
        for(Atividade atividade: atividades) {
            infoDasAtividades.add(f.apply(atividade));
        }
        return infoDasAtividades;
    }
    
    public List<Atividade> atividadesNumPeriodoQueRespeitamP (LocalDate dataInicio, LocalDate dataFim, Predicate<Atividade> p){
        List<Atividade> atividades = new ArrayList<Atividade>();
        
        LocalDateTime data_inicial = LocalDateTime.of(dataInicio, LocalTime.MIDNIGHT);
        LocalDateTime data_final = LocalDateTime.of(dataFim, LocalTime.MIDNIGHT);
        
        List<Atividade> atividadesIsoladas = this.atividadesIsoladas
        .stream()
        .filter(atividade -> p.test(atividade) && atividade.getDataRealizacao().compareTo(data_inicial) >= 0 && atividade.getDataRealizacao().compareTo(data_final) <= 0)
        .collect(Collectors.toList());
        
        atividades.addAll(atividadesIsoladas);
        
        List<PlanoTreino> planosTreino = this.atividadesPlanoTreino
        .stream()
        .filter(planoTreino -> planoTreino.getDataRealizacao().compareTo(dataInicio) >= 0 && planoTreino.getDataRealizacao().compareTo(dataFim) <= 0)
        .collect(Collectors.toList());
        
        for(PlanoTreino planoTreino : planosTreino){
            
            List<Atividade> atividadesPlanoTreino = planoTreino.atividadesQueRespeitamP(p);
            
            atividades.addAll(atividadesPlanoTreino);
            
        }
        
        return atividades;
    }
    
    /**
     * Metodo que calcula a idade de um utilizador
     * 
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
    
    /**
     * Método toString
     */
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador\nCodigo de Utilizador: ");
        sb.append(this.codUtilizador);
        sb.append("\nNome: ");
        sb.append(this.nome);
        sb.append("\nMorada: ");
        sb.append(this.morada);
        sb.append("\nEmail: ");
        sb.append(this.email);
        sb.append("\nFrequencia Cardiaca: ");
        sb.append(this.freqCardiaca);
        sb.append(" bpm\nPeso: ");
        sb.append(this.peso);
        sb.append(" kilos\nAltura: ");
        sb.append(this.altura);
        sb.append(" centimetros\nData de nascimento ");
        sb.append(this.dataNascimento.format(formatter));
        sb.append("\nIdade: ");
        sb.append(this.getIdade());
        sb.append(" anos\nGenero: ");
        sb.append(this.genero);
        return (sb.toString());
    }
    
    /**
     * Método equals
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if ((o==null)||(this.getClass()!=o.getClass())) return false;
        Utilizador a = (Utilizador) o;
        return ((this.codUtilizador == (a.getCodUtilizador()))
        && (this.nome == (a.getNome()))
        && (this.morada == (a.getMorada()))
        && (this.email == (a.getEmail()))
        && (this.freqCardiaca == (a.getFreqCardiaca()))
        && (this.peso == (a.getPeso()))
        && (this.altura == (a.getAltura()))
        && ((this.dataNascimento).equals(a.getDataNascimento()))
        && (this.genero == (a.getGenero())));
    }
    
    /**
     * Método clone, deve ser implementado pelas sub-classes
     */
    public abstract Object clone();
}
