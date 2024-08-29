package org.example.ex10;

public class BinNode<T extends Comparable<T>> {

    private T key;

    private T frequency;
    private BinNode<T> leftNode;
    private BinNode<T> rightNode;

    public BinNode() {

    }

    public BinNode(T key, T frequency) {
        this.key = key;
        this.frequency = frequency;
        this.leftNode = this.rightNode = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public BinNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public T getFrequency() {
        return frequency;
    }

    public void setFrequency(T frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "BinNode{" +
                "key=" + key + ", frequency=" + frequency +
                '}';
    }
}
