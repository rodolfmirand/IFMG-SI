package avl.tree;

public class AVLTree {

    private Node root;

    int height(Node node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    Node insert(Node node, int data) {


        if (node == null)
            return (new Node(data));

        if (data < node.getData())
            node.setLeft(insert(node.getLeft(), data));
        else if (data > node.getData())
            node.setRight(insert(node.getRight(), data));
        else
            return node;

        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        if (balance > 1 && data < node.getLeft().getData())
            return rightRotate(node);

        if (balance < -1 && data > node.getRight().getData())
            return leftRotate(node);

        if (balance > 1 && data > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && data < node.getRight().getData()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

