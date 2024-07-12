/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.lista_encadeada.listaSimples;

/**
 *
 * @author rodol
 */
public class ListaEncadeada<E> {

    private No<E> cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void adicionar(E conteudo) {
        if (cabeca == null) {
            cabeca = new No<E>(conteudo, null);
        } else {
            No<E> ponteiro = cabeca;
            for (; ponteiro.proximo != null; ponteiro = ponteiro.proximo) {
            }
            ponteiro.proximo = new No<E>(conteudo, null);
        }
        tamanho++;
    }

    public int contarNos() {
        if (cabeca == null) {
            return 0;
        }

        int quantidade = 0;
        No<E> ponteiro = cabeca;
        for (; ponteiro != null; ponteiro = ponteiro.proximo) {
            quantidade++;
        }
        return quantidade;
    }
    
    public No encontrar(int i){
        if(i > tamanho){
            return null;
        }
        No<E> ponteiro = cabeca;
        for (int j = 0; j < i; j++) {
            ponteiro = ponteiro.proximo;
        }
        return ponteiro;
    }
    
    public No remover(int i){
        if(i > tamanho){
            return null;
        }
        
        No<E> ponteiro = encontrar(i-1);
        No<E> retorno = ponteiro.proximo;
        
        ponteiro.proximo = ponteiro.proximo.proximo;
        
        return retorno;
    }
    
    public void imprimir() {
        No<E> ponteiro = cabeca;
        System.out.println("Lista Simples");
        for (; ponteiro != null; ponteiro = ponteiro.proximo) {
            System.out.println(ponteiro);
        }
    }
}
