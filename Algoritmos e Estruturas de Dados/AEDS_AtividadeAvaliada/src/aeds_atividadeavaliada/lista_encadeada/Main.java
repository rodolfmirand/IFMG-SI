/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.lista_encadeada;

import aeds_atividadeavaliada.lista_encadeada.listaCircular.ListaCircular;
import aeds_atividadeavaliada.lista_encadeada.listaDupla.ListaDuplamenteEncadeada;
import aeds_atividadeavaliada.lista_encadeada.listaSimples.ListaEncadeada;

/**
 *
 * @author rodol
 */
public class Main {

    public static void main(String[] args) {
        ListaEncadeada<Integer> listaS = new ListaEncadeada<>();
        ListaDuplamenteEncadeada<Integer> listaD = new ListaDuplamenteEncadeada<>();
        ListaCircular<Integer> listaC = new ListaCircular<>();
        
        //Lista Simples
        listaS.adicionar(1);
        listaS.adicionar(2);
        listaS.adicionar(3);
        listaS.adicionar(4);
        listaS.imprimir();

        System.out.println("Quantidade de nós: " + listaS.contarNos());
        System.out.println("Nó desejado: " + listaS.encontrar(1));
        System.out.println("Nó removido: " + listaS.remover(1));
        
        //Lista Dupla
        listaD.adicionar(1);
        listaD.adicionar(2);
        listaD.adicionar(3);
        listaD.adicionar(4);
        listaD.imprimir();
        
        System.out.println("Nó removido: " + listaD.remover(1));
        
        
        //Lista Circular
        listaC.adicionar(1);
        listaC.adicionar(2);
        listaC.adicionar(3);
        listaC.adicionar(4);
        
        listaC.imprimir();
    }
}
