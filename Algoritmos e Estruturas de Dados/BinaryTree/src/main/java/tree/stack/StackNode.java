package tree.stack;

import tree.BinNode;

public class StackNode<T extends Comparable<T>> {

    private T nodeData;
    private StackNode<T> nextNode = null;

    public StackNode(BinNode<T> binNode) {
        this.nodeData = binNode.getBinNodeData();
    }

    public StackNode(T data) {
        this.nodeData = data;
    }

    public T getNodeData() {
        return nodeData;
    }

    public void setNodeData(T nodeData) {
        this.nodeData = nodeData;
    }

    public StackNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "No{" +
                "dado=" + nodeData +
                '}';
    }
}
