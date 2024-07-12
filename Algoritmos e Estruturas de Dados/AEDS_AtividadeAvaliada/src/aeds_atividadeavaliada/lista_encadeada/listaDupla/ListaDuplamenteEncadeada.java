/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.lista_encadeada.listaDupla;

/**
 *
 * @author rodol
 */
public class ListaDuplamenteEncadeada<E> {

    private NoDuplo<E> cabeca;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void adicionar(E conteudo) {
        if (cabeca == null) {
            cabeca = new NoDuplo<E>(conteudo, null, null);
        } else {
            NoDuplo<E> ponteiro = cabeca;
            for (; ponteiro.proximo != null; ponteiro = ponteiro.proximo) {
            }
            ponteiro.proximo = new NoDuplo<E>(conteudo, null, ponteiro);
        }
        tamanho++;
    }

    public NoDuplo remover(int i) {
        NoDuplo<E> ponteiro = cabeca;
        for (int j = 0; j < i; j++) {
            ponteiro = ponteiro.proximo;
        }
        ponteiro.anterior.proximo = ponteiro.proximo;

        return ponteiro;
    }

    public void imprimir() {
        NoDuplo<E> ponteiro = cabeca;
        System.out.println("Lista Dupla");
        for (; ponteiro != null; ponteiro = ponteiro.proximo) {
            System.out.println(ponteiro);
        }
    }
}
