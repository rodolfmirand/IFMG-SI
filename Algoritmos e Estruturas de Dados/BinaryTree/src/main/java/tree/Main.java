package tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        BinaryTree<Integer> tree2 = new BinaryTree<>();

        tree.insert(20);
        tree.insert(15);
        tree.insert(2);
        tree.insert(16);
        tree.insert(80);
        tree.insert(51);
        tree.insert(101);
        tree.insert(99);
        tree.insert(213);

        tree2.insert(20);
        tree2.insert(15);
        tree2.insert(2);
        tree2.insert(16);
        tree2.insert(80);
        tree2.insert(51);
        tree2.insert(101);
        tree2.insert(99);
        tree2.insert(213);

        if(tree.compareTrees(tree2)){
            System.out.println("Árvores identicas");
        }else{
            System.out.println("Árvores diferentes");
        }


    }
}
