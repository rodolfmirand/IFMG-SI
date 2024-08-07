package tree.linkedList;

public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> nextNode;

    public LinkedListNode() {
        this.nextNode = null;
    }

    public LinkedListNode(T data) {
        this.data = data;
        this.nextNode = null;
    }

    public LinkedListNode(T data, LinkedListNode<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public String toStringMod(){
        String str = "Node{" +
                "conteudo=" + data +
                '}';
        if(nextNode != null)
            str += "->" + nextNode.toString();
        else
            str += "-> null";

        return str;
    }
}
