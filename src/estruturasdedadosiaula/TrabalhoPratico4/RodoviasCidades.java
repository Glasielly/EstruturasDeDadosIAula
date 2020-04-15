/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.TrabalhoPratico4;

import estruturasdedadosiaula.ListaDuplamenteLigada.*;
import estruturasdedadosiaula.ListaLigada.*;
import java.io.*;

/**
 *
 * @author glasy
 */
public class RodoviasCidades {

    Lista<Rodovia> listaDeRodovias;

    public RodoviasCidades() {
        listaDeRodovias = new Lista<>();
    }

    public void adicionaRodovia(String nomeRodovia) {
        this.listaDeRodovias.emOrdem(new Rodovia(nomeRodovia));
    }

    public boolean insereCidade(String nomeRodovia, String nomeCidade) {

        Rodovia objetoRodovia = this.listaDeRodovias.busca(new Rodovia(nomeRodovia));
        if (objetoRodovia != null) {
            objetoRodovia.getListaDeCidades().insere(new Cidade(nomeCidade));
            return true;
        }
        return false;
    }

    public Lista<String> rodoviasCidade(String nomeCidade) {
        Lista<String> listaDeRodoviasDaCidade = new Lista<>();
        No<Rodovia> ponteiroRodovia = this.listaDeRodovias.getInicio();
        Cidade cidadeBuscada = new Cidade(nomeCidade);
        while (ponteiroRodovia != null) {
            if (ponteiroRodovia.getChave().getListaDeCidades().busca(cidadeBuscada) != null) {
                listaDeRodoviasDaCidade.emOrdem(ponteiroRodovia.getChave().getNomeDaRodovia());
            }
            ponteiroRodovia = ponteiroRodovia.getProximo();
        }
        if (listaDeRodoviasDaCidade.estaVazia()) {
            return null;
        }
        return listaDeRodoviasDaCidade;
    }
    
    public boolean cruzamento (String nomeRodovia1, String nomeRodovia2){
        Rodovia rodovia1 = this.listaDeRodovias.busca(new Rodovia(nomeRodovia1));
        NoDuplo<Cidade> ponteiroCidade = rodovia1.getListaDeCidades().getInicio();
        while(ponteiroCidade!=null){
            Lista<String> listaDeRodoviasDaCidade = this.rodoviasCidade(ponteiroCidade.getChave().getNomeCidade());
            if(listaDeRodoviasDaCidade.busca(nomeRodovia2)!=null){
                return true;
            }
            ponteiroCidade = ponteiroCidade.getProximo();
        }
        return false;
    }
    
    
    public void imprime(){
        No<Rodovia> ponteiroRodovia = this.listaDeRodovias.getInicio();
        while (ponteiroRodovia != null) {
            System.out.println(ponteiroRodovia.getChave().toString());
            ponteiroRodovia = ponteiroRodovia.getProximo();
        }
    }
    

    public static void main(String[] args) throws IOException {

        RodoviasCidades rc = new RodoviasCidades();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numeroDeRodovias, numeroDeCidades, numeroDeCruzamentos;
        String[] rodoviaCidade;
        numeroDeRodovias = Integer.parseInt(br.readLine());
        
        while (numeroDeRodovias > 0) {
            rc.adicionaRodovia(br.readLine());
            numeroDeRodovias--;
        }
        //rc.imprime();
        
        numeroDeCidades = Integer.parseInt(br.readLine());
        
        while (numeroDeCidades > 0) {
            rodoviaCidade = br.readLine().split(" -- ");
            rc.insereCidade(rodoviaCidade[0], rodoviaCidade[1]);
            numeroDeCidades--;
        }
        rc.imprime();
////        
////        String cidade = "Sao Paulo";
////        Lista<String> listaRodovias = rc.rodoviasCidade(cidade);
////        
////        No<String> ponteiro = listaRodovias.getInicio();
////        System.out.println("Lista De Rodovias que passam na cidade " + cidade);
////        while(ponteiro!=null){
////            System.out.print(ponteiro.getChave() + " ");
////            ponteiro = ponteiro.getProximo();
////        }
        
        numeroDeCruzamentos = Integer.parseInt(br.readLine());
        
        while (numeroDeCruzamentos > 0) {
            rodoviaCidade = br.readLine().split(" -- ");
            System.out.println(rc.cruzamento(rodoviaCidade[0], rodoviaCidade[1]));
            numeroDeCruzamentos--;
        }
        
    }

}
