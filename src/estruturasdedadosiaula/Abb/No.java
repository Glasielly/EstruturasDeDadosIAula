/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.Abb;

/**
 *
 * @author glasy
 * @param <T>
 */
public class No<T> {
    
    private T valor;
    private No<T> esquerdo, direito;
    
    public No(T valor){
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }

    /**
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return the esquerdo
     */
    public No<T> getEsquerdo() {
        return esquerdo;
    }

    /**
     * @param esquerdo the esquerdo to set
     */
    public void setEsquerdo(No<T> esquerdo) {
        this.esquerdo = esquerdo;
    }

    /**
     * @return the direito
     */
    public No<T> getDireito() {
        return direito;
    }

    /**
     * @param direito the direito to set
     */
    public void setDireito(No<T> direito) {
        this.direito = direito;
    }
    
    
    
}
