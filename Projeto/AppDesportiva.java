package Projeto;
import java.io.*;

/**
 * Classe AppDesportiva, que corresponde ao programa principal e ao controller
 *
 * @author Grupo10
 * @version 08/05/24
 * Notas versão : Incompleta
 */
public class AppDesportiva
{
    private GestorDesportivo model;
    private Menu menuPrincipal;
    
    /**
     * Construtor de AppDesportiva
     */
    public AppDesportiva()
    {
        this.model = new GestorDesportivo();
        String[] opcoes = {"Carregar ficheiro"};
        this.menuPrincipal = new Menu(opcoes);
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
        String[] opcoes = {"Carregar ficheiro"};
        this.menuPrincipal = new Menu(opcoes);
    }
    
    /**
     * Método main
     */
    public static void main(String[] args){
        if(args.length==0) new AppDesportiva().run();
        else new AppDesportiva(args[0]).run();
    }
    
    /**
     * Método run, que executa o menu, lê e trata as opções escolhidas, enviando a operação pretendida para o model, ou encerrando o programa
     */
    public void run(){
        menuPrincipal.runMenu();
        int op = menuPrincipal.getOpcao();
        while (op!=0){
            switch (op){
                case 1 : ;
                case 2 : ;
            }
            menuPrincipal.runMenu();
            op = menuPrincipal.getOpcao();
        }
        try { //guarda o estado do programa quando este é encerrado
            this.model.guardaEstado("estado.obj");
        }
        catch (IOException e){
            System.out.println("Estado não foi gravado");
        }
        System.out.println("Programa encerrado");
    }
}
