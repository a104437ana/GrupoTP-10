package Projeto;
import java.util.List;
import java.time.LocalDate;
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
    // variáveis de instância
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
        public AtividadeIteracoes clone() {
            AtividadeIteracoes c = new AtividadeIteracoes(this);
            return c;
        }
    }

    /**
     * Construtor vazio
     */
    public PlanoTreino()
    {
        this.dataRealizacao = LocalDate.now();
        this.atividades = new ArrayList<>();
    }

    /**
     * Construtor parameterizado
     */
    public PlanoTreino(LocalDate dataRealizacao)
    {
        this.dataRealizacao = dataRealizacao;
        this.atividades = new ArrayList<>();
    }

    /**
     * Construtor de cópia
     */
    public PlanoTreino(PlanoTreino planoTreino)
    {
        this.dataRealizacao = planoTreino.getDataRealizacao();
        this.atividades = planoTreino.getAtividades();
    }

    // Getters e setters
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

    public List<Atividade> atividadesQueRespeitamP(Predicate<Atividade> p) {
        List<Atividade> atividades = new ArrayList<Atividade>();
        for (AtividadeIteracoes atividadeIter : this.atividades) {
            int iteracoes = atividadeIter.getIteracoes();
            for (int i = 0; i < iteracoes; i++) {
                Atividade atividade = atividadeIter.getAtividade();
                if (p.test(atividade)) atividades.add((Atividade)atividade.clone());
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

    /**
     * Método compareTo
     */
    public int compareTo(PlanoTreino p){
        return this.dataRealizacao.compareTo(p.getDataRealizacao());
    }
    
    /**
     * clone
     */
    public PlanoTreino clone() {
        PlanoTreino c = new PlanoTreino(this);
        return c;
    }
}
