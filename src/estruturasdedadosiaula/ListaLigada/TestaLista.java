/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.ListaLigada;

/**
 *
 * @author Glasielly
 */
public class TestaLista {
    
    public static void main(String[] args) {
        Lista<String> listaDeInteiros;
        listaDeInteiros = new Lista<>();
        
        listaDeInteiros.adicionaFim("glasidemori@gmail.com");
        listaDeInteiros.adicionaFim("caiquedugaich@gmail.com");
        listaDeInteiros.adicionaFim("walmir004@gmail.com");
        listaDeInteiros.adicionaFim("emailfake@hotmail.com");
        
       listaDeInteiros.imprime();
       
        System.out.println("Removeu o email: " + listaDeInteiros.remove("emailfake@hotmail.com"));
       
        listaDeInteiros.imprime();
        //System.out.println("resultado da busca " + listaDeInteiros.busca("emailfake@outlook.com"));
            
              
    }
    
}
