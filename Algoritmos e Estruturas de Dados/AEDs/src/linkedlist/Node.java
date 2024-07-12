/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author rodol
 */
public class Node<T> {

    T conteudo;
    Node<T> proximo;

    public Node() {
        
    }
    
    public Node(T conteudo) {
        this.conteudo = conteudo;
        this.proximo = null;
    }
    
    public Node(T item, Node<T> prox) {
        this.conteudo = item;
        this.proximo = prox;
    }

    @Override
    public String toString() {
        return "No{" + "conteudo=" + conteudo + '}';
    }
    
}
