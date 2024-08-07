package tree.stack;

public class Stack<T extends Comparable<T>>{

    private StackNode<T> head;

    public Stack() {
        this.head = null;
    }

    public void push(StackNode<T> newNode){
        StackNode<T> aux = head;
        head = newNode;
        head.setNextNode(aux);
    }

    public StackNode<T> pop(){
        if(!isEmpty()){
            StackNode<T> poppedNode = head;
            head = head.getNextNode();
            return poppedNode;
        }
        return null;
    }

    public StackNode<T> top(){
        return head;
    }

    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public String toString() {
        String retorno = "------------------\nPilha:\n";
        StackNode aux = head;

        while(true){
            if(aux != null){
                retorno += "[No{dado=" + aux.getNodeData() +"}]\n";
                aux = aux.getNextNode();
            }else{
                break;
            }
        }
        retorno += "------------------";
        return retorno;
    }
}
