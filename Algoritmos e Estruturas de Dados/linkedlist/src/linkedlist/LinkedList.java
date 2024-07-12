/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

/**
 *
 * @author rodol
 */
public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
    }

    public Node<E> getLista() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void addHead(E object) {
        if (head == null) {
            head = new Node<E>(object, null);
        } else {
            Node<E> novoItem = new Node<E>(object, head);
            head = novoItem;
        }
        size++;
    }

    public void addTail(E object) {
        if (head == null) {
            head = new Node<E>(object, null);
        } else {
            Node<E> pointer = head;
            for (; pointer.proximo != null; pointer = pointer.proximo) {
            }
            pointer.proximo = new Node<E>(object, null);
        }
        size++;
    }

    public void addInOrder(E object) {
        if (head == null) {
            head = new Node<E>(object, null);
        } else {
            Node<E> newNode = new Node(object);
            Node<E> pointer = head;

            if ((int) newNode.conteudo > (int) pointer.conteudo) {
                newNode.proximo = this.head;
                this.head = newNode;
            } else {
                for (; pointer.proximo != null && (int) newNode.conteudo < (int) pointer.proximo.conteudo; pointer = pointer.proximo) {
                }
                newNode.proximo = pointer.proximo;
                pointer.proximo = newNode;
            }

        }
    }

    public E remove(E noParaRemover) {
        if (elementExist(noParaRemover)) {
            Node pointer = head;
            Node poninter2 = head;
            for (; pointer.conteudo != noParaRemover; pointer = pointer.proximo) {
                poninter2 = pointer;
            }
            poninter2.proximo = pointer.proximo;
            pointer.proximo = null;
            return (E) pointer;
        } else {
            return null;
        }
    }

    public boolean elementExist(E object) {
        if (head == null) {
            return false;
        }
        Node<E> pointer = head;
        do {
            if (pointer.conteudo == object) {
                return true;
            }
            pointer = pointer.proximo;
        } while (pointer != null);
        return false;
    }

    public void printLinkedList() {
        Node<E> pointer = head;
        System.out.println("Imprimindo a Lista encadeada");
        for (; pointer != null; pointer = pointer.proximo) {
            System.out.println(pointer.conteudo);
        }
    }

    public String toString() {
        Node<E> pointer = head;
        String retorno = "Imprimindo a Lista encadeada";

        for (; pointer != null; pointer = pointer.proximo) {
            retorno += "\n" + pointer.conteudo;
        }

        return retorno;
    }

    public boolean compareLinkedList(LinkedList newList) {
        if (head == null || newList.head == null || this.size != newList.size) {
            return false;
        }
        Node<E> pointer = this.head;
        Node<E> pointerNewList = newList.head;
        do {
            if (pointer.conteudo != pointerNewList.conteudo) {
                return false;
            } else {
                pointer = pointer.proximo;
                if (pointer.proximo == null) {
                    return true;
                }
                pointerNewList = pointerNewList.proximo;
            }
        } while (true);
    }

    public LinkedList merge(LinkedList listB) {
        LinkedList mergedList = new LinkedList();
        Node currentA = this.head;
        Node currentB = listB.head;

        while (currentA != null && currentB != null) {
            if ((int) currentA.conteudo < (int) currentB.conteudo) {
                mergedList.append((int) currentA.conteudo);
                currentA = currentA.proximo;
            } else {
                mergedList.append((int) currentB.conteudo);
                currentB = currentB.proximo;
            }
        }

        while (currentA != null) {
            mergedList.append((int) currentA.conteudo);
            currentA = currentA.proximo;
        }

        while (currentB != null) {
            mergedList.append((int) currentB.conteudo);
            currentB = currentB.proximo;
        }

        return mergedList;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.proximo != null) {
            current = current.proximo;
        }
        current.proximo = newNode;
    }

}
