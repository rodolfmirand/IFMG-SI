package tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        BinaryTree<Integer> tree2 = new BinaryTree<>();

        tree.insert(26);
        tree.insert(10);
        tree.insert(4);
        tree.insert(5);
        tree.insert(1);
        tree.insert(2);

        tree2.insert(4);
        tree2.insert(5);
        tree2.insert(1);
        tree2.insert(2);

        if (tree.verifyIfSubtree(tree2)) System.out.println("true");
        else System.out.println("false");

    }
}
