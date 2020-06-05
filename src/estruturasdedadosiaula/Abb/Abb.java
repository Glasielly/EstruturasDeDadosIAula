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
public class Abb<T extends Comparable<T>> {

    private No<T> raiz;

    public Abb() {
        this.raiz = null;
    }

    public boolean busca(T x) {
        No<T> ptr = busca(x, this.raiz);
        return ptr != null && x.compareTo(ptr.getValor()) == 0;
    }

    private No<T> busca(T x, No<T> ptr) {
        No<T> pai = null;
        while (ptr != null) {
            if (x.compareTo(ptr.getValor()) == 0) {
                return ptr;
            }
            pai = ptr;
            if (x.compareTo(ptr.getValor()) < 0) {
                ptr = ptr.getEsquerdo();
            } else {
                ptr = ptr.getDireito();
            }
        }
        return pai;
    }

    public No<T> insere(T x) {
        No<T> ptr = busca(x, this.raiz);
        No<T> novo = new No<>(x);
        if (ptr == null) {
            this.raiz = novo;
        } else {
            if (x.compareTo(ptr.getValor()) == 0) {
                return null;
            }
            if (x.compareTo(ptr.getValor()) < 0) {
                ptr.setEsquerdo(novo);
            } else {
                ptr.setDireito(novo);
            }
        }
        return novo;
    }

    public T remove(T x) {
        No<T> pai = null, ptr = this.raiz;
        while (ptr != null) {
            if (x.compareTo(ptr.getValor()) == 0) {
                if (ptr.getEsquerdo() != null && ptr.getDireito() != null) {//se ptr tem dois filhos
                    removeMenorDaDireita(ptr);
                } else {
                    removeNoComZeroOuUmFilho(ptr, pai);
                }
            }
            pai = ptr;
            if (x.compareTo(ptr.getValor()) < 0) {
                ptr = ptr.getEsquerdo();
            } else {
                ptr = ptr.getDireito();
            }
        }
        return x;
    }

    public void emOrdem() {
        System.out.println("---Imprime Árvore---");
        emOrdem(this.raiz);
        System.out.println("\n--------------------");
    }

    private void emOrdem(No<T> ptr) {
        if (ptr == null) {
            return;
        }
        emOrdem(ptr.getEsquerdo());
        System.out.print(ptr.getValor() + " ");
        emOrdem(ptr.getDireito());
    }

    private void removeMenorDaDireita(No<T> ptr) {
        No<T> auxiliar, paiDoAuxiliar;
        auxiliar = ptr.getDireito();
        paiDoAuxiliar = ptr;
        while (auxiliar.getEsquerdo() != null) {
            paiDoAuxiliar = auxiliar;
            auxiliar = auxiliar.getEsquerdo();
        }
        removeNoComZeroOuUmFilho(auxiliar, paiDoAuxiliar);
        ptr.setValor(auxiliar.getValor());
    }

    private void removeNoComZeroOuUmFilho(No<T> ptr, No<T> pai) {
        if(ptr.getEsquerdo()!=null){
            if(ptr == this.raiz) this.raiz = this.raiz.getEsquerdo();
            else{
                if(ptr.getValor().compareTo(pai.getValor())>0) pai.setDireito(ptr.getEsquerdo());
                else pai.setEsquerdo(ptr.getEsquerdo());
            }
        }
        else{
            if(ptr == this.raiz) {
                this.raiz = this.raiz.getDireito();
            }else{
                if(ptr.getValor().compareTo(pai.getValor())>0) pai.setDireito(ptr.getDireito());
                else pai.setEsquerdo(ptr.getDireito());
            }
        }
    }
}
