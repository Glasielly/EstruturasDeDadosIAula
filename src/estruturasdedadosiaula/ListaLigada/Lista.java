
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

    public boolean estaVazia() {
        return estaNulo(this.inicio);
    }

    private No<T> criaNo(T objeto) {
        return new No<>(objeto);
    }

    public void emOrdem(T objeto) {
        No<T> novoNo = criaNo(objeto), anterior = null, ptr = this.inicio;
        if (estaVazia()) {
            this.inicio = this.fim = novoNo;
        } else {
            while (!estaNulo(ptr) && objeto.compareTo(ptr.getChave()) > 0) {
                anterior = ptr;
                ptr = ptr.getProximo();
            }

            if (estaNulo(anterior)) {
                novoNo.setProximo(this.inicio);
                this.inicio = novoNo;
            } else {
                anterior.setProximo(novoNo);
                novoNo.setProximo(ptr);
                if (estaNulo(ptr)) {
                    this.fim = novoNo;
                }
            }
        }
    }

    public void adicionaFim(T objeto) {
        No<T> novoNo = criaNo(objeto);
        if (estaVazia()) {
            this.inicio = this.fim = novoNo;
        } else {
            this.fim.setProximo(novoNo);
            this.fim = novoNo;
        }
    }

    public void adicionaInicio(T objeto) {
        No<T> novoNo = criaNo(objeto);
        if (estaVazia()) {
            this.inicio = this.fim = novoNo;
        } else {
            novoNo.setProximo(this.inicio);
            this.inicio = novoNo;
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
            if (estaNulo(anterior)) {
                this.inicio = ponteiro.getProximo();
                if (ponteiro.equals(this.fim)) {
                    this.fim = ponteiro.getProximo();
                }
            } else {
                anterior.setProximo(ponteiro.getProximo());
                if (estaNulo(ponteiro.getProximo())) {
                    this.fim = anterior;
                }
            }
            return ponteiro.getChave();
        }
        return null;
    }

    public void imprime() {
        No<T> ptr = this.inicio;
        System.out.println("LISTA----");
        while (!estaNulo(ptr)) {
            System.out.println(ptr.getChave() + " ");
            ptr = ptr.getProximo();
        }
        System.out.println("------");
    }

}
