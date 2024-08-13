package org.example.ex9;

public class CatalogTree<T extends Comparable<T>> {

    private FileNode<T> root;

    public CatalogTree() {
        this.root = null;
    }

    public FileNode<T> getRoot() {
        return this.root;
    }

    public void insert(T lastAccessDate, String name) {
        FileNode<T> newNode = new FileNode<>(lastAccessDate, name);
        root = insert(root, newNode, null); // Passa null como pai inicial
    }

    private FileNode<T> insert(FileNode<T> current, FileNode<T> newNode, FileNode<T> parent) {
        if (current == null) {
            newNode.setParent(parent); // Define o pai do novo nó
            return newNode;
        } else if (newNode.getLastAccessDate().compareTo(current.getLastAccessDate()) < 0) {
            current.setLeftNode(insert(current.getLeftNode(), newNode, current));
        } else {
            current.setRightNode(insert(current.getRightNode(), newNode, current));
        }
        return current;
    }

    public void removePreviousFiles(T date) {
        removePreviousFiles(this.root, date);
    }

    private FileNode<T> removePreviousFiles(FileNode<T> current, T date) {
        if (current.getLastAccessDate().compareTo(date) > 0) {
            return removePreviousFiles(current.getLeftNode(), date);
        }
        if (current.getLastAccessDate().compareTo(date) < 0) {
            this.root = current.getRightNode();
            current = this.root;
            return removePreviousFiles(current, date);
        }
        current.setLeftNode(null);
        return current;
    }

    public void showInOrder() {
        System.out.println("\n Exibindo InOrder:");
        showInOrder(this.root);
    }

    private void showInOrder(FileNode<T> current) {
        if (current != null) {
            showInOrder(current.getLeftNode());
            System.out.print(current.getLastAccessDate() + ", ");
            showInOrder(current.getRightNode());
        }
    }
}