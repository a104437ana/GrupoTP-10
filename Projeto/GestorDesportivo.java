package Projeto;
import java.time.*;
import java.util.*;
import java.io.*;

/**
 * Classe GestorDesportivo, que corresponde à lógica de negócio da aplicação / model
 *
 * @author Grupo10
 * @version 09/05/24
 * Notas versão :
 */
public class GestorDesportivo
{
    private LocalDate dataAtual;
    private Map<String, Utilizador> utilizadores;
    
    public GestorDesportivo(){
        this.dataAtual = LocalDate.now();
        this.utilizadores = new HashMap<String, Utilizador>();
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
     * Método maisCaloriasGastas, que calcula qual utilizador dispendeu mais calorias num período ou desde sempre
     */
    public Utilizador maisCaloriasGastas(LocalDate dataInicio, LocalDate dataFim){
        Utilizador utilizador = null;
        double maxCalorias = 0;
        double calorias;
        for (Utilizador u : this.utilizadores.values()) {
            calorias = u.totalCaloriasDispendidas(dataInicio, dataFim);
            if (maxCalorias < calorias) {
                maxCalorias = calorias;
                utilizador = (Utilizador) u.clone();
            }
            calorias = 0;
        }
        return utilizador;
    }
}
