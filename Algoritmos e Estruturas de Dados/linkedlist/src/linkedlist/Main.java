/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author rodol
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList();
        LinkedList<Integer> lista2 = new LinkedList();

        lista.addInOrder(3);
        lista.addInOrder(1);
        
        lista.addInOrder(2);
        lista.addInOrder(5);
        lista.addInOrder(4);

        lista.printLinkedList();

    }
}
