/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.lista_encadeada.listaCircular;

import aeds_atividadeavaliada.lista_encadeada.listaDupla.*;

/**
 *
 * @author rodol
 */
public class NoDuplo<T> {

    T conteudo;
    NoDuplo<T> proximo;
    NoDuplo<T> anterior;

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
        this.proximo = null;
        this.anterior = null;
    }

    public NoDuplo(T item, NoDuplo<T> prox, NoDuplo<T> ant) {
        this.conteudo = item;
        this.proximo = prox;
        this.anterior = ant;
    }

    @Override
    public String toString() {
        return "No{" + "conteudo=" + conteudo + '}';
    }
}
