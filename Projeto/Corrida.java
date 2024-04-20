/**
 * Classe Corrida
 *
 * @author Grupo10
 * @version 20/04/24
 * Notas versão : Falta definir toString e consumoCalorias
 */
public class Corrida extends AtivDistância
{
    /**
     * Construtores de Corrida
     */
    
    /**
     * Construtor vazio
     */
    public Corrida()
    {
        super();
    }
    
    /**
     * Construtor parametrizado
     */
    public Corrida(int tempo, int freqCardiaca, double distância)
    {
        super(tempo, freqCardiaca, distância);
    }
    
    /**
     * Construtor de cópia
     */
    public Corrida(Corrida umaCorrida)
    {
        super(umaCorrida);
    }
    
    /**
     * Método que calcula o consumo de calorias de uma corrida
     *
     * @param  utilizador  utilizador que realiza a atividade
     * @return    consumo de calorias da corrida
     */
    public int consumoCalorias(Utilizador utilizador){
        
    }

    /**
     * Método toString
     */
    public String toString(){
        
    }

    /**
     * Método clone
     */
    public Object clone(){
        Corrida c = new Corrida(this);
        return c;
    }
}