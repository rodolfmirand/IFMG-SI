/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.lista_encadeada.listaSimples;

/**
 *
 * @author rodol
 */
public class No<T> {

    T conteudo;
    No<T> proximo;

    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proximo = null;
    }

    public No(T item, No<T> prox) {
        this.conteudo = item;
        this.proximo = prox;
    }

    @Override
    public String toString() {
        return "No{" + "conteudo=" + conteudo + '}';
    }
}
