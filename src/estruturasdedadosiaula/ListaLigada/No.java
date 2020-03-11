/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.ListaLigada;

/**
 *
 * @author Glasielly
 * @param <T>
 */
public class No<T> {
    private T chave;
    private No<T> proximo;
    
    public No(T chave){
        this.chave = chave;
        this.proximo = null;
    }

    /**
     * @return the chave
     */
    public T getChave() {
        return chave;
    }

    /**
     * @param chave the chave to set
     */
    public void setChave(T chave) {
        this.chave = chave;
    }

    /**
     * @return the proximo
     */
    public No<T> getProximo() {
        return proximo;
    }

    /**
     * @param proximo the proximo to set
     */
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
    
}
