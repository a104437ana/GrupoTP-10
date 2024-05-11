package Projeto;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.*;
import java.util.stream.Collectors;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Classe GestorDesportivo, que corresponde à lógica de negócio da aplicação / model
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão :
 */
public class GestorDesportivo implements Serializable
{
    private LocalDate dataAtual;
    private Map<Integer, Utilizador> utilizadores;
    
    public GestorDesportivo(){
        this.dataAtual = LocalDate.now();
        this.utilizadores = new HashMap<Integer, Utilizador>();
    }
    
    public void guardaEstado(String nome) throws IOException {
        FileOutputStream file = new FileOutputStream(nome);
        ObjectOutputStream oos = new ObjectOutputStream(file);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    } 
    
    public GestorDesportivo carregaEstado(String nome) throws ClassNotFoundException, IOException {
        FileInputStream file = new FileInputStream(nome);
        ObjectInputStream ois = new ObjectInputStream(file);
        GestorDesportivo model = (GestorDesportivo) ois.readObject();
        ois.close();
        return (model);
    }

    public List<Utilizador> infoNumPeriodo (LocalDate dataInicio, LocalDate dataFim) {
        List<Utilizador> utilizadores = new ArrayList<Utilizador>();
        for (Utilizador u : this.utilizadores.values()) {
            utilizadores.add((Utilizador) u.utilizadorNumPeriodo(dataInicio,dataFim));
        }
        return utilizadores;
    }
        /**
     * Requisitos 3.2
     * ponto 6
     */
    public PlanoTreino planoTreinoMaisCalorias (LocalDate dataInicio, LocalDate dataFim) {
        double maxCal = 0;
        PlanoTreino b = null;
        for (Utilizador u : this.utilizadores.values()) {
            PlanoTreino a = u.planoTreinoMaisCalorias(dataInicio, dataFim);
            if (a.caloriasDispendidas(u) >= maxCal) {
                b = a;
                maxCal = a.caloriasDispendidas(u);
            }
        }
        return b;
    }
    
    /**
     * Requisitos 3.2
     * ponto 3
     */
    public String atividadeMaisRealizada (LocalDate dataAtual) {
        List<Atividade> atividades = new ArrayList<Atividade>();
        Predicate<Atividade> p = atividade -> true;
        this.utilizadores.values().forEach(u -> atividades.addAll(u.atividadesNumPeriodoQueRespeitamP(LocalDate.MIN, dataAtual, p)));
        
        Map<String,Integer> tipoAtividadeQuantidade = new HashMap<>();
        
        for (Atividade atividade : atividades) {
            String tipo = atividade.getClass().getSimpleName();
            tipoAtividadeQuantidade.put(tipo, tipoAtividadeQuantidade.getOrDefault(tipo, 0) + 1);
        }
        
        String atividadeMaisRealizada = null;
        int contagemMaisFrequente = 0;
        
        for (Map.Entry<String, Integer> entry : tipoAtividadeQuantidade.entrySet()) {
            if (entry.getValue() >= contagemMaisFrequente) {
                atividadeMaisRealizada = entry.getKey();
                contagemMaisFrequente = entry.getValue();
            }
        }

        return atividadeMaisRealizada;
    }
    
    /** 
     * Utilizador com mais atividades
     * Requisito 3.2
     * ponto 2
    */
    public Utilizador maisAtividades (LocalDate dataInicial, LocalDate dataFinal) {
         return (Utilizador) this.utilizadores.values().stream().reduce((u1, u2) -> u1.numeroAtividades(dataInicial,dataFinal) > u2.numeroAtividades(dataInicial,dataFinal) ? u1 : u2).orElse(null).clone();
    }
    
    /**
     * Método maisCaloriasGastas, que calcula qual utilizador dispendeu mais calorias num período ou desde sempre
     * Requisito 3.2
     * ponto 1
    */
    public Utilizador maisCaloriasGastas(LocalDate dataInicial, LocalDate dataFinal) {
        return (Utilizador) this.utilizadores.values().stream().reduce((u1, u2) -> u1.totalCaloriasDispendidas(dataInicial,dataFinal) > u2.totalCaloriasDispendidas(dataInicial,dataFinal) ? u1 : u2).orElse(null).clone();
    }
    
    
    public int addUtilizador(String nome, String morada, String email, int freqCardiaca, int peso, int altura, LocalDate dataNascimento, char genero, int tipo){
         Utilizador novoUtilizador;
         if(tipo==1){
             novoUtilizador = new UtilizadorAmador(nome, morada, email, freqCardiaca, peso, altura, dataNascimento, genero);
         }
         else if(tipo==3){
             novoUtilizador = new UtilizadorProfissional(nome, morada, email, freqCardiaca, peso, altura, dataNascimento, genero);
         }
         else{
             novoUtilizador = new UtilizadorPraticanteOcasional(nome, morada, email, freqCardiaca, peso, altura, dataNascimento, genero);
         }
         this.utilizadores.put(novoUtilizador.getCodUtilizador(), novoUtilizador);
         return novoUtilizador.getCodUtilizador();
    }
    
    public boolean existeUtilizador(int codUtilizador){
        return this.utilizadores.containsKey(codUtilizador);
    }
    
    public void addAtivDist(int codUtilizador, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, double distancia, int tipo){
         Atividade novaAtividade;
         if(tipo==1){
             novaAtividade = new Corrida(realizacao, tempo, freqCardiaca, distancia);
         }
         else{
             novaAtividade = new Ciclismo(realizacao, tempo, freqCardiaca, distancia);
         }
         this.utilizadores.get(codUtilizador).addAtividade(novaAtividade);
    }
    
    public void addAtivDistAlt(int codUtilizador, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, double distancia, double altimetria, int tipo){
         Atividade novaAtividade;
         if(tipo==3){
             novaAtividade = new Trail(realizacao, tempo, freqCardiaca, distancia, altimetria);
         }
         else{
             novaAtividade = new Btt(realizacao, tempo, freqCardiaca, distancia, altimetria);
         }
         this.utilizadores.get(codUtilizador).addAtividade(novaAtividade);
    }
    
    public void addAtivRep(int codUtilizador, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, int repeticoes, int tipo){
         Atividade novaAtividade;
         if(tipo==5){
             novaAtividade = new Flexoes(realizacao, tempo, freqCardiaca, repeticoes);
         }
         else{
             novaAtividade = new Abdominais(realizacao, tempo, freqCardiaca, repeticoes);
         }
         this.utilizadores.get(codUtilizador).addAtividade(novaAtividade);
    }
    
    public void addAtivRepsPeso(int codUtilizador, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, int repeticoes, double peso, int tipo){
         Atividade novaAtividade;
         if(tipo==7){
             novaAtividade = new LegPress(realizacao, tempo, freqCardiaca, repeticoes, peso);
         }
         if(tipo==8){
             novaAtividade = new BenchPress(realizacao, tempo, freqCardiaca, repeticoes, peso);
         }
         else{
             novaAtividade = new BicepCurls(realizacao, tempo, freqCardiaca, repeticoes, peso);
         }
         this.utilizadores.get(codUtilizador).addAtividade(novaAtividade);
    }
    
    public void addAtivDistPlano(int codUtilizador, int codPlano, int iteracoes, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, double distancia, int tipo){
         Atividade novaAtividade;
         if(tipo==1){
             novaAtividade = new Corrida(realizacao, tempo, freqCardiaca, distancia);
         }
         else{
             novaAtividade = new Ciclismo(realizacao, tempo, freqCardiaca, distancia);
         }
         this.utilizadores.get(codUtilizador).addAtividadePlanoTreino(codPlano, novaAtividade, iteracoes);
    }
    
    public void addAtivDistAltPlano(int codUtilizador, int codPlano, int iteracoes, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, double distancia, double altimetria, int tipo){
         Atividade novaAtividade;
         if(tipo==3){
             novaAtividade = new Trail(realizacao, tempo, freqCardiaca, distancia, altimetria);
         }
         else{
             novaAtividade = new Btt(realizacao, tempo, freqCardiaca, distancia, altimetria);
         }
         this.utilizadores.get(codUtilizador).addAtividadePlanoTreino(codPlano, novaAtividade, iteracoes);
    }
    
    public void addAtivRepPlano(int codUtilizador, int codPlano, int iteracoes, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, int repeticoes, int tipo){
         Atividade novaAtividade;
         if(tipo==5){
             novaAtividade = new Flexoes(realizacao, tempo, freqCardiaca, repeticoes);
         }
         else{
             novaAtividade = new Abdominais(realizacao, tempo, freqCardiaca, repeticoes);
         }
         this.utilizadores.get(codUtilizador).addAtividadePlanoTreino(codPlano, novaAtividade, iteracoes);
    }
    
    public void addAtivRepsPesoPlano(int codUtilizador, int codPlano, int iteracoes, LocalDateTime realizacao, LocalTime tempo, int freqCardiaca, int repeticoes, double peso, int tipo){
         Atividade novaAtividade;
         if(tipo==7){
             novaAtividade = new LegPress(realizacao, tempo, freqCardiaca, repeticoes, peso);
         }
         if(tipo==8){
             novaAtividade = new BenchPress(realizacao, tempo, freqCardiaca, repeticoes, peso);
         }
         else{
             novaAtividade = new BicepCurls(realizacao, tempo, freqCardiaca, repeticoes, peso);
         }
         this.utilizadores.get(codUtilizador).addAtividadePlanoTreino(codPlano, novaAtividade, iteracoes);
    }
    
    public int addPlanoTreinoUtilizador(int codUtilizador, LocalDate data){
        PlanoTreino plano = new PlanoTreino(data);
        this.utilizadores.get(codUtilizador).addPlanoTreino(plano);
        return plano.getCodPlano();
    }
    
    public double kmsPercorridos(int codUtilizador, LocalDate dataInicio, LocalDate dataFim){
        return this.utilizadores.get(codUtilizador).allKmsDistancia(dataInicio,dataFim);
    }
    
    public double metrosAltimetria(int codUtilizador, LocalDate dataInicio, LocalDate dataFim){
        return this.utilizadores.get(codUtilizador).allMetrosAltimetria(dataInicio,dataFim);
    }
    
    public String atividadesUtilizador(int codUtilizador){
        StringBuilder sb = new StringBuilder();
        for (Atividade a : this.utilizadores.get(codUtilizador).allAtividades(LocalDate.MIN,LocalDate.MAX)){
            sb.append(a.toString());
        }
        return sb.toString();
    }
    
    public String mostraInfo(){
        StringBuilder sb = new StringBuilder();
        for(Utilizador u : this.infoNumPeriodo(LocalDate.MIN, this.dataAtual)){
            sb.append(u.toString());
        }
        return sb.toString();
    }

    public double recordMaisPeso(Class<Atividade> tipo){
        double peso;
        peso = recordDouble(tipo, a -> ((AtivRepsPeso)a).getPeso());
        return peso;
    }

    public int recordMaisRepeticoes(Class<Atividade> tipo){
        int reps;
        reps = recordInt(tipo, a -> ((AtivRepeticoes)a).getRepeticoes());
        return reps;
    }

    public double recordMaiorAltimetria(Class<Atividade> tipo){
        double altimetria;
        altimetria = recordDouble(tipo, a -> ((AtivDistAltimetria)a).getAltimetria());
        return altimetria;
    }

    public double recordMaisVelocidade(Class<Atividade> tipo){
        double velocidade;
        velocidade = recordDouble(tipo, a -> ((AtivDistancia)a).getVelocidade());
        return velocidade;
    }

    public int recordMaisTempo(Class<Atividade> tipo){
        int tempo;
        tempo = recordInt(tipo, a -> ((Atividade)a).getTempo().toSecondOfDay());
        return tempo;
    }

    public double recordMaisDistancia(Class<Atividade> tipo){
        double distancia;
        distancia = recordDouble(tipo, a -> ((AtivDistancia)a).getDistancia());
        return distancia;
    }

    public double recordMaisCalorias(Class<Atividade> tipo){
        LocalDate inicio = LocalDate.MIN;
        LocalDate fim = LocalDate.MAX;
        Predicate<Atividade> p = a -> tipo.isInstance(a);
        BiFunction<Atividade,Utilizador,Double> f = (a,u) -> ((Atividade)a).consumoCalorias((Utilizador)u);
        return this.utilizadores.values().stream()
                                .flatMap(u -> u.infoDasAtividadesUtilizadorNumPeriodoQueRespeitamP(inicio, fim, p, f, u).stream())
                                .reduce((n1, n2) -> n1 > n2 ? n1 : n2)
                                .orElse(0.0);
    }

    public double recordDouble(Class<Atividade> tipo, Function<Atividade,Double> f){
        LocalDate inicio = LocalDate.MIN;
        LocalDate fim = LocalDate.MAX;
        Predicate<Atividade> p = a -> tipo.isInstance(a);
        return this.utilizadores.values().stream()
                                .flatMap(u -> u.infoDasAtividadesNumPeriodoQueRespeitamP(inicio, fim, p, f).stream())
                                .reduce((n1, n2) -> n1 > n2 ? n1 : n2)
                                .orElse(0.0);
    }

    public int recordInt(Class<Atividade> tipo, Function<Atividade,Integer> f){
        LocalDate inicio = LocalDate.MIN;
        LocalDate fim = LocalDate.MAX;
        Predicate<Atividade> p = a -> tipo.isInstance(a);
        return this.utilizadores.values().stream()
                                .flatMap(u -> u.infoDasAtividadesNumPeriodoQueRespeitamP(inicio, fim, p, f).stream())
                                .reduce((n1, n2) -> n1 > n2 ? n1 : n2)
                                .orElse(0);
    }
}
