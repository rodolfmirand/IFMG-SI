/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilhas;

/**
 *
 * @author rodol
 */
public class StackL<Item> {

    private Node first;

    private class Node {

        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    
    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }
}
