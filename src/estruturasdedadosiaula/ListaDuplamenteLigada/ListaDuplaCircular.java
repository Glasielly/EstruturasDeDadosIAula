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
public class ListaDuplaCircular<T extends Comparable<T>> {

    private NoDuplo<T> inicio;
    private int size;

    public ListaDuplaCircular() {
        this.inicio = null;
        this.size = 0;
    }

    public boolean estaNulo(NoDuplo<T> objeto) {
        return objeto == null;
    }

    public boolean estaVazia() {
        return estaNulo(this.inicio);
    }

    private NoDuplo<T> criaNo(T objeto) {
        return new NoDuplo<>(objeto);
    }

    private void adicionaPrimeiroNo(NoDuplo<T> novo) {
        novo.setAnterior(novo);
        novo.setProximo(novo);
        this.inicio = novo;
    }

    /**
     * @return the inicio
     */
    public NoDuplo<T> getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(NoDuplo<T> inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    private NoDuplo<T> buscaPosicaoParaInserir(T chave) {
        NoDuplo<T> ptr = null;
        if (!estaVazia()) {
            ptr = this.inicio;
            while (!ptr.getProximo().equals(this.inicio) && chave.compareTo(ptr.getChave()) > 0) {
                ptr = ptr.getProximo();
            }
        }
        return ptr;
    }

    private void insereDepoisDoPtr(NoDuplo<T> novo, NoDuplo<T> ptr) {
        insereAntesDoPtr(novo, ptr.getProximo());
    }

    private void insereAntesDoPtr(NoDuplo<T> novo, NoDuplo<T> ptr) {
        novo.setAnterior(ptr.getAnterior());
        novo.setProximo(ptr);
        ptr.getAnterior().setProximo(novo);
        ptr.setAnterior(novo);
    }

    public void insere(T chave) {
        NoDuplo<T> novo = criaNo(chave);
        if (estaVazia()) {
            this.adicionaPrimeiroNo(novo);
        } else {
            NoDuplo<T> retornoDaBusca = buscaPosicaoParaInserir(chave);
            if (chave.compareTo(retornoDaBusca.getChave()) > 0) {
                this.insereDepoisDoPtr(novo, retornoDaBusca);
            } else {
                this.insereAntesDoPtr(novo, retornoDaBusca);
                if (retornoDaBusca.equals(this.inicio)) {
                    this.inicio = novo;
                }
            }
        }
        this.size += 1;
    }
    
    /**
     *
     * @param chave é um objeto do tipo T
     * @return um objeto NoDuplo de T
     */
    public NoDuplo<T> buscaNo(T chave) {
        NoDuplo<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)) {
            return retornoDaBusca;
        }
        return null;
    }

    public T busca(T chave) {
        NoDuplo<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)) {
            return retornoDaBusca.getChave();
        }
        return null;
    }

    private NoDuplo<T> buscaParaRemover(T chave) {
        NoDuplo<T> retornoDaBusca = buscaPosicaoParaInserir(chave);
        if (!estaNulo(retornoDaBusca) && retornoDaBusca.getChave().compareTo(chave) == 0) {
            return retornoDaBusca;
        }
        return null;
    }

    private void removePtr(NoDuplo<T> ptr) {
        ptr.getAnterior().setProximo(ptr.getProximo());
        ptr.getProximo().setAnterior(ptr.getAnterior());
    }

    public NoDuplo<T> remove(T chave) {
        NoDuplo<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)) {
            if (this.size == 1) {
                this.inicio = null;
            } else {
                this.removePtr(retornoDaBusca);
                if (retornoDaBusca.equals(this.inicio)) {
                    this.inicio = this.inicio.getProximo();
                }
                this.size -= 1;
            }
            return retornoDaBusca;
        }
        return null;
    }

    public void imprime() {
        NoDuplo<T> ptr = this.inicio;
        System.out.println("LISTA----");
        while (!estaNulo(ptr)) {
            System.out.print(ptr.getChave().toString() + " ");
            ptr = ptr.getProximo();
        }
        System.out.println("------");
    }

}
