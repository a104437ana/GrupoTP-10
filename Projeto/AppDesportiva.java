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
    private Menu menuSetup, menuApp, menuEstatisticas;
    private LocalDate dataAtual;
    private static String[] opcoesSetup = {"Menu Principal","Carregar estado", "Adicionar utilizador", "Adicionar atividade", "Adicionar plano de treino", "Começar fase de simulação", "Guardar estado", "Guardar e sair","Sair"};
    private static String[] opcoesApp = {"Menu","Adicionar utilizador", "Adicionar atividade", "Adicionar plano de treino","Registar execução", "Alterar data", "Consultar recordes", "Consultar estatísticas", "Mostrar todas as informações", "Guardar estado", "Voltar ao setup", "Guardar e sair", "Sair"};
    private static String[] opcoesQueries = {"Estatísticas","Utilizador com mais calorias gastas", "Utilizador com mais atividades realizadas", "Atividade mais realizada", "Total de kilómetros percorridos", "Metros de altimetria acumulados", "Plano de treino mais exigente", "Atividades de um utilizador", "Voltar"};
   
    /**
     * Construtor de AppDesportiva
     */
    public AppDesportiva()
    {
        this.model = new GestorDesportivo();
        this.menuSetup = new Menu(AppDesportiva.opcoesSetup);
        this.menuApp = new Menu(AppDesportiva.opcoesApp);
        this.menuEstatisticas = new Menu(AppDesportiva.opcoesQueries);
        this.dataAtual = LocalDate.now();
    }
    
    /**
     * Construtor de AppDesportiva quando é passado o nome do ficheiro a carregar
     * @param nome do ficheiro
     */
    public AppDesportiva(String ficheiro)
    {
        this.model = new GestorDesportivo();
        this.menuSetup = new Menu(AppDesportiva.opcoesSetup);
        this.menuApp = new Menu(AppDesportiva.opcoesApp);
        this.menuEstatisticas = new Menu(AppDesportiva.opcoesQueries);
        this.dataAtual = LocalDate.now();
        try{
            this.model = this.model.carregaEstado(ficheiro);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            menuSetup.pedeString("Dados carregados com sucesso.\nEnter para continuar");
        }
        catch (ClassNotFoundException clExc){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            menuSetup.pedeString("Não foi possível carregar os dados do ficheiro.\nEnter para continuar");
        }
        catch (IOException ioExc){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            menuSetup.pedeString("Não foi possível aceder ao ficheiro.\nEnter para continuar");
        }
    }
    
    /**
     * Método auxiliar carregaDados
     * @param menu atual
     */
    private void carregaDados(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String ficheiro = menuAtual.pedeString("Insira o nome do ficheiro a carregar");
        try{
            this.model = this.model.carregaEstado(ficheiro);
            menuAtual.pedeString("Dados carregados com sucesso.\nEnter para continuar");
        }
        catch (ClassNotFoundException clExc){
            menuAtual.pedeString("Não foi possível carregar os dados do ficheiro.\nEnter para continuar");
        }
        catch (IOException ioExc){
            menuAtual.pedeString("Não foi possível aceder ao ficheiro.\nEnter para continuar");
        }
    }
    
    /**
     * Método auxiliar guardaDados
     * @param menu atual
     */
    private void guardaDados(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String ficheiro = menuAtual.pedeString("Insira o nome do ficheiro para guardar");
        try {
            this.model.guardaEstado(ficheiro);
            menuAtual.pedeString("Estado guardado com sucesso.\nEnter para continuar");
        }
        catch (IOException e){
            menuAtual.pedeString("Não foi possível aceder ao ficheiro.\nEnter para continuar");
        }
    }
    
    /**
     * Método auxiliar adicionaUser
     * @param menu atual
     */
    private void adicionaUser(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        String nome = menuAtual.pedeString("Insira o nome do utilizador");
        String morada = menuAtual.pedeString("Insira a morada do utilizador");
        String email = menuAtual.pedeString("Insira o email do utilizador");
        int freqCardiaca = menuAtual.pedeInt("Insira a frequência cardíaca média do utilizador");
        int peso = menuAtual.pedeInt("Insira o peso do utilizador (em kilos)");
        int altura = menuAtual.pedeInt("Insira a altura do utilizador (em centímetros)");
        LocalDate dataNascimento = menuAtual.pedeData("Insira a data de nascimento do utilizador (ano-mês-dia)");
        char genero = menuAtual.pedeString("Insira o género do utilizador: M ou F").charAt(0);
        while(genero!='M'&&genero!='F'){
            genero = menuAtual.pedeString("Insira o género do utilizador: M ou F").charAt(0);
        }
        int tipo = menuAtual.pedeInt("Insira o tipo de utilizador:\n1: Utilizador amador\n2: Utilizador praticante ocasional\n3: Utilizador profissional");
        while(tipo<1||tipo>3){
            tipo = menuAtual.pedeInt("Insira o tipo de utilizador:\n1: Utilizador amador\n2: Utilizador praticante ocasional\n3: Utilizador profissional");
        }
        model.addUtilizador(nome, morada, email, freqCardiaca, peso, altura, dataNascimento, genero, tipo);
        menuAtual.pedeString("Utilizador adicionado com sucesso.\nEnter para continuar");
    }
    
    /**
     * Método auxiliar adicionaAtividade
     * @param menu atual
     */
    private void adicionaAtividade(Menu menuAtual){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int codUtilizador = menuAtual.pedeInt("Insira o código do utilizador");
        if (!model.existeUtilizador(codUtilizador)){
                menuAtual.pedeString("Utilizador não existe.\nEnter para continuar");
                return;
        }
        int tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        if(tipoAtiv<1||tipoAtiv>9){
            tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        }
        LocalDateTime realizacao = menuAtual.pedeDataHora("Insira a data e hora de realização (ano-mês-diaThoras:minutos:[segundos-opcional])");
        LocalTime tempo = menuAtual.pedeTempo("Insira o tempo de realização horas:minutos:[segundos-opcional]");
        int freq = menuAtual.pedeInt("Insira a frequência cardíaca média durante a realização");
        if(tipoAtiv<=4){
                double dist = menuAtual.pedeDouble("Insira a distância percorrida (em metros)");
                if(tipoAtiv<=2) this.model.addAtivDist(codUtilizador,realizacao, tempo, freq, dist, tipoAtiv);
                else{
                    double alt = menuAtual.pedeDouble("Insira os metros de altimetria");
                    this.model.addAtivDistAlt(codUtilizador,realizacao, tempo, freq, dist, alt, tipoAtiv);
                }
        }
        else{
                int reps = menuAtual.pedeInt("Insira o número de repetições");
                if(tipoAtiv<=6) this.model.addAtivRep(codUtilizador,realizacao, tempo, freq, reps, tipoAtiv);
                else{
                    double peso = menuAtual.pedeDouble("Insira o peso utilizado (em kilos)");
                    this.model.addAtivRepsPeso(codUtilizador,realizacao, tempo, freq, reps, peso, tipoAtiv);
                }
        }
        menuAtual.pedeString("Atividade adicionada com sucesso.\nEnter para continuar");
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
            dataInicial = this.menuEstatisticas.pedeData("Insira data inicial");
            dataFinal = this.menuEstatisticas.pedeData("Insira data final");
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
                PlanoTreino plano = this.model.planoTreinoMaisCalorias(dataInicial,dataFinal);
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
            dataInicial = this.menuEstatisticas.pedeData("Insira data inicial");
            dataFinal = this.menuEstatisticas.pedeData("Insira data final");
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
     * Método runSetup, que executa o menu inicial, lê e trata as opções escolhidas, enviando a operação pretendida para o model, indo para outro menu, ou encerrando o programa
     */
    public void runSetup(){
        menuSetup.runMenu();
        int op = menuSetup.getOpcao();
        while (op!=0){
            switch (op){ 

                case 1 :   //opção "Carregar estado"
                    this.carregaDados(menuSetup);
                    break;
                case 2 :    //opção "Adicionar utilizador"
                    this.adicionaUser(menuSetup);
                    break;
                case 3 :    //opção "Adicionar atividade"
                    this.adicionaAtividade(menuSetup);
                    break;
                case 4 : ; //opção "Adicionar plano de treino"
                case 5 :    //opção "Começar fase de simulação"
                    {
                        int d = 0;
                        while(d!=1&&d!=2){
                            d = this.menuSetup.pedeInt("1: Escolher data\n2: Utilizar data do sistema");
                        }
                        if(d==1) this.dataAtual = this.menuSetup.pedeData("Insira a data atual");
                        int ext = this.runApp();
                        if(ext == 2){
                            op=0;
                        }
                        else if (ext == 1){
                            this.guardaDados(menuSetup);
                            op=0;
                        }
                    }
                    break;
                case 6 :    //opção "Guardar estado"
                    this.guardaDados(menuSetup);
                    break;
                case 7 :    //opção "Guardar e sair"
                    this.guardaDados(menuSetup);
                    op=0;
                    break;
            }
            if(op!=0){
                menuSetup.runMenu();
                op = menuSetup.getOpcao();
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Programa encerrado");
    }
    
    /**
     * Método runApp que executa o menu depois de iniciada a simulação
     * @return código de saída para o menu setup: 0 - não sair, 1 - guardar e sair, 2 - sair sem guardar
     */
    public int runApp(){
        menuApp.runMenu();
        int op = menuApp.getOpcao();
        while (op!=0){
            switch (op){
                case 1 :    //opção "Adicionar utilizador"
                    this.adicionaUser(menuApp);
                    break;
                case 2 :    //opção "Adicionar atividade"
                    this.adicionaAtividade(menuApp);
                    break;
                case 3 : ; //opção "Adicionar plano de treino"
                case 4 : ; //opção "Registar execução"
                case 5 : ;   //opção "Alterar data"
                case 6 : ;  //opção "Consultar recordes"
                case 7 :    //opção "Consultar estatísticas"
                    this.runQueries();
                    break;
                case 8 :    //opção "Mostrar todas as informações"
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    String str = this.model.mostraInfo();
                    System.out.println(str);
                    menuApp.pedeString("Enter para continuar");
                    break;
                case 9 :    //opção "Guardar estado"
                    this.guardaDados(menuApp);
                    break;
                case 10 : return 0;  //opção "Voltar ao setup"
                case 11 : return 1; //opção "Guardar e sair"
            }
            menuApp.runMenu();
            op = menuApp.getOpcao();
        }
        return 2;
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
                    String resposta = this.model.atividadeMaisRealizada(this.dataAtual);
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
