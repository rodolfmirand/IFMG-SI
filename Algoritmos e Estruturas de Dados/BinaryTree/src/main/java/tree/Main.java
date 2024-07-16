package tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int[] values = {18, 8, 2, 12, 10, 9, 16, 11, 20, 19, 21};
        for(int value : values){
            tree.insert(value);
        }

        tree.remove(20);
        tree.remove(19);
        tree.remove(12);

        System.out.println(tree.getRoot());

        tree.showPreOrder();
    }
}
