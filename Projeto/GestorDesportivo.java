package Projeto;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.*;
import java.util.stream.Collectors;
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
        for(Utilizador u : this.utilizadores.values()){
            sb.append(u.toString());
        }
        return sb.toString();
    }
}
