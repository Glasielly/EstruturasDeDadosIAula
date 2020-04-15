/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.TrabalhoPratico4;

import estruturasdedadosiaula.ListaDuplamenteLigada.ListaDupla;
import estruturasdedadosiaula.ListaDuplamenteLigada.NoDuplo;

/**
 *
 * @author glasy
 */
public class Rodovia implements Comparable<Rodovia> {

    private String nomeDaRodovia;
    private ListaDupla<Cidade> listaDeCidades;

    public Rodovia(String nomeDaRodovia) {
        this.nomeDaRodovia = nomeDaRodovia;
        listaDeCidades = new ListaDupla<>();
    }

    public void adicionaCidade(Cidade cidade) {
        this.listaDeCidades.insere(cidade);
    }

    /**
     * @return the nomeDaRodovia
     */
    public String getNomeDaRodovia() {
        return nomeDaRodovia;
    }

    /**
     * @param nomeDaRodovia the nomeDaRodovia to set
     */
    public void setNomeDaRodovia(String nomeDaRodovia) {
        this.nomeDaRodovia = nomeDaRodovia;
    }

    /**
     * @return the listaDeCidades
     */
    public ListaDupla<Cidade> getListaDeCidades() {
        return listaDeCidades;
    }

    @Override
    public int compareTo(Rodovia o) {
        return this.nomeDaRodovia.compareToIgnoreCase(o.getNomeDaRodovia());
    }

    @Override
    public String toString() {
        String saida = "";
        saida += this.nomeDaRodovia + " [ ";
        NoDuplo<Cidade> ponteiroCidade = this.listaDeCidades.getInicio();
        while (ponteiroCidade != null) {
            saida += ponteiroCidade.getChave().getNomeCidade() + " -> ";
            ponteiroCidade = ponteiroCidade.getProximo();
        }
        if (this.listaDeCidades.getInicio() != null) {
            saida = saida.substring(0, saida.length() - 4);
        }

        saida += " ]";
        return saida;
    }
}
