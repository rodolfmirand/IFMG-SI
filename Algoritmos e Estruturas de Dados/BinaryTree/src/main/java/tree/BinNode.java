package tree;

public class BinNode<T extends Comparable<T>> {

    private T data;
    private BinNode<T> leftNode;
    private BinNode<T> rightNode;
    private BinNode<T> parent;

    public BinNode(T data) {
        this.data = data;
        this.leftNode = this.rightNode = this.parent = null;
    }


    public T getData() {
        return data;
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

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinNode{" +
                "data=" + data +
                '}';
    }
}
