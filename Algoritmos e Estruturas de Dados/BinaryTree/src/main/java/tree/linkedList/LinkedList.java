package tree.linkedList;

public class LinkedList <T>{

    private LinkedListNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        int sizeList = 0;
        LinkedListNode<T> auxNode = head;

        for(; auxNode != null ; auxNode = auxNode.getNextNode())
            sizeList++;

        return  sizeList;

        /*while (true){
            if(auxNode != null){
                sizeList++;
                if(auxNode.getNextNode() != null){
                    auxNode = auxNode.getNextNode();
                }else{
                    break;
                }
            }else{
                break;
            }
        }*/
    }

    public void add(T data){
        if(this.isEmpty()){
            head = new LinkedListNode<>(data);
        }else{
            LinkedListNode<T> auxNode = head;

            for (; auxNode.getNextNode() != null; auxNode = auxNode.getNextNode());

            auxNode.setNextNode(new LinkedListNode<>(data));
        }
    }

    public void addHead(T data){
        if(isEmpty()){
            head = new LinkedListNode<>(data);
        }else{
            head = new LinkedListNode<>(data, head);
        }
    }

    public T get(int index){
        return getNode(index).getData();
    }

    private LinkedListNode<T> getNode(int index){

        validateIndex(index);
        LinkedListNode<T> auxNode = head;
        LinkedListNode<T> returnNode = null;

        for (; index > 0; index--)
            auxNode = auxNode.getNextNode();
        returnNode = auxNode;


        return returnNode;
    }

    public LinkedListNode<T> getNodeData(T data){
        LinkedListNode<T> pointer = head;

        for (; pointer.getData() != data; pointer = pointer.getNextNode());

        return pointer;
    }

    public T remove(int index){
        LinkedListNode<T> pivotNode = this.getNode(index);
        if(index == 0){
            head = pivotNode.getNextNode();
            return pivotNode.getData();
        }
        LinkedListNode<T> previousNode = getNode(index-1);
        previousNode.setNextNode(pivotNode.getNextNode());
        return pivotNode.getData();
    }

    public LinkedListNode<T> removeHead(){
        if(this.head == null) return null;

        LinkedListNode<T> aux = this.head;
        this.head = head.getNextNode();
        return aux;
    }

    public String toString(){
        String str = "Lista Encadeada\n";

        LinkedListNode<T> auxNode = head;
        for (; auxNode != null; auxNode = auxNode.getNextNode())
            str += auxNode.toString() + "--->";

        return str += "null";
    }

    private void validateIndex(int index){
        if(index >= size()){
            throw new IndexOutOfBoundsException("Não existe contúdo no índice " + index + " desta lista."
                    + "\nEsta lista só vai até o índice: " + (size()-1));
        }
    }
}
