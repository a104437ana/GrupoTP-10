package Projeto;
import java.io.*;

/**
 * Classe AppDesportiva, que corresponde ao programa principal e ao controller
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : Incompleta
 */
public class AppDesportiva
{
    private GestorDesportivo model;
    private Menu menuSetup, menuApp, menuEstatisticas;
    
    /**
     * Construtor de AppDesportiva
     */
    public AppDesportiva()
    {
        this.model = new GestorDesportivo();
        String[] opcoesSetup = {"Carregar estado", "Adicionar utilizador", "Adicionar atividade", "Adicionar plano de treino", "Começar fase de simulação", "Guardar estado", "Guardar e sair"};
        this.menuSetup = new Menu(opcoesSetup);
        String[] opcoesApp = {"Adicionar utilizador", "Registar atividade", "Adicionar plano de treino", "Alterar data", "Mostrar informações", "Consultar estatísticas", "Guardar estado", "Voltar ao setup", "Guardar e sair"};
        this.menuApp = new Menu(opcoesApp);
        String[] opcoesQueries = {"Recorde calorias gastas", "Recorde atividades realizadas", "Atividade mais realizada", "Kms percorridos", "Metros de altimetria", "Record plano de treino", "Atividades utilizador"};
        this.menuEstatisticas = new Menu(opcoesQueries);
    }
    
    /**
     * Construtor de AppDesportiva quando é passado o nome do ficheiro a carregar
     */
    public AppDesportiva(String ficheiro)
    {
        this.model = new GestorDesportivo();
        try{
        this.model.carregaEstado(ficheiro);
        }
        catch (ClassNotFoundException clExc){
            System.out.println("Não foi possível carregar os dados do ficheiro");
        }
        catch (IOException ioExc){
            System.out.println("Não foi possível ler o ficheiro");
        }
        String[] opcoesSetup = {"Carregar estado", "Adicionar utilizador", "Adicionar atividade", "Adicionar plano de treino", "Começar fase de simulação", "Guardar estado" , "Guardar e sair"};
        this.menuSetup = new Menu(opcoesSetup);
        String[] opcoesApp = {"Adicionar utilizador", "Registar atividade", "Adicionar plano de treino", "Alterar data", "Mostrar informações", "Consultar estatísticas", "Guardar estado", "Voltar ao setup", "Guardar e sair"};
        this.menuApp = new Menu(opcoesApp);
        String[] opcoesQueries = {"Recorde calorias gastas", "Recorde atividades realizadas", "Atividade mais realizada", "Kms percorridos", "Metros de altimetria", "Record plano de treino", "Atividades utilizador"};
        this.menuEstatisticas = new Menu(opcoesQueries);
    }
    
    /**
     * Método main
     */
    public static void main(String[] args){
        if(args.length==0) new AppDesportiva().runSetup();
        else new AppDesportiva(args[0]).runSetup();
    }
    
    /**
     * Método runSetup, que executa o menu inicial, lê e trata as opções escolhidas, enviando a operação pretendida para o model, ou encerrando o programa
     */
    public void runSetup(){
        menuSetup.runMenu();
        int op = menuSetup.getOpcao();
        while (op!=0){
            switch (op){
                case 1 :   
                    String ficheiro = menuSetup.pedeInput("Insira o nome do ficheiro a carregar");
                    try{
                        this.model.carregaEstado(ficheiro);
                    }
                    catch (ClassNotFoundException clExc){
                        System.out.println("Não foi possível carregar os dados do ficheiro");
                    }
                    catch (IOException ioExc){
                        System.out.println("Não foi possível ler o ficheiro");
                    }
                    break;
                case 2 : ;
                case 3 : ;
                case 4 : ;
                case 5 : 
                    {
                        int ext = this.runApp();
                        if(ext == 2){
                            op=0;
                        }
                        else if (ext == 1){
                            String nomeFicheiro = menuSetup.pedeInput("Insira o nome do ficheiro para guardar");
                            try {
                                this.model.guardaEstado(nomeFicheiro);
                            }
                            catch (IOException e){
                                System.out.println("Não foi possível guardar o estado");
                            }
                            op=0;
                        }
                    }
                    break;
                case 6 :
                    String file = menuSetup.pedeInput("Insira o nome do ficheiro para guardar");
                    try {
                        this.model.guardaEstado(file);
                    }
                    catch (IOException e){
                        System.out.println("Não foi possível guardar o estado");
                    }
                    break;
                case 7 :
                    String saveFile = menuSetup.pedeInput("Insira o nome do ficheiro para guardar");
                    try {
                        this.model.guardaEstado(saveFile);
                    }
                    catch (IOException e){
                        System.out.println("Não foi possível guardar o estado");
                    }
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
     * Método 
     */
    public int runApp(){
        menuApp.runMenu();
        int op = menuApp.getOpcao();
        while (op!=0){
            switch (op){
                case 1 : ;
                case 2 : ;
                case 3 : ;
                case 4 : ;
                case 5 : ;
                case 6 : 
                    this.runQueries();
                    break;
                case 7 : ;
                case 8 : return 0;
                case 9 : return 1;
            }
            menuApp.runMenu();
            op = menuApp.getOpcao();
        }
        return 2;
    }
    
    public void runQueries(){
        this.menuEstatisticas.runMenu();
        int op = this.menuEstatisticas.getOpcao();
        while (op!=0){
            switch (op){
                case 1 : ;
                case 2 : ;
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
