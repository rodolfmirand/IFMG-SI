package tree;

import jdk.dynalink.beans.StaticClass;
import tree.linkedList.LinkedList;
import tree.linkedList.LinkedListNode;
import tree.stack.Stack;
import tree.stack.StackNode;

public class IterativeBinaryTree<T extends Comparable<T>> {

    private BinNode<T> root;

    public IterativeBinaryTree() {
        this.root = null;
    }

    public BinNode<T> getRoot() {
        return this.root;
    }

    public void showPreOrderWithStack() {
        this.showPreOrderWithStack(this.root);
    }

    public void showPreOrderWithLinkedList() {
        this.showPreOrderWithLinkedList(this.root);
    }

    private void showPreOrderWithStack(BinNode<T> root) {
        Stack<BinNode<T>> stack = new Stack<>();
        stack.push(new StackNode<BinNode<T>>(root));
        StackNode<BinNode<T>> current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.getNodeData().getBinNodeData() + ", ");
            if (current.getNodeData().getRightNode() != null)
                stack.push(new StackNode<BinNode<T>>(current.getNodeData().getRightNode()));
            if (current.getNodeData().getLeftNode() != null)
                stack.push(new StackNode<BinNode<T>>(current.getNodeData().getLeftNode()));
        }
        System.out.println("\n");
    }

    private void showPreOrderWithLinkedList(BinNode<T> root) {
        LinkedList<BinNode<T>> linkedList = new LinkedList<>();
        linkedList.add(root);

        LinkedListNode<BinNode<T>> current;

        while (!linkedList.isEmpty()) {
            current = linkedList.removeHead();
            System.out.print(current.getData().getBinNodeData() + ", ");
            if (current.getData().getLeftNode() != null)
                linkedList.add(current.getData().getLeftNode());
            if (current.getData().getRightNode() != null)
                linkedList.add(current.getData().getRightNode());

        }
        System.out.println("\n");
    }

    public void insert(T data) {
        BinNode<T> newNode = new BinNode<>(data);
        root = insert(root, newNode, null); // Passa null como pai inicial
    }

    private BinNode<T> insert(BinNode<T> current, BinNode<T> newNode, BinNode<T> parent) {
        if (current == null) {
            newNode.setParent(parent); // Define o pai do novo nó
            return newNode;
        } else if (newNode.getBinNodeData().compareTo(current.getBinNodeData()) < 0) {
            current.setLeftNode(insert(current.getLeftNode(), newNode, current));
        } else {
            current.setRightNode(insert(current.getRightNode(), newNode, current));
        }
        return current;
    }
}
