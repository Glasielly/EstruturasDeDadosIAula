/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.ListaDuplamenteLigada;

/**
 *
 * @author glasy
 */
public class Musica implements Comparable<Musica> {

    private String nomeDaMusica;
    private String nomeDoCantor;

    public Musica(String nomeDaMusica, String nomeDoCantor) {
        this.nomeDaMusica = nomeDaMusica;
        this.nomeDoCantor = nomeDoCantor;
    }

    @Override
    public int compareTo(Musica o) {
        int retornoDaComparacaoDosNomesDasMusicas = this.nomeDaMusica.compareToIgnoreCase(o.getNomeDaMusica());
        if (retornoDaComparacaoDosNomesDasMusicas == 0) {
            return this.nomeDoCantor.compareToIgnoreCase(o.getNomeDoCantor());
        }
        return retornoDaComparacaoDosNomesDasMusicas;
    }

    /**
     * @return the nomeDaMusica
     */
    public String getNomeDaMusica() {
        return nomeDaMusica;
    }

    /**
     * @param nomeDaMusica the nomeDaMusica to set
     */
    public void setNomeDaMusica(String nomeDaMusica) {
        this.nomeDaMusica = nomeDaMusica;
    }

    /**
     * @return the nomeDoCantor
     */
    public String getNomeDoCantor() {
        return nomeDoCantor;
    }

    /**
     * @param nomeDoCantor the nomeDoCantor to set
     */
    public void setNomeDoCantor(String nomeDoCantor) {
        this.nomeDoCantor = nomeDoCantor;
    }
    
    @Override
    public String toString(){
        return this.nomeDaMusica + " -- " + this.nomeDoCantor;
    }
    
    public void imprime(){
        System.out.println(this.nomeDaMusica + " -- " + this.nomeDoCantor);
    }

}
