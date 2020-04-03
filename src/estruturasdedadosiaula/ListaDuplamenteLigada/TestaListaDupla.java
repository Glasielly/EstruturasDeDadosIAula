/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.ListaDuplamenteLigada;

/**
 *
 * @author glasy
 */
public class TestaListaDupla {
    
    public static void main(String[] args) {
        
        ListaDupla<Integer> listaDeInteiros = new ListaDupla<>();
        
        
//        listaDeMusicas.insere(new Musica("Stand By Me", "The Drifters"));
//        listaDeMusicas.imprime();
//        listaDeMusicas.insere(new Musica("Velha e Louca", "Malu Magalhães"));
//        listaDeMusicas.imprime();
//        listaDeMusicas.insere(new Musica("Fix You", "Cold Play"));
//        listaDeMusicas.imprime();
        
        
        
//        NoDuplo<Musica> ptr = listaDeMusicas.getInicio();
//        while(!listaDeMusicas.estaNulo(ptr)){
//            ptr.getChave().imprime();
//            ptr = ptr.getProximo();
//        }

        
        listaDeInteiros.insere(10);
        listaDeInteiros.imprime();
        listaDeInteiros.insere(34);
        listaDeInteiros.imprime();
        listaDeInteiros.insere(87);
        listaDeInteiros.imprime();
        listaDeInteiros.insere(5);
        listaDeInteiros.imprime();
        listaDeInteiros.insere(1);
        listaDeInteiros.imprime();
        listaDeInteiros.insere(20);
        listaDeInteiros.imprime();
        listaDeInteiros.insere(92);
        listaDeInteiros.imprime();
//        
//        listaDeInteiros.remove(1);
//        listaDeInteiros.imprime();
//        
//        listaDeInteiros.remove(92);
//        listaDeInteiros.imprime();
//        
//        listaDeInteiros.remove(87);
//        listaDeInteiros.imprime();
        
        
        System.out.println(listaDeInteiros.busca(20));
        System.out.println(listaDeInteiros.busca(1));
        System.out.println(listaDeInteiros.busca(92));
        System.out.println(listaDeInteiros.busca(12));
        
    }
    
}
