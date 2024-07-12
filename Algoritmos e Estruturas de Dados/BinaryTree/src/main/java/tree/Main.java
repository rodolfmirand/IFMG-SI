package tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(20);
        tree.insert(15);
        tree.insert(2);
        tree.insert(16);
        tree.insert(80);
        tree.insert(51);
        tree.insert(101);
        tree.insert(99);
        tree.insert(213);

        System.out.println(tree.searchSuccessor(20));
        System.out.println(tree.searchSuccessor(80));
        System.out.println(tree.searchSuccessor(15));
        System.out.println(tree.searchSuccessor(2));
        System.out.println(tree.searchSuccessor(99));
        System.out.println(tree.searchSuccessor(213));


    }
}
