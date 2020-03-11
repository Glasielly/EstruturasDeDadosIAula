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
        
        listaDeInteiros.adiciona("glasidemori@gmail.com");
        listaDeInteiros.adiciona("caiquedugaich@gmail.com");
        listaDeInteiros.adiciona("walmir004@gmail.com");
        listaDeInteiros.adiciona("emailfake@hotmail.com");
        
        No<String> ponteiro = listaDeInteiros.getInicio();
        
        while(!listaDeInteiros.estaNulo(ponteiro)){
            System.out.println(ponteiro.getChave());
            ponteiro = ponteiro.getProximo();
        }
        
        System.out.println("resultado da busca " + listaDeInteiros.busca("emailfake@outlook.com"));
            
              
    }
    
}
