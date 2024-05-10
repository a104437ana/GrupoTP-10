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
    private static String[] opcoesApp = {"Menu","Adicionar utilizador", "Registar atividade", "Adicionar plano de treino", "Alterar data", "Mostrar informações", "Consultar estatísticas", "Guardar estado", "Voltar ao setup", "Guardar e sair", "Sair"};
    private static String[] opcoesQueries = {"Estatísticas","Recorde calorias gastas", "Recorde atividades realizadas", "Atividade mais realizada", "Kms percorridos", "Metros de altimetria", "Record plano de treino", "Atividades utilizador", "Voltar"};
   
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
        try{
            this.model = this.model.carregaEstado(ficheiro);
        }
        catch (ClassNotFoundException clExc){
            System.out.println("Não foi possível carregar os dados do ficheiro");
        }
        catch (IOException ioExc){
            System.out.println("Não foi possível ler o ficheiro");
        }
        this.menuSetup = new Menu(AppDesportiva.opcoesSetup);
        this.menuApp = new Menu(AppDesportiva.opcoesApp);
        this.menuEstatisticas = new Menu(AppDesportiva.opcoesQueries);
        this.dataAtual = LocalDate.now();
    }
    
    /**
     * Método auxiliar carregaDados
     * @param menu atual
     */
    private void carregaDados(Menu menuAtual){
        String ficheiro = menuAtual.pedeString("Insira o nome do ficheiro a carregar");
        try{
            this.model = this.model.carregaEstado(ficheiro);
        }
        catch (ClassNotFoundException clExc){
            System.out.println("Não foi possível carregar os dados do ficheiro");
        }
        catch (IOException ioExc){
            System.out.println("Não foi possível ler o ficheiro");
        }
    }
    
    /**
     * Método auxiliar guardaDados
     * @param menu atual
     */
    private void guardaDados(Menu menuAtual){
        String ficheiro = menuAtual.pedeString("Insira o nome do ficheiro para guardar");
        try {
            this.model.guardaEstado(ficheiro);
        }
        catch (IOException e){
            System.out.println("Não foi possível guardar o estado");
        }
    }
    
    /**
     * Método auxiliar adicionaUser
     * @param menu atual
     */
    private void adicionaUser(Menu menuAtual){
        String nome = menuAtual.pedeString("Insira o nome do utilizador");
        String morada = menuAtual.pedeString("Insira a morada do utilizador");
        String email = menuAtual.pedeString("Insira o email do utilizador");
        int freqCardiaca = menuAtual.pedeInt("Insira a frequência cardíaca do utilizador");
        int peso = menuAtual.pedeInt("Insira o peso do utilizador");
        int altura = menuAtual.pedeInt("Insira a altura do utilizador");
        LocalDate dataNascimento = menuAtual.pedeData("Insira a data de nascimento do utilizador (ano-mês-dia)");
        char genero = menuAtual.pedeString("Insira o género do utilizador: M ou F").charAt(0);
        while(genero!='M'&&genero!='F'){
            genero = menuAtual.pedeString("Insira o género do utilizador: M ou F").charAt(0);
        }
        int tipo = menuAtual.pedeInt("Insira o tipo de utilizador:\n1: Utilizador amador\n2: Utilizador praticante ocasional\n3: Utilizador profissional");
        while(tipo<1||tipo>3){
            tipo = menuAtual.pedeInt("Insira o tipo de utilizador:\n1: Utilizador amador\n2:Utilizador praticante ocasional\n3: Utilizador profissional");
        }
        model.addUtilizador(nome, morada, email, freqCardiaca, peso, altura, dataNascimento, genero, tipo);
    }
    
    /**
     * Método auxiliar adicionaAtividade
     * @param menu atual
     */
    private void adicionaAtividade(Menu menuAtual){
        int codUtilizador = menuAtual.pedeInt("Insira o código do utilizador");
        if (!model.existeUtilizador(codUtilizador)){
                System.out.println("Utilizador não existe");
                return;
        }
        int tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        if(tipoAtiv<1||tipoAtiv>9){
            tipoAtiv = menuAtual.pedeInt("Insira o tipo da atividade:\n1: Corrida\n2: Ciclismo\n3: Trail\n4: Btt\n5: Flexões\n6: Abdominais\n7: Leg Press\n8: Bench Press\n9: Bicep Curls");
        }
        LocalDateTime realizacao = menuAtual.pedeDataHora("Insira a data e hora de realização");
        LocalTime tempo = menuAtual.pedeTempo("Insira o tempo de realização");
        int freq = menuAtual.pedeInt("Insira a frequência cardíaca");
        if(tipoAtiv<=4){
                double dist = menuAtual.pedeDouble("Insira a distância percorrida");
                if(tipoAtiv<=2) this.model.addAtivDist(codUtilizador,realizacao, tempo, freq, dist, tipoAtiv);
                else{
                    double alt = menuAtual.pedeDouble("Insira a altimetria");
                    this.model.addAtivDistAlt(codUtilizador,realizacao, tempo, freq, dist, alt, tipoAtiv);
                }
        }
        else{
                int reps = menuAtual.pedeInt("Insira o número de repetições");
                if(tipoAtiv<=6) this.model.addAtivRep(codUtilizador,realizacao, tempo, freq, reps, tipoAtiv);
                else{
                    double peso = menuAtual.pedeDouble("Insira o peso");
                    this.model.addAtivRepsPeso(codUtilizador,realizacao, tempo, freq, reps, peso, tipoAtiv);
                }
        }      
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
                case 1 : ; //opção "Adicionar utilizador"
                case 2 : ; //opção "Registar atividade"
                case 3 : ; //opção "Adicionar plano de treino"
                case 4 : ; //opção "Alterar data"
                case 5 : 
                    String str = this.model.mostraInfo();
                    System.out.println(str);
                    menuApp.pedeString("Enter para continuar");
                    break; //opção "Mostrar informações"
                case 6 :    //opção "Consultar estatísticas"
                    this.runQueries();
                    break;
                case 7 :    //opção "Guardar estado"
                    this.guardaDados(menuApp);
                    break;
                case 8 : return 0;  //opção "Voltar ao setup"
                case 9 : return 1; //opção "Guardar e sair"
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
                case 1 :    //opção "Recorde calorias gastas"
                    LocalDate dataInicial = this.menuEstatisticas.pedeData("Insira data inicial");
                    LocalDate dataFinal = this.menuEstatisticas.pedeData("Insira data final");
                    Utilizador res = this.model.maisCaloriasGastas(dataInicial,dataFinal);
                    System.out.println(res.toString());
                    menuEstatisticas.pedeString("Enter para continuar");
                    break;
                case 2 :    //opção "Recorde atividades realizadas"
                    LocalDate dataInicio = this.menuEstatisticas.pedeData("Insira data inicial");
                    LocalDate dataFim = this.menuEstatisticas.pedeData("Insira data final");
                    Utilizador user = this.model.maisAtividades(dataInicio,dataFim);
                    System.out.println(user.toString());
                    menuEstatisticas.pedeString("Enter para continuar");
                    break;
                case 3 :    //opção "Atividade mais realizada"
                    String resposta = this.model.atividadeMaisRealizada(this.dataAtual);
                    System.out.println(resposta);
                    menuEstatisticas.pedeString("Enter para continuar");
                    break;
                case 4 :    //opção "Kms percorridos"
                    int codUser = menuEstatisticas.pedeInt("Insira o código do utilizador");
                    if (!model.existeUtilizador(codUser)){
                        System.out.println("Utilizador não existe");
                        break;
                    }
                    LocalDate dataBegin = this.menuEstatisticas.pedeData("Insira data inicial");
                    LocalDate dataEnd = this.menuEstatisticas.pedeData("Insira data final");
                    double kms = model.kmsPercorridos(codUser, dataBegin, dataEnd);
                    System.out.print(kms);
                    System.out.println(" kilómetros\n");
                    menuEstatisticas.pedeString("Enter para continuar");
                    break;
                case 5 :    //opção "Metros de altimetria"
                    int codUtilizador = menuEstatisticas.pedeInt("Insira o código do utilizador");
                    if (!model.existeUtilizador(codUtilizador)){
                        System.out.println("Utilizador não existe");
                        break;
                    }
                    LocalDate dateBegin = this.menuEstatisticas.pedeData("Insira data inicial");
                    LocalDate dateEnd = this.menuEstatisticas.pedeData("Insira data final");
                    double metros = model.metrosAltimetria(codUtilizador, dateBegin, dateEnd);
                    System.out.print(metros);
                    System.out.println(" metros\n");
                    menuEstatisticas.pedeString("Enter para continuar");
                    break;
                case 6 :    //opção "Record plano de treino"
                    break;
                case 7 :    //opção "Atividades utilizador"
                    break;
            }
            menuEstatisticas.runMenu();
            op = menuEstatisticas.getOpcao();
        }
    }
}
