package tree;

public class BinaryTree<T extends Comparable<T>> {

    private BinNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinNode<T> getRoot() {
        return this.root;
    }

    public void insert(T data) {
        BinNode<T> newNode = new BinNode<>(data);
        root = insert(root, newNode, null); // Passa null como pai inicial
    }

    private BinNode<T> insert(BinNode<T> current, BinNode<T> newNode, BinNode<T> parent) {
        if (current == null) {
            newNode.setParent(parent); // Define o pai do novo nó
            return newNode;
        } else if (newNode.getData().compareTo(current.getData()) < 0) {
            current.setLeftNode(insert(current.getLeftNode(), newNode, current));
        } else {
            current.setRightNode(insert(current.getRightNode(), newNode, current));
        }
        return current;
    }

    public void showInOrder() {
        System.out.println("\n Exibindo InOrder:");
        showInOrder(this.root);
    }

    private void showInOrder(BinNode<T> current) {
        if (current != null) {
            showInOrder(current.getLeftNode());
            System.out.print(current.getData() + ", ");
            showInOrder(current.getRightNode());
        }
    }

    public void showPostOrder() {
        System.out.println("\n Exibindo PostOrder:");
        showPostOrder(this.root);
    }

    private void showPostOrder(BinNode<T> current) {
        if (current != null) {
            showPostOrder(current.getLeftNode());
            showPostOrder(current.getRightNode());
            System.out.print(current.getData() + ", ");
        }
    }

    public void showPreOrder() {
        System.out.println("\n Exibindo PreOrder:");
        showPreOrder(this.root);
    }

    private void showPreOrder(BinNode<T> current) {
        if (current != null) {
            System.out.print(current.getData() + ", ");
            showPreOrder(current.getLeftNode());
            showPreOrder(current.getRightNode());
        }
    }

    public BinNode<T> getBigger() {
        return getBigger(this.root);
    }

    private BinNode<T> getBigger(BinNode<T> current) {
        if (current.getRightNode() == null) return current;
        return getBigger(current.getRightNode());
    }

    private BinNode<T> getSmaller(BinNode<T> current) {
        if (current.getLeftNode() == null) return current;
        return getSmaller(current.getLeftNode());
    }

    public boolean compareTrees(BinaryTree<T> treeToCompare){
        return compareTrees(this.root, treeToCompare.getRoot());
    }

    private boolean compareTrees(BinNode<T> current, BinNode<T> otherCurrent){
        if (current == null && otherCurrent == null) {
            return true;
        }
        if (current == null || otherCurrent == null) {
            return false;
        }
        return (current.getData().compareTo(otherCurrent.getData()) == 0 &&
                compareTrees(current.getLeftNode(), otherCurrent.getLeftNode()) &&
                compareTrees(current.getRightNode(), otherCurrent.getRightNode()));
    }

//    public boolean compareTree(BinaryTree<T> treeToCompare){
//        return compareTree(treeToCompare, this.root, treeToCompare.getRoot());
//    }
//
//    private boolean compareTree(BinaryTree<T> treeToCompare, BinNode<T> current, BinNode<T> currentOtherTree){
//        if(current.getData().compareTo(currentOtherTree.getData()) != 0) return false;
//
//        if(current.getLeftNode() == null && currentOtherTree.getLeftNode() != null
//            || current.getLeftNode() != null && currentOtherTree.getLeftNode() == null) return false;
//
//        if(current.getLeftNode() == null && currentOtherTree.getLeftNode() == null)
//            if(current.getParent().getRightNode() == null && currentOtherTree.getParent().getRightNode() == null) return true;
//            return compareTree(treeToCompare, current.getParent().getRightNode(), currentOtherTree.getParent().getRightNode());
//
//        if(current.getLeftNode() != null && currentOtherTree.getLeftNode() != null)
//            return compareTree(treeToCompare, current.getLeftNode(), currentOtherTree.getLeftNode());
//
//
//        return true;
//    }

    public BinNode<T> searchSuccessor(T data) {
        BinNode<T> newNode = searchNode(data, this.root);
        if (newNode.getRightNode() != null)
            return getSmaller(newNode.getRightNode());
        return searchSuccessor(data, newNode);
    }

    private BinNode<T> searchSuccessor(T data, BinNode<T> current) {
        if (current.getParent() == null) return null;

        if (data.compareTo(current.getParent().getData()) > 0)
            return searchSuccessor(data, current.getParent());

        return current.getParent();
    }

    private BinNode<T> searchNode(T data, BinNode<T> current) {
        if (current.getData().compareTo(data) == 0) return current;
        if (current.getData().compareTo(data) < 0) return searchNode(data, current.getRightNode());
        return searchNode(data, current.getLeftNode());
    }
}