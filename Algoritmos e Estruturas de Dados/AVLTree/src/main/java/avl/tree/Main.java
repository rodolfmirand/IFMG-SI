package avl.tree;

public class Main {
    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        tree.setRoot(tree.insert(tree.getRoot(), 10));
        tree.setRoot(tree.insert(tree.getRoot(), 20));
        tree.setRoot(tree.insert(tree.getRoot(), 30));
        tree.setRoot(tree.insert(tree.getRoot(), 40));
        tree.setRoot(tree.insert(tree.getRoot(), 50));
        tree.setRoot(tree.insert(tree.getRoot(), 25));

        tree.preOrder(tree.getRoot());
    }
}
