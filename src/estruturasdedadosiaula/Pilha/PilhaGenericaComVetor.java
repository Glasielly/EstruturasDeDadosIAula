package estruturasdedadosiaula.Pilha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Glasielly
 * @param <T>
 */
public class PilhaGenericaComVetor<T> {

    private T[] pilha;
    private int topo;
    private final int MAX = 5;

    public PilhaGenericaComVetor() {
        this.pilha = (T[]) new Object[MAX];
        this.topo = -1;
    }

    public void empilha(T valor) {
        if (this.topo + 1 >= this.pilha.length) {
            this.aumentarVetor();
        }
        this.topo++;
        this.pilha[topo] = valor;
    }

    private void aumentarVetor() {
        T[] novaPilha;
        novaPilha = (T[]) new Object[this.pilha.length + MAX];

        for (int i = 0; i < this.pilha.length; i++) {
            novaPilha[i] = this.pilha[i];
        }

        this.pilha = novaPilha;
    }

    public void imprimePilha() {
        if (!estaVazia()) {
            System.out.println("PILHA");
            for (int i = this.topo; i >= 0; i--) {
                System.out.println(this.pilha[i]);
            }
            System.out.println("FIM PILHA");
        }

    }

    public boolean estaVazia() {
        return (this.topo == -1);
    }

    public T desempilha() {
        if (estaVazia()) {
            return null;
        }
        T conteudoDoTopo = this.pilha[topo];
        topo--;
        return conteudoDoTopo;
    }
    
    public T getTopo(){
        return this.pilha[this.topo];
    }
    
    public int getTamanho(){
        return this.topo+1;
    }

    public static void main(String[] args) {
        PilhaGenericaComVetor<Integer> pg;
        pg = new PilhaGenericaComVetor<>();

        pg.empilha(30);
        pg.empilha(20);
        pg.empilha(38);
        pg.empilha(9);
        pg.desempilha();
        pg.desempilha();
        pg.desempilha();
        pg.desempilha();
        pg.imprimePilha();

    }

}

