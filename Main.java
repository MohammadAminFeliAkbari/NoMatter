import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] listStr = scanner.nextLine().split(",");
        int base = scanner.nextInt();
        int top = scanner.nextInt();

        Tree tree = new Tree(listStr);

        tree.haras(base, top);

        tree.log();
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
            try {
                if (str[root] == null || str[root].equals("null"))
                    return null;
            } catch (Exception e) {
                return null;
            }

            System.out.println("hello");

            Node newNode = new Node(Integer.parseInt(str[root]));

            newNode.setLeftNode(inOrder_tree(str, root * 2 + 1));
            newNode.setRightNode(inOrder_tree(str, root * 2 + 2));

            return newNode;
        }

        public void haras(int base, int top) {
            haras(root, base, top);
        }

        private void haras(Node root, int base, int top) {
            if (root == null)
                return;

            if (Integer.parseInt((String) root.getData()) < base || Integer.parseInt((String) root.getData()) > top)
                root.setData(null);
                
            haras(root.getLeftNode(), base, top);
            haras(root.getRightNode(), base, top);
        }

        public void log() {
            ArrayQueue<Node> arr = new ArrayQueue<>(10);
            arr.add(root);
            int i = 0; // for don't print , in first line

            while (!arr.isEmpty()) {
                Node newNode = arr.delete();

                try {
                    var nnn = newNode.data;
                    if (i != 0) {
                        System.out.print(",");
                    }
                    i++;
                    System.out.print(newNode.data);
                } catch (Exception E) {
                    System.out.print(",null");
                }

                if (newNode != null) {
                    arr.add(newNode.getLeftNode());
                    arr.add(newNode.getRightNode());
                }
            }
        }

        private class Node<E> {

            private Node rightNode;
            private Node leftNode;
            private E data;

            public Node(E data) {
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

            public E getData() {
                return data;
            }

            public void setData(E data) {
                this.data = data;
            }

        }

        class ArrayQueue<E> {
            private E[] items;
            private int front;
            private int rear;
            private int length;

            public ArrayQueue(int size) {
                items = (E[]) new Object[size];
                front = rear = -1;
            }

            public void add(E item) throws QueueOverflowException {
                if (isFull())
                    throw new QueueOverflowException();
                if (isEmpty())
                    front = rear = 0;
                else if (rear >= items.length - 1)
                    rear = 0;
                else
                    rear++;
                items[rear] = item;
                length++;
            }

            private boolean isFull() {
                // return front == 0 && rear == items.length - 1 || rear + 1 == front;
                return length == items.length;
            }

            public E delete() throws QueueUnderflowException {
                if (isEmpty())
                    throw new QueueUnderflowException();
                var item = items[front];
                if (front == rear)
                    front = rear = -1;
                else if (front == items.length - 1)
                    front = 0;
                else
                    front++;
                length--;
                return item;
            }

            public E front() throws QueueUnderflowException {
                if (isEmpty())
                    throw new QueueUnderflowException();
                return items[front];
            }

            public boolean isEmpty() {
                return front == -1;
            }

            public int length() {
                return length;
            }

            public void clear() {
                front = rear = -1;
                length = 0;
            }
        }

    }
}
