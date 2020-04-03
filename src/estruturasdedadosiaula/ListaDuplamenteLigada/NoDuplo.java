/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.ListaDuplamenteLigada;
/**
 *
 * @author glasy
 * @param <T>
 */
public class NoDuplo<T>{
    
    private T chave;
    private NoDuplo<T> proximo, anterior;
    
    
    public NoDuplo(T chave){
        this.proximo = null;
        this.anterior = null;
        this.chave = chave;
    }
    
    public boolean equals(NoDuplo<T> objeto){
        return this == objeto;
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
    public NoDuplo<T> getProximo() {
        return proximo;
    }

    /**
     * @param proximo the proximo to set
     */
    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    /**
     * @return the anterior
     */
    public NoDuplo<T> getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }
    
   
    
    
    
}
