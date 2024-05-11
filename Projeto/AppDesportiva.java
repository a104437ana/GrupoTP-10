package Projeto;
import java.io.*;
import java.time.*;

/**
 * Classe AppDesportiva, que corresponde ao controller
 *
 * @author Grupo10
 * @version 10/05/24
 * Notas versão :
 */
public class AppDesportiva
{
    private GestorDesportivo model;
    private Menu menuInicial, menuSetup, menuSimulacao, menuEstatisticas;
    private LocalDate dataAtual;
    private static String[] opcoesInicial = {"Menu Inicial","Carregar estado", "Novo estado", "Sair"};
    private static String[] opcoesSetup = {"Menu Setup","Adicionar utilizador", "Adicionar atividade", "Registar execução de atividade", "Adicionar atividade e registar execução", "Adicionar plano de treino", "Registar execução de plano de treino", "Adicionar plano de treino e registar execução", "Iniciar simulação", "Guardar estado", "Guardar e sair","Sair sem guardar"};
    private static String[] opcoesSimulacao = {"Menu Simulação", "Avançar tempo","Consultar recordes", "Consultar estatísticas", "Mostrar todas as informações", "Voltar ao setup"};
    private static String[] opcoesEstatisticas = {"Estatísticas","Utilizador com mais calorias gastas", "Utilizador com mais atividades realizadas", "Atividade mais realizada", "Total de kilómetros percorridos", "Metros de altimetria acumulados", "Plano de treino mais exigente", "Atividades de um utilizador", "Voltar"};
   
    /**
     * Construtor de AppDesportiva
     */
    public AppDesportiva()
    {
        this.model = new GestorDesportivo();
        this.menuInicial = new Menu(AppDesportiva.opcoesInicial);
        this.menuSetup = new Menu(AppDesportiva.opcoesSetup);
        this.menuSimulacao = new Menu(AppDesportiva.opcoesSimulacao);
        this.menuEstatisticas = new Menu(AppDesportiva.opcoesEstatisticas);
        this.dataAtual = LocalDate.now();
    }
    
    /**
     * Construtor de AppDesportiva quando é passado o nome do ficheiro a carregar
     * @param nome do ficheiro
     */
    public AppDesportiva(String ficheiro)
    {
        this.model = new GestorDesportivo();
        this.menuInicial = new Menu(AppDesportiva.opcoesInicial);
        this.menuSetup = new Menu(AppDesportiva.opcoesSetup);
        this.menuSimulacao = new Menu(AppDesportiva.opcoesSimulacao);
        this.menuEstatisticas = new Menu(AppDesportiva.opcoesEstatisticas);
        this.dataAtual = LocalDate.now();
        try{
            this.model = this.model.carregaEstado(ficheiro);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            menuInicial.pedeString("Dados carregados com sucesso.\nEnter para continuar");
        }
        catch (ClassNotFoundException clExc){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            menuInicial.pedeString("Não foi possível carregar os dados do ficheiro.\nEnter para continuar");
        }
        catch (IOException ioExc){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            menuInicial.pedeString("Não foi possível aceder ao ficheiro.\nEnter para continuar");
        }
    }
    
    /**
     * Método auxiliar carregaDados
     * @param menu atual
     */
    private int carregaDados(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String ficheiro = menuAtual.pedeString("Insira o nome do ficheiro a carregar");
        try{
            this.model = this.model.carregaEstado(ficheiro);
            menuAtual.pedeString("Dados carregados com sucesso.\nEnter para continuar");
            return 0;
        }
        catch (ClassNotFoundException clExc){
            menuAtual.pedeString("Não foi possível carregar os dados do ficheiro.\nEnter para continuar");
        }
        catch (IOException ioExc){
            menuAtual.pedeString("Não foi possível aceder ao ficheiro.\nEnter para continuar");
        }
        return 1;
    }
    
    /**
     * Método auxiliar guardaDados
     * @param menu atual
     */
    private int guardaDados(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String ficheiro = menuAtual.pedeString("Insira o nome do ficheiro para guardar");
        try {
            this.model.guardaEstado(ficheiro);
            menuAtual.pedeString("Estado guardado com sucesso.\nEnter para continuar");
            return 0;
        }
        catch (IOException e){
            menuAtual.pedeString("Não foi possível aceder ao ficheiro.\nEnter para continuar");
        }
        return 1;
    }
    
    /**
     * Método auxiliar adicionaUser
     * @param menu atual
     */
    private void adicionaUser(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String nome = menuAtual.pedeString("Insira o nome do utilizador");
        String morada = menuAtual.pedeString("Insira a morada do utilizador");
        String email = menuAtual.pedeString("Insira o email do utilizador");
        int freqCardiaca = menuAtual.pedeInt("Insira a frequência cardíaca média do utilizador");
        int peso = menuAtual.pedeInt("Insira o peso do utilizador (em kilos)");
        int altura = menuAtual.pedeInt("Insira a altura do utilizador (em centímetros)");
        LocalDate dataNascimento = menuAtual.pedeData("Insira a data de nascimento do utilizador (dia/mês/ano)");
        char genero = menuAtual.pedeString("Insira o género do utilizador: M ou F").charAt(0);
        while(genero!='M'&&genero!='F'){
            genero = menuAtual.pedeString("Insira o género do utilizador: M ou F").charAt(0);
        }
        int tipo = menuAtual.pedeInt("Insira o tipo de utilizador:\n1: Utilizador amador\n2: Utilizador praticante ocasional\n3: Utilizador profissional");
        while(tipo<1||tipo>3){
            tipo = menuAtual.pedeInt("Insira o tipo de utilizador:\n1: Utilizador amador\n2: Utilizador praticante ocasional\n3: Utilizador profissional");
        }
        int cod = model.addUtilizador(nome, morada, email, freqCardiaca, peso, altura, dataNascimento, genero, tipo);
        System.out.print("Utilizador adicionado com sucesso.\nCódigo do utilizador adicionado: ");
        System.out.println(cod);
        menuAtual.pedeString("Enter para continuar");
    }
    
    /**
     * Método auxiliar adicionaAtividade
     * @param menu atual
     */
    private int addAtividade(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        if(tipoAtiv<1||tipoAtiv>9){
            tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        }
        LocalDateTime realizacao = menuAtual.pedeDataHora("Insira a data e hora de realização (dia/mês/ano horas:minutos:segundos)");
        LocalTime tempo = menuAtual.pedeTempo("Insira o tempo de realização horas:minutos:segundos");
        int freq = menuAtual.pedeInt("Insira a frequência cardíaca média durante a realização");
        int id;
        if(tipoAtiv<=4){
                double dist = menuAtual.pedeDouble("Insira a distância percorrida (em metros)");
                if(tipoAtiv<=2) id = this.model.addAtivDist(realizacao, tempo, freq, dist, tipoAtiv);
                else{
                    double alt = menuAtual.pedeDouble("Insira os metros de altimetria");
                    id = this.model.addAtivDistAlt(realizacao, tempo, freq, dist, alt, tipoAtiv);
                }
        }
        else{
                int reps = menuAtual.pedeInt("Insira o número de repetições");
                if(tipoAtiv<=6) id = this.model.addAtivRep(realizacao, tempo, freq, reps, tipoAtiv);
                else{
                    double peso = menuAtual.pedeDouble("Insira o peso utilizado (em kilos)");
                    id = this.model.addAtivRepsPeso(realizacao, tempo, freq, reps, peso, tipoAtiv);
                }
        }
        return id;
    }
    
    /**
     * Método auxiliar registaAtividade
     * @param menu atual
     */
    private void registaAtividade(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int codUtilizador = menuAtual.pedeInt("Insira o código do utilizador");
        if (!model.existeUtilizador(codUtilizador)){
                menuAtual.pedeString("Utilizador não existe.\nEnter para continuar");
                return;
        }
        int codAtividade = menuAtual.pedeInt("Insira o código da atividade");
        if (!model.existeAtividade(codAtividade)){
                menuAtual.pedeString("Atividade não existe.\nEnter para continuar");
                return;
        }
        model.registaAtividade(codUtilizador, codAtividade);
        menuAtual.pedeString("Atividade registada com sucesso.\nEnter para continuar");
    }
    
    /**
     * Método auxiliar addRegistaAtividade
     * @param menu atual
     */
    private int addRegistaAtividade(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int codUtilizador = menuAtual.pedeInt("Insira o código do utilizador");
        while (!model.existeUtilizador(codUtilizador)){
                menuAtual.pedeString("Utilizador não existe.\nEnter para continuar");
                return 0;
        }
        int id = addAtividade(menuAtual);
        model.registaAtividade(codUtilizador, id);
        return id;
    }
    
    /**
     * Método auxiliar adicionaAtividadePlano
     * @param menu atual
     */
    private void adicionaAtividadePlano(Menu menuAtual, int id_plano, LocalDate data){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        if(tipoAtiv<1||tipoAtiv>9){
            tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        }
        LocalDateTime realizacao = menuAtual.pedeDataHora("Insira a data e hora de realização (dia/mês/ano horas:minutos:segundos)");
        while(realizacao.isBefore(data.atStartOfDay())||realizacao.isAfter(data.plusWeeks(1).atTime(23,59))){
            realizacao = menuAtual.pedeDataHora("Data de realização tem de estar na semana do plano de treino");
        }
        LocalTime tempo = menuAtual.pedeTempo("Insira o tempo de realização horas:minutos:segundos");
        int freq = menuAtual.pedeInt("Insira a frequência cardíaca média durante a realização");
        int iter = menuAtual.pedeInt("Insira o número de iterações da atividade");
        if(tipoAtiv<=4){
                double dist = menuAtual.pedeDouble("Insira a distância percorrida (em metros)");
                if(tipoAtiv<=2) this.model.addAtivDistPlano(id_plano, iter, realizacao, tempo, freq, dist, tipoAtiv);
                else{
                    double alt = menuAtual.pedeDouble("Insira os metros de altimetria");
                    this.model.addAtivDistAltPlano(id_plano, iter, realizacao, tempo, freq, dist, alt, tipoAtiv);
                }
        }
        else{
                int reps = menuAtual.pedeInt("Insira o número de repetições");
                if(tipoAtiv<=6) this.model.addAtivRepPlano(id_plano, iter,realizacao, tempo, freq, reps, tipoAtiv);
                else{
                    double peso = menuAtual.pedeDouble("Insira o peso utilizado (em kilos)");
                    this.model.addAtivRepsPesoPlano(id_plano, iter,realizacao, tempo, freq, reps, peso, tipoAtiv);
                }
        }
        menuAtual.pedeString("Atividade adicionada com sucesso.\nEnter para continuar");
    }
    
    private int addPlano(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        LocalDate dataRealizacao = menuAtual.pedeData("Insira a data de início do plano de treino (segunda feira)");
        while(dataRealizacao.getDayOfWeek()!=DayOfWeek.MONDAY){
            dataRealizacao = menuAtual.pedeData("Insira a data de início do plano de treino (segunda feira)");
        }
        int id = this.model.addPlanoTreino(dataRealizacao);
        System.out.print("Plano adicionado com sucesso.\nCódigo do plano adicionado: ");
        System.out.println(id);
        menuAtual.pedeString("Enter para continuar");
        int nAtividades = menuAtual.pedeInt("Insira o número de atividades a colocar no plano de treino");
        while(nAtividades>0){
            this.adicionaAtividadePlano(menuAtual, id, dataRealizacao);
            nAtividades--;
        }
        return id;
    }
    
    private void registaPlano(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int codUtilizador = menuAtual.pedeInt("Insira o código do utilizador");
        if (!model.existeUtilizador(codUtilizador)){
                menuAtual.pedeString("Utilizador não existe.\nEnter para continuar");
                return;
        }
        int codPlano = menuAtual.pedeInt("Insira o código do plano de treino");
        if (!model.existePlano(codPlano)){
                menuAtual.pedeString("Plano de treino não existe.\nEnter para continuar");
                return;
        }
        model.registaPlanoTreino(codUtilizador, codPlano);
        menuAtual.pedeString("Plano de treino registado com sucesso.\nEnter para continuar");
    }
    
    /**
     * Método auxiliar addRegistaPlano
     * @param menu atual
     */
    private int addRegistaPlano(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int codUtilizador = menuAtual.pedeInt("Insira o código do utilizador");
        if (!model.existeUtilizador(codUtilizador)){
                menuAtual.pedeString("Utilizador não existe.\nEnter para continuar");
                return 0;
        }
        int id = addPlano(menuAtual);
        model.registaPlanoTreino(codUtilizador, id);
        return id;
    }
    
    
    public void estatisticaEntreDatas(int op){
        LocalDate dataInicial;
        LocalDate dataFinal;
        int d = 0;
        while(d!=1&&d!=2){
            d = this.menuEstatisticas.pedeInt("1: Desde sempre\n2: Entre datas");
        }
        if(d==1){
            dataInicial = LocalDate.MIN;
            dataFinal = this.dataAtual;
        }
        else{
            dataInicial = this.menuEstatisticas.pedeData("Insira data inicial (dia/mês/ano)");
            dataFinal = this.menuEstatisticas.pedeData("Insira data final (dia/mês/ano)");
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (op){
                case 1:
                Utilizador res = this.model.maisCaloriasGastas(dataInicial,dataFinal);
                System.out.println(res.toString());
                break;
            case 2:
                Utilizador user = this.model.maisAtividades(dataInicial,dataFinal);
                System.out.println(user.toString());
                break;
            case 6:
                PlanoTreino plano = this.model.planoTreinoMaisCalorias(dataFinal);
                System.out.println(plano.toString());
                break;
        }
        menuEstatisticas.pedeString("Enter para continuar");
    }
    
    public void estatisticaUtilizadorEntreDatas(int op){
        int codUser = menuEstatisticas.pedeInt("Insira o código do utilizador");
        if (!model.existeUtilizador(codUser)){
                menuEstatisticas.pedeString("Utilizador não existe.\nEnter para continuar");
                return;
        }
        LocalDate dataInicial;
        LocalDate dataFinal;
        int d = 0;
        while(d!=1&&d!=2){
            d = this.menuEstatisticas.pedeInt("1: Desde sempre\n2: Entre datas");
        }
        if(d==1){
            dataInicial = LocalDate.MIN;
            dataFinal = this.dataAtual;
        }
        else{
            dataInicial = this.menuEstatisticas.pedeData("Insira data inicial (dia/mês/ano)");
            dataFinal = this.menuEstatisticas.pedeData("Insira data final (dia/mês/ano)");
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (op){
            case 4:
                double kms = model.kmsPercorridos(codUser, dataInicial, dataFinal);
                System.out.print(kms);
                System.out.println(" kilómetros\n");
                break;
            case 5:
                double metros = model.metrosAltimetria(codUser, dataInicial, dataFinal);
                System.out.print(metros);
                System.out.println(" metros\n");
                break;
        }
        menuEstatisticas.pedeString("Enter para continuar");
    }
    
    /**
     * Método runInicial, que executa o menu inicial, lê e trata as opções escolhidas
     */
    public void runInicial(){
        menuInicial.runMenu();
        int op = menuInicial.getOpcao();
        while (op!=0){
            switch (op){ 
                case 1 :   //opção "Carregar estado"
                    int carregar = this.carregaDados(menuInicial);
                    if (carregar == 1) break;
                    int ext = this.runSetup();
                    if (ext==1) op=0;
                    op=0;
                    break;
                case 2 :    //opção "Novo estado"
                    int exit = this.runSetup();
                    if (exit==1) op=0;
                    break;
            }
            if(op!=0){
                menuInicial.runMenu();
                op = menuInicial.getOpcao();
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Programa encerrado");
    }
    
    /**
     * Método runSetup, que executa o menu onde são adicionados os utilizadores, atividades e planos de treino
     */
    public int runSetup(){
        menuSetup.runMenu();
        int op = menuSetup.getOpcao();
        while (op!=0){ 
            switch (op){
                case 1 :    //opção "Adicionar utilizador"
                    this.adicionaUser(menuSetup);
                    break;
                case 2 :    //opção "Adicionar atividade"
                    int id = this.addAtividade(menuSetup);
                    System.out.print("Atividade adicionada com sucesso.\nCódigo da atividade adicionada: ");
                    System.out.println(id);
                    menuSetup.pedeString("Enter para continuar");
                    break;
                case 3 :    //opção "Registar execução de atividade"
                    this.registaAtividade(menuSetup);
                    menuSetup.pedeString("Atividade registada com sucesso.\nEnter para continuar");
                    break;
                case 4 :    //opção "Adicionar atividade e registar execução"
                    int cod = this.addRegistaAtividade(menuSetup);
                    System.out.print("Atividade adicionada com sucesso.\nCódigo da atividade adicionada: ");
                    System.out.println(cod);
                    menuSetup.pedeString("Enter para continuar");
                    break;
                case 5 :    //opção "Adicionar plano de treino"
                    int idPlano = this.addPlano(menuSetup);
                    System.out.print("Plano de treino adicionado com sucesso.\nCódigo do plano adicionado: ");
                    System.out.println(idPlano);
                    menuSetup.pedeString("Enter para continuar");
                    break;
                case 6 :    //opção "Registar execução de plano de treino"
                    this.registaPlano(menuSetup);
                    menuSetup.pedeString("Plano de treino registado com sucesso.\nEnter para continuar");
                    break;
                case 7 :    //opção "Adicionar plano de treino e registar execução"
                    int codPlano = this.addRegistaPlano(menuSetup);
                    System.out.print("Plano de treino adicionado com sucesso.\nCódigo do plano adicionado: ");
                    System.out.println(codPlano);
                    menuSetup.pedeString("Enter para continuar");
                    break;
                case 8 :    //opção "Iniciar simulação"
                    int d = 0;
                    while(d!=1&&d!=2){
                        d = this.menuSetup.pedeInt("1: Escolher data\n2: Utilizar data do sistema");
                    }
                    if(d==1) this.dataAtual = this.menuSetup.pedeData("Insira a data atual (dia/mês/ano)");
                    this.runSimulacao();
                    break;
                case 9 :    //opção "Guardar estado"
                    this.guardaDados(menuSetup);
                    break;
                case 10 :    //opção "Guardar e sair"
                    int guardar = this.guardaDados(menuSetup);
                    if (guardar == 1) break;
                    op=0;
                    break;
            }
            if(op!=0){
                menuSetup.runMenu();
                op = menuSetup.getOpcao();
            }
        }
        return 1;
    }
    
    /**
     * Método runSimulacao que executa o menu depois de iniciada a simulação
     */
    public void runSimulacao(){
        menuSimulacao.runMenu();
        System.out.print("Data atual da simulação: ");
        System.out.println(this.dataAtual.toString());
        int op = menuSimulacao.getOpcao();
        while (op!=0){
            switch (op){
                case 1 : ; //opção "Avançar tempo"
                case 2 : ;  //opção "Consultar recordes"
                case 3 :    //opção "Consultar estatísticas"
                    this.runQueries();
                    break;
                case 4 :    //opção "Mostrar todas as informações"
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    String str = this.model.mostraInfo();
                    System.out.println(str);
                    menuSimulacao.pedeString("Enter para continuar");
                    break;
            }
            menuSimulacao.runMenu();
            op = menuSimulacao.getOpcao();
        }
    }
    
    /**
     * Método runApp que executa o menu de estatísticas
     */
    public void runQueries(){
        this.menuEstatisticas.runMenu();
        int op = this.menuEstatisticas.getOpcao();
        while (op!=0){
            switch (op){
                case 1 :    //opção "Utilizador com mais calorias gastas"
                    this.estatisticaEntreDatas(op);
                    break;
                case 2 :    //opção "Utilizador com mais atividades realizadas"
                    this.estatisticaEntreDatas(op);
                    break;
                case 3 :    //opção "Atividade mais realizada"
                    String resposta = this.model.atividadeMaisRealizada();
                    System.out.println(resposta);
                    menuEstatisticas.pedeString("Enter para continuar");
                    break;
                case 4 :    //opção "Total de kilómetros percorridos"
                    this.estatisticaUtilizadorEntreDatas(op);
                    break;
                case 5 :    //opção "Metros de altimetria acumulados"
                    this.estatisticaUtilizadorEntreDatas(op);
                    break;
                case 6 :    //opção "Plano de treino mais exigente"
                    this.estatisticaEntreDatas(op);
                    break;
                case 7 :    //opção "Atividades de um utilizador"
                    int codUser = menuEstatisticas.pedeInt("Insira o código do utilizador");
                    if (!model.existeUtilizador(codUser)){
                        menuEstatisticas.pedeString("Utilizador não existe.\nEnter para continuar");
                        break;
                    }
                    String res = this.model.atividadesUtilizador(codUser);
                    System.out.print(res);
                    menuEstatisticas.pedeString("Enter para continuar");
                    break;
            }
            menuEstatisticas.runMenu();
            op = menuEstatisticas.getOpcao();
        }
    }
}
