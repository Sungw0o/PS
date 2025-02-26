import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            tree.createNode(input[0].charAt(0), input[1].charAt(0), input[2].charAt(0));
        }
        tree.traverse();
    }
}

class Node {
    char data;
    Node left, right;
    Node(char data) {
        this.data = data;
    }
}

class Tree {
    private Node root;
    private final StringBuilder preOrderSB = new StringBuilder();
    private final StringBuilder inOrderSB = new StringBuilder();
    private final StringBuilder postOrderSB = new StringBuilder();

    public void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
        }
        insertNode(root, data, leftData, rightData);
    }

    private void insertNode(Node node, char data, char leftData, char rightData) {
        if (node == null) return;
        if (node.data == data) {
            if (leftData != '.') node.left = new Node(leftData);
            if (rightData != '.') node.right = new Node(rightData);
        } else {
            insertNode(node.left, data, leftData, rightData);
            insertNode(node.right, data, leftData, rightData);
        }
    }

    public void traverse() {
        preOrder(root);
        inOrder(root);
        postOrder(root);
        System.out.println(preOrderSB);
        System.out.println(inOrderSB);
        System.out.println(postOrderSB);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        preOrderSB.append(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        inOrderSB.append(node.data);
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postOrderSB.append(node.data);
    }
}
