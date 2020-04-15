/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.TrabalhoPratico4;

/**
 *
 * @author glasy
 */
public class Cidade implements Comparable<Cidade> {
    
    private String nomeCidade;
    
    public Cidade(String nomeCidade){
        this.nomeCidade = nomeCidade;
    }

    @Override
    public int compareTo(Cidade o) {
        return this.getNomeCidade().compareToIgnoreCase(o.getNomeCidade());       
    }

    /**
     * @return the nomeCidade
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     * @param nomeCidade the nomeCidade to set
     */
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    
}
