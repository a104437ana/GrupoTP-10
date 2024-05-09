package Projeto;
import java.util.*;

/**
 * Classe Menu, que implementa uma interface em modo texto
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão : Falta ter opções indisponíveis
 */
public class Menu
{
    private List<String> opcoes;
    private int op;
    
    /**
     * Construtor de Menu
     */
    public Menu(String[] opcoes){
        this.opcoes = Arrays.asList(opcoes);
        this.op=-1;
    }
    
    public int getOpcao(){
        return this.op;
    }
    
    /**
     * Método runMenu, que mostra o menu e lê uma opção
     */
    public void runMenu(){
        this.op = -1;
        while (this.op == -1){
            this.mostraMenu();
            this.op = this.lerOpcao();
        }
    }
    
    /**
     * Método mostraMenu, que imprime as opções disponíveis
     */
    public void mostraMenu(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-------------Menu-------------");
        int i;
        for (i=0; i<this.opcoes.size(); i++){
            System.out.print("Opção ");
            System.out.print(i+1);
            System.out.print(": ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.println("Opção 0: Sair");
    }
    
    /**
     * Método lerOpcao, que lê a opção selecionada
     */
    public int lerOpcao(){
        int op;
        Scanner scan = new Scanner(System.in);
        System.out.print("Opção: ");
        try{
            op = scan.nextInt();
        }
        catch (InputMismatchException e){
            op = -1;
        }
        if(op<0 || op>this.opcoes.size()){
            System.out.println("Opção inválida");
            op=-1;
        }
        return op;
    }
    
    /**
    * Método pedeInput
    */
    public String pedeInput(String mensagem){
        System.out.println(mensagem);
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }
}

