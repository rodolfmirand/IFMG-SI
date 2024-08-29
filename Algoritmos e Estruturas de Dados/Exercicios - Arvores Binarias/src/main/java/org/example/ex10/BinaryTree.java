package org.example.ex10;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private BinNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data, T frequency) {
        BinNode<T> newNode = new BinNode<>(data, frequency);
        root = insert(root, newNode);
    }

    private BinNode<T> insert(BinNode<T> current, BinNode<T> newNode) {
        if (current == null) {
            return newNode;
        } else if (newNode.getKey().compareTo(current.getKey()) < 0) {
            current.setLeftNode(insert(current.getLeftNode(), newNode));
        } else {
            current.setRightNode(insert(current.getRightNode(), newNode));
        }
        return current;
    }

    private void treeToList(BinNode<T> node, List<BinNode<T>> nodesList) {
        if (node == null) return;
        treeToList(node.getLeftNode(), nodesList);
        nodesList.add(node);
        treeToList(node.getRightNode(), nodesList);
    }

    private BinNode<T> buildTreeFromList(List<BinNode<T>> nodesList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        BinNode<T> node = nodesList.get(mid);

        node.setLeftNode(buildTreeFromList(nodesList, start, mid - 1));
        node.setRightNode(buildTreeFromList(nodesList, mid + 1, end));

        return node;
    }

    public void orderNodesByFrequency(List<BinNode<T>> nodesList) {
        for (int i = 0; i < nodesList.size() - 1; i++) {
            for (int j = i + 1; j < nodesList.size(); j++) {
                if (nodesList.get(i).getFrequency().compareTo(nodesList.get(j).getFrequency()) < 0) {
                    BinNode<T> temp = nodesList.get(i);
                    nodesList.set(i, nodesList.get(j));
                    nodesList.set(j, temp);
                }
            }
        }
    }

    public void reorganize() {
        List<BinNode<T>> nodesList = new ArrayList<>();
        this.treeToList(this.root, nodesList);
        orderNodesByFrequency(nodesList);

        this.root = null;
        for (BinNode<T> node : nodesList) {
            insert(node.getKey(), node.getFrequency());
        }
    }


    public void showInOrder() {
        System.out.println("\n Exibindo InOrder:");
        showInOrder(this.root);
    }

    private void showInOrder(BinNode<T> current) {
        if (current != null) {
            showInOrder(current.getLeftNode());
            System.out.print(current.getKey() + ", ");
            showInOrder(current.getRightNode());
        }
    }
}
