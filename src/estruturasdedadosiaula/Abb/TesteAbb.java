/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.Abb;

/**
 *
 * @author glasy
 */
public class TesteAbb {
    
    public static void main(String[] args) {
        Abb<Integer> abb = new Abb<>();
        abb.insere(50);
        abb.insere(30);
        abb.insere(6);
        abb.insere(70);
        abb.insere(53);
        abb.insere(22);
        abb.insere(36);
        abb.emOrdem();
        
        abb.remove(22);
        abb.remove(6);
        abb.remove(53);
        abb.remove(30);
        abb.emOrdem();
    }
    
}
