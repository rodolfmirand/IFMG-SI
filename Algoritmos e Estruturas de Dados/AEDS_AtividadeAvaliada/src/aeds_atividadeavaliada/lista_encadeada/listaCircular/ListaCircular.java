/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.lista_encadeada.listaCircular;

/**
 *
 * @author rodol
 */
public class ListaCircular<E> {

    private NoDuplo<E> cabeca;
    private NoDuplo<E> calda;
    private int tamanho;

    public ListaCircular() {
        this.cabeca = null;
        this.calda = null;
        this.tamanho = 0;
    }

    public void adicionar(E conteudo) {
        NoDuplo<E> novoNo = new NoDuplo<E>(conteudo);
        if(cabeca == null){
            cabeca = novoNo;
            calda = novoNo;
            cabeca.proximo = calda;
        }else{
            novoNo.proximo = cabeca;
            calda.proximo = novoNo;
            novoNo.anterior = calda;
            calda = novoNo;
        }
        tamanho++;
    }

    public void imprimir() {
        NoDuplo<E> ponteiro = cabeca;
        System.out.println("Lista Circular");
        for(int i = 0; i < tamanho; i++){
            System.out.println(ponteiro);
            ponteiro = ponteiro.proximo;
        }
    }
}
