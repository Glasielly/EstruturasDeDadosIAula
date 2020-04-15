/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.TrabalhoPratico4;

import estruturasdedadosiaula.ListaDuplamenteLigada.*;
import java.io.*;

/**
 *
 * @author glasy
 */
public class PlayList {

    ListaDuplaCircular<Musica> listaDeMusicas;

    public PlayList() {
        listaDeMusicas = new ListaDuplaCircular<>();
    }

    public void adicionaMusica(String nomeDaMusica, String nomeDoCantor) {
        this.listaDeMusicas.insere(new Musica(nomeDaMusica, nomeDoCantor));
    }

    public void removerMusica(String nomeDaMusica, String nomeDoCantor) {
        this.listaDeMusicas.remove(new Musica(nomeDaMusica, nomeDoCantor));
    }

    public Musica avancaMusica(Musica musica) {
        NoDuplo<Musica> musicaBuscada = listaDeMusicas.buscaNo(musica);
        if (musicaBuscada != null) {
            return musicaBuscada.getProximo().getChave();
        }
        return null;
    }

    public Musica retrocedeMusica(Musica musica) {
        NoDuplo<Musica> musicaBuscada = listaDeMusicas.buscaNo(musica);
        if (musicaBuscada != null) {
            return musicaBuscada.getAnterior().getChave();
        }
        return null;
    }

    public void imprime() {
        NoDuplo<Musica> ponteiroMusica = this.listaDeMusicas.getInicio();
        System.out.println("-----------------PlayList-----------------");
        if (!this.listaDeMusicas.estaVazia()) {
            do {
                System.out.println(ponteiroMusica.getChave().toString());
                ponteiroMusica = ponteiroMusica.getProximo();
            } while (ponteiroMusica != this.listaDeMusicas.getInicio());
        }
        System.out.println("-------------------------------------------\n");
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PlayList playlist = new PlayList();
        int numDeMusica, opcao;
        String musicaCantor[], navegador;
        numDeMusica = Integer.parseInt(br.readLine());
        
         while (numDeMusica > 0) {
            musicaCantor = br.readLine().split("--");
            playlist.adicionaMusica(musicaCantor[0], musicaCantor[1]);
            numDeMusica--;
        }
        playlist.imprime();
        
        musicaCantor = br.readLine().split("--");
        
        opcao = Integer.parseInt(br.readLine());
        Musica musicaEscolhida;
        musicaEscolhida = new Musica(musicaCantor[0], musicaCantor[1]);
        switch(opcao){
            case  1:
                navegador = br.readLine();
                do{ 
                    if(navegador.equals(">>")){
                        musicaEscolhida = playlist.avancaMusica(musicaEscolhida);
                        System.out.print(">> ");
                    }
                    if(navegador.equals("<<")){
                        musicaEscolhida = playlist.retrocedeMusica(musicaEscolhida);
                        System.out.print("<< ");
                    }
                    System.out.println(musicaEscolhida.toString());
                    navegador = br.readLine();
                }while(!navegador.equalsIgnoreCase("0"));
                break;
            case 2:
                playlist.removerMusica(musicaCantor[0], musicaCantor[1]);
                playlist.imprime();
                break;
            default:
                break;
        }
        
    }

}
