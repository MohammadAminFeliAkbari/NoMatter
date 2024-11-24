import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] listStr = scanner.nextLine().split(",");

        Tree tree = new Tree(listStr);

    }

    static class Tree {
        private Node root;

        public Tree(int data) {
            root = new Node(data);
        }

        public Tree(String[] str) {
            root = inOrder_tree(str, 0);
        }

        public Node inOrder_tree(String[] str, int root) {
            if (str[root] == null || str[root].equals("null"))
                return null;

            Node newNode = new Node(Integer.parseInt(str[root]));

            newNode.setRightNode(inOrder_tree(str, root * 2 + 1));
            newNode.setLeftNode(inOrder_tree(str, root * 2 + 2));

            return newNode;
        }

        public void log(){
            
        }

        private class Node {

            private Node rightNode;
            private Node leftNode;
            private int data;

            public Node(int data) {
                this.data = data;
            }

            public Node getRightNode() {
                return rightNode;
            }

            public void setRightNode(Node rightNode) {
                this.rightNode = rightNode;
            }

            public Node getLeftNode() {
                return leftNode;
            }

            public void setLeftNode(Node leftNode) {
                this.leftNode = leftNode;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

        }
    }
}
