package Projeto;
import java.util.*;

/**
 * Classe Menu, que implementa uma interface em modo texto
 *
 * @author Grupo10
 * @version 10/05/24
 * Notas versão :
 */
public class Menu
{
    private List<String> opcoes; //opção 0 nesta lista é o nome do menu e a última é o nome da opção de saída
    private int op;
    
    /**
     * Construtor de Menu, recebe a lista com as opções e o nome do menu
     */
    public Menu(String[] opcoes){
        this.opcoes = Arrays.asList(opcoes);
        this.op=-1;
    }
    
    public int getOpcao(){
        return this.op;
    }
    
    /**
     * Método mostraMenu, que imprime as opções disponíveis
     */
    private void mostraMenu(){
        //limpa a tela
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        //imprime o nome do menu
        System.out.print("-------------");
        System.out.print(this.opcoes.get(0));
        System.out.print("-------------\n");
        int i;
        for (i=1; i<this.opcoes.size()-1; i++){
            System.out.print("Opção ");
            System.out.print(i);
            System.out.print(": ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.print("Opção 0: ");
        System.out.println(this.opcoes.get(i));
    }
    
    /**
     * Método lerOpcao, que lê a opção selecionada
     */
    private int lerOpcao(){
        int op;
        Scanner scan = new Scanner(System.in);
        System.out.print("Opção: ");
        try{
            op = scan.nextInt();
        }
        catch (InputMismatchException e){
            op = -1;
        }
        if(op<0 || op>this.opcoes.size()-1){
            System.out.println("Opção inválida");
            op=-1;
        }
        return op;
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
    * Método pedeInput
    * @param mensagem: mensagem para mostrar ao utilizador
    * @returns próxima linha inserida
    */
    public String pedeInput(String mensagem){
        System.out.println(mensagem);
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }
}

