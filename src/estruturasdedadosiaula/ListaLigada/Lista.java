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
public class Lista<T extends Comparable<T>> {

    private No<T> inicio, fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public No<T> getInicio() {
        return this.inicio;
    }

    public boolean estaNulo(No<T> objeto) {
        return objeto == null;
    }

    private boolean estaVazia() {
        return estaNulo(this.inicio);
    }

    private No<T> criaNo(T objeto) {
        return new No<T>(objeto);
    }

    public void adiciona(T objeto) {
        No<T> novoNo = criaNo(objeto);
        if (estaVazia()) {
            this.inicio = this.fim = novoNo;
        } else {
            this.fim.setProximo(novoNo);
            this.fim = novoNo;
        }
    }

    public T busca(T objeto) {
        No<T> ponteiro = this.inicio;
        while (!estaNulo(ponteiro) && (objeto.compareTo(ponteiro.getChave()) != 0)) {
            ponteiro = ponteiro.getProximo();
        }
        if (!estaNulo(ponteiro)) {
            return ponteiro.getChave();
        }
        return null;
    }
    
    /**
     *
     * @param objeto
     * @return
     */
    public T remove(T objeto) {
        No<T> anterior, ponteiro = this.inicio;
        anterior = null;
        while (!estaNulo(ponteiro) && (objeto.compareTo(ponteiro.getChave()) != 0)) {
            anterior = ponteiro;
            ponteiro = ponteiro.getProximo();
        }
        if (!estaNulo(ponteiro)) {
            return ponteiro.getChave();
        }
        
        //CONCLUIR AQUI
        return null;
    }
    
    
}
