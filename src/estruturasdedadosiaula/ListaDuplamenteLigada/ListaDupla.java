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
public class ListaDupla<T extends Comparable<T>> {

    private NoDuplo<T> inicio, fim;
    private int size;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.size = 0;
    }

    public boolean estaNulo(NoDuplo<T> objeto) {
        return objeto == null;
    }

    private boolean estaVazia() {
        return estaNulo(this.inicio);
    }

    private NoDuplo<T> criaNo(T objeto) {
        return new NoDuplo<>(objeto);
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
     * @return the fim
     */
    public NoDuplo<T> getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(NoDuplo<T> fim) {
        this.fim = fim;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    private NoDuplo<T> buscaPosicaoParaInserir(T chave) {
        NoDuplo<T> ptr = this.inicio;
        while (!estaNulo(ptr) && chave.compareTo(ptr.getChave()) > 0) {
            ptr = ptr.getProximo();
        }
        return ptr;
    }

    private void insereNoFim(NoDuplo<T> novo) {
        this.fim.setProximo(novo);
        novo.setAnterior(this.fim);
        this.fim = novo;
    }

    private void insereNoInicio(NoDuplo<T> novo) {
        novo.setProximo(this.inicio);
        this.inicio.setAnterior(novo);
        this.inicio = novo;
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
            this.inicio = this.fim = novo;
        } else {
            NoDuplo<T> retornoDaBusca = buscaPosicaoParaInserir(chave);
            if (estaNulo(retornoDaBusca)) {
                this.insereNoFim(novo);
            } else if (retornoDaBusca.equals(this.inicio)) {
                this.insereNoInicio(novo);
            } else {
                this.insereAntesDoPtr(novo, retornoDaBusca);
            }
        }
        this.size += 1;
    }
    
    public T busca(T chave){
        NoDuplo<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)){
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

    private void removeOInicio() {
        this.inicio = this.inicio.getProximo();
        if (this.size == 1) {
            this.fim = this.inicio;
        } else {
            this.inicio.setAnterior(null);
        }
    }
    
    private void removeOFim(){
        this.fim = this.fim.getAnterior();
        this.fim.setProximo(null);
    }
    
    private void removePtr(NoDuplo<T> ptr){
        ptr.getAnterior().setProximo(ptr.getProximo());
        ptr.getProximo().setAnterior(ptr.getAnterior());
    }

    public NoDuplo<T> remove(T chave) {
        NoDuplo<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)) {
            if(retornoDaBusca.equals(this.inicio)){
                this.removeOInicio();
            }else if(retornoDaBusca.equals(this.fim)){
                this.removeOFim();
            }else{
                this.removePtr(retornoDaBusca);
            }
            this.size -= 1;
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
