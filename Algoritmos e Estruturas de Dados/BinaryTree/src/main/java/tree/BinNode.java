package tree;

public class BinNode<T> implements Comparable<BinNode<T>> {

    private T binNodeData;
    private BinNode<T> leftNode;
    private BinNode<T> rightNode;
    private BinNode<T> parent;

    public BinNode(T data) {
        this.binNodeData = data;
        this.leftNode = this.rightNode = this.parent = null;
    }


    public T getBinNodeData() {
        return binNodeData;
    }

    public BinNode<T> getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(BinNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinNode<T> getRightNode() {
        return this.rightNode;
    }

    public BinNode<T> getParent() {
        return this.parent;
    }

    public void setParent(BinNode<T> parent) {
        this.parent = parent;
    }

    public void setRightNode(BinNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public void setBinNodeData(T binNodeData) {
        this.binNodeData = binNodeData;
    }

    @Override
    public String toString() {
        return "BinNode{" +
                "data=" + binNodeData +
                '}';
    }

    @Override
    public int compareTo(BinNode<T> o) {
        return 0;
    }
}
