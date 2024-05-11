package Projeto;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.io.*;

/**
 * Classe PlanoTreino, que engloba as várias atividades realizadas por um utilizador numa dada altura
 * 
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : Falta adicionar atividades
 */
public class PlanoTreino implements Comparable<PlanoTreino>, Serializable
{   
    // variáveis de classe
    private static int proximoCodigo = 1;
    // variáveis de instância
    private int codPlano;
    private LocalDate dataRealizacao;
    private List<AtividadeIteracoes> atividades;

    /**
     * Classe AtividadeIteracoes, classe auxiliar para armazenar iterações de atividades
     */
    class AtividadeIteracoes {
        //variáveis de instância
        private int iteracoes;
        private Atividade atividade;
    
        /**
         * Construtor parameterizado
         */
        public AtividadeIteracoes(int iteracoes, Atividade atividade){
            this.iteracoes = iteracoes;
            this.atividade = atividade;
        }
        
        public AtividadeIteracoes(AtividadeIteracoes a) {
            this.iteracoes = a.getIteracoes();
            this.atividade = a.getAtividade();
        }
    
        public int getIteracoes(){
            return this.iteracoes;
        }
    
        public Atividade getAtividade(){
            return (Atividade) this.atividade.clone();
        }
    
        public void setIteracoes(int iteracoes){
            this.iteracoes = iteracoes;
        }
    
        public void setAtividade(Atividade atividade){
            this.atividade = (Atividade)atividade.clone();
        }
        
        /**
         * clone
         */
        public Object clone() {
            AtividadeIteracoes c = new AtividadeIteracoes(this);
            return c;
        }

        /**
         * Método equals
         */
        public boolean equals(Object o){
            if (this==o) return true;
            if ((o==null)||(this.getClass()!=o.getClass())) return false;
            AtividadeIteracoes a = (AtividadeIteracoes) o;
            return (this.getIteracoes()==a.getIteracoes()&&this.getAtividade().equals(a.getAtividade()));
        }
    }

    /**
     * Construtor vazio
     */
    public PlanoTreino()
    {
        this.codPlano = 0;
        this.dataRealizacao = LocalDate.now();
        this.atividades = new ArrayList<>();
    }

    /**
     * Construtor parameterizado
     */
    public PlanoTreino(LocalDate dataRealizacao)
    {
        this.codPlano = PlanoTreino.proximoCodigo++;
        this.dataRealizacao = dataRealizacao;
        this.atividades = new ArrayList<>();
    }

    /**
     * Construtor de cópia
     */
    public PlanoTreino(PlanoTreino planoTreino)
    {
        this.codPlano = planoTreino.getCodPlano();
        this.dataRealizacao = planoTreino.getDataRealizacao();
        this.atividades = planoTreino.getAtividades();
    }
    
    public PlanoTreino(PlanoTreino planoTreino, LocalDate inicio, LocalDate fim) {
        this.dataRealizacao = planoTreino.getDataRealizacao();
        this.atividades = planoTreino.getAtividadesNumPeriodo(inicio,fim);
    }

    // Getters e setters
    public List<AtividadeIteracoes> getAtividadesNumPeriodo(LocalDate inicio, LocalDate fim) {
        LocalDateTime i2 = LocalDateTime.of(inicio, LocalTime.MIDNIGHT);
        LocalDateTime f2 = LocalDateTime.of(fim, LocalTime.MIDNIGHT);
        List<AtividadeIteracoes> atividades = new ArrayList<AtividadeIteracoes>();
        for(AtividadeIteracoes a : this.atividades) {
            if (a.getAtividade().getDataRealizacao().compareTo(i2) >= 0 && a.getAtividade().getDataRealizacao().compareTo(f2) <= 0) atividades.add((AtividadeIteracoes) a.clone());
        }
        return atividades;
    }
    public int getCodPlano(){
        return this.codPlano;
    }
    
    public List<AtividadeIteracoes> getAtividades() {
        List<AtividadeIteracoes> atividades = new ArrayList<AtividadeIteracoes>();
        for(AtividadeIteracoes a : this.atividades) {
            atividades.add((AtividadeIteracoes) a.clone());
        }
        return atividades;
    }
    
    public LocalDate getDataRealizacao(){
        return this.dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao){
        this.dataRealizacao = dataRealizacao;
    }

    public List<Atividade> atividadesQueRespeitamP(LocalDate ii, LocalDate f, Predicate<Atividade> p) {
        LocalDateTime i2 = LocalDateTime.of(ii, LocalTime.MIDNIGHT);
        LocalDateTime f2 = LocalDateTime.of(f, LocalTime.MIDNIGHT);
        List<Atividade> atividades = new ArrayList<Atividade>();
        for (AtividadeIteracoes atividadeIter : this.atividades) {
            int iteracoes = atividadeIter.getIteracoes();
            for (int i = 0; i < iteracoes; i++) {
                Atividade atividade = atividadeIter.getAtividade();
                if (p.test(atividade) && atividade.getDataRealizacao().compareTo(i2) >= 0 && atividade.getDataRealizacao().compareTo(f2) <= 0) atividades.add((Atividade)atividade.clone());
            }
        }
        return atividades;
    }
    
    /**
     * Método caloriasDispendidas que calcula o total de calorias dispendidas num plano de treino
     * 
     * @param utilizador utilizador que realiza o plano de treino
     * @return calorias dispendidas durante o plano de treino
     */
    public double caloriasDispendidas(Utilizador utilizador){
        double calorias = 0;
        for (AtividadeIteracoes a : this.atividades) {
            calorias += a.getIteracoes() * a.getAtividade().consumoCalorias(utilizador);
        }
        return calorias;
    }
    
    public void addAtividade(Atividade atividade, int iteracoes){
        AtividadeIteracoes adicionar = new AtividadeIteracoes(iteracoes,(Atividade) atividade.clone());
        this.atividades.add(adicionar);
    }

    public List<PlanoTreino> geraPlanoTreino(Utilizador utilizador, List<Atividade> atividades, int maxAtivDia, int ativPorSemana, double consumoCaloricoMinimo, LocalDate inicio){
        List<PlanoTreino> planos = new ArrayList<PlanoTreino>();
        return planos;
    }

    /**
     * Método compareTo
     */
    public int compareTo(PlanoTreino p){
        return this.dataRealizacao.compareTo(p.getDataRealizacao());
    }
    
    /**
     * clone
     */
    public Object clone() {
        PlanoTreino c = new PlanoTreino(this);
        return c;
    }
    
    public Object planoTreinoNumPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        PlanoTreino t = new PlanoTreino (this, dataInicio, dataFim);
        return t;
    }
}
