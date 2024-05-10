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
    }
    
    /**
     * Construtor de AppDesportiva quando é passado o nome do ficheiro a carregar
     * @param nome do ficheiro
     */
    public AppDesportiva(String ficheiro)
    {
        this.model = new GestorDesportivo();
        this.carregaDados(ficheiro);
        this.menuSetup = new Menu(AppDesportiva.opcoesSetup);
        this.menuApp = new Menu(AppDesportiva.opcoesApp);
        this.menuEstatisticas = new Menu(AppDesportiva.opcoesQueries);
    }
    
    /**
     * Método auxiliar carregaDados
     * @param nome do ficheiro
     */
    private void carregaDados(String ficheiro){
        try{
        this.model.carregaEstado(ficheiro);
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
     * @param nome do ficheiro
     */
    private void guardaDados(String ficheiro){
        try {
            this.model.guardaEstado(ficheiro);
        }
        catch (IOException e){
            System.out.println("Não foi possível guardar o estado");
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
                    String ficheiro = menuSetup.pedeString("Insira o nome do ficheiro a carregar");
                    this.carregaDados(ficheiro);
                    break;
                case 2 :    //opção "Adicionar utilizador"
                    String nome = menuSetup.pedeString("Insira o nome do utilizador");
                    String morada = menuSetup.pedeString("Insira a morada do utilizador");
                    String email = menuSetup.pedeString("Insira o email do utilizador");
                    int freqCardiaca = menuSetup.pedeInt("Insira a frequência cardíaca do utilizador");
                    int peso = menuSetup.pedeInt("Insira o peso do utilizador");
                    int altura = menuSetup.pedeInt("Insira a altura do utilizador");
                    LocalDate dataNascimento = menuSetup.pedeData("Insira a data de nascimento do utilizador (ano-mês-dia)");
                    char genero = menuSetup.pedeString("Insira o género do utilizador").charAt(0);
                    String tipo = menuSetup.pedeString("Insira o tipo de utilizador");
                    model.addUtilizador(nome, morada, email, freqCardiaca, peso, altura, dataNascimento, genero, tipo);
                    break;
                case 3 :    //opção "Adicionar atividade"
                    int codUtilizador = menuSetup.pedeInt("Insira o código do utilizador");
                    if (!model.existeUtilizador(codUtilizador)){
                         System.out.println("Utilizador não existe");
                         break;
                    }
                    String tipoAtiv = menuSetup.pedeString("Insira o tipo da atividade");
                    LocalDateTime realizacao = menuSetup.pedeDataHora("Insira a data e hora de realização");
                    LocalTime tempo = menuSetup.pedeTempo("Insira o tempo de realização");
                    int freq = menuSetup.pedeInt("Insira a frequência cardíaca");
                    if(tipoAtiv.equals("Corrida")||tipoAtiv.equals("Ciclismo")){
                        double dist = menuSetup.pedeDouble("Insira a distância percorrida");
                        this.model.addAtivDist(codUtilizador,realizacao, tempo, freq, dist, tipoAtiv);
                    }
                    else if(tipoAtiv.equals("Btt")||tipoAtiv.equals("Trail")){
                        double distancia = menuSetup.pedeDouble("Insira a distância percorrida");
                        double alt = menuSetup.pedeDouble("Insira a altimetria");
                        this.model.addAtivDistAlt(codUtilizador,realizacao,  tempo, freq, distancia, alt, tipoAtiv);
                    }
                    else if(tipoAtiv.equals("Flexões")||tipoAtiv.equals("Abdominais")){
                        int reps = menuSetup.pedeInt("Insira o número de repetições");
                        this.model.addAtivRep(codUtilizador,realizacao,  tempo, freq, reps, tipoAtiv);
                    }
                    else if(tipoAtiv.equals("Leg Press")||tipoAtiv.equals("Bench Press")||tipoAtiv.equals("Bicep Curls")){
                        int repeticoes = menuSetup.pedeInt("Insira o número de repetições");
                        double pes = menuSetup.pedeDouble("Insira o peso");
                        this.model.addAtivRepsPeso(codUtilizador,realizacao,  tempo, freq, repeticoes, pes, tipoAtiv);
                    }
                    else {
                        System.out.println("Tipo de atividade não existe");                        
                    }
                    break;
                case 4 : ; //opção "Adicionar plano de treino"
                case 5 :    //opção "Começar fase de simulação"
                    {
                        int ext = this.runApp();
                        if(ext == 2){
                            op=0;
                        }
                        else if (ext == 1){
                            String nomeFicheiro = menuSetup.pedeString("Insira o nome do ficheiro para guardar");
                            this.guardaDados(nomeFicheiro);
                            op=0;
                        }
                    }
                    break;
                case 6 :    //opção "Guardar estado"
                    String file = menuSetup.pedeString("Insira o nome do ficheiro para guardar");
                    this.guardaDados(file);
                    break;
                case 7 :    //opção "Guardar e sair"
                    String saveFile = menuSetup.pedeString("Insira o nome do ficheiro para guardar");
                    this.guardaDados(saveFile);
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
                    String ext = menuApp.pedeString("Enter para continuar");
                    break; //opção "Mostrar informações"
                case 6 :    //opção "Consultar estatísticas"
                    this.runQueries();
                    break;
                case 7 :    //opção "Guardar estado"
                    String nomeFicheiro = menuApp.pedeString("Insira o nome do ficheiro para guardar");
                    this.guardaDados(nomeFicheiro);
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
                    break;
                case 2 :    //opção "Recorde atividades realizadas"
                    LocalDate dataInicio = this.menuEstatisticas.pedeData("Insira data inicial");
                    LocalDate dataFim = this.menuEstatisticas.pedeData("Insira data final");
                    Utilizador user = this.model.maisAtividades(dataInicio,dataFim);
                    System.out.println(user.toString());
                    break;
                case 3 : ;
                case 4 : ;
                case 5 : ;
                case 6 : ;
                case 7 : ;
                case 8 : ;
                case 9 : ;
            }
            menuEstatisticas.runMenu();
            op = menuEstatisticas.getOpcao();
        }
    }
}
