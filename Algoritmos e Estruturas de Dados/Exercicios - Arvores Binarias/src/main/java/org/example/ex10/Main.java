package org.example.ex10;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(10, 5);
        tree.insert(20, 15);
        tree.insert(5, 25);
        tree.insert(30, 10);
        tree.insert(15, 20);

        tree.showInOrder();

        tree.reorganize();

        tree.showInOrder();
    }
}
