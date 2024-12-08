import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<E> implements IBinaryTree<E> {
    protected Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(List<E> list) {
        root = buildTree(list.listIterator());
    }


    private Node buildTree(Iterator<E> list) {
        E data = list.next();
        if (data == null) return null;
        Node node = new Node(data);
        node.setLeft(buildTree(list));
        node.setRight(buildTree(list));
        return node;
    }

    public List<E> inOrder() {
        List<E> list = new LinkedList<E>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node root, List<E> list) {
        if (root == null) return;
        inOrder(root.getLeft(), list);
        list.add(root.getData());
        inOrder(root.getRight(), list);
    }

    public List<E> preOrder() {
        List<E> list = new LinkedList<E>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node root, List<E> list) {
        if (root == null) return;
        list.add(root.getData());
        preOrder(root.getLeft(), list);
        preOrder(root.getRight(), list);
    }

    public List<E> postOrder() {
        List<E> list = new LinkedList<E>();
        postOrder(root, list);
        return list;
    }

    @Override
    public List<E> levelOrder() {
        List<E> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        //if(root==null) return null;
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node.getData());
            if (node.getLeft() != null)
                queue.add(node.getLeft());
            if (node.getRight() != null)
                queue.add(node.getRight());
        }
        return list;
    }

    private void postOrder(Node root, List<E> list) {
        if (root == null) return;
        postOrder(root.getLeft(), list);
        postOrder(root.getRight(), list);
        list.add(root.getData());
    }

    //اندازه درخت را برمیگرداند
    // تعداد گره‌های درخت
    public int size() {
        return size(root);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    @Override
    public int weight() {
        return weight(root);
    }

    private int weight(Node root) {
        if (root == null) return 0;
        if (root.isLeaf()) return 1;
        return weight(root.getLeft()) + weight(root.getRight());
    }

    /**
     * درخت را آینه می‌کند. منظور از آینه کردن درخت تعویض جای فرزندان چپ و راست هر گره است
     */
    @Override
    public void mirror() {
        mirror(root);
    }

    /**
     * returns true if the tree is perfect, otherwise returns false
     *
     * @return
     */
    @Override
    public boolean isPerfect() {
        return size() == Math.pow(2, height()) - 1;
    }

    /**
     * if the tree contains data returns the level of the node containing data otherwise returns -1
     *
     * @param data
     * @return
     */
    @Override
    public int levelOf(E data) {
        return contains(root, data, 0);
    }

    private int contains(Node root, E data, int level) {
        if (root == null) return -1;
        if (root.getData().equals(data))
            return level;
        return Math.max(contains(root.getLeft(), data, level + 1), contains(root.getRight(), data, level + 1));
    }

    private void mirror(Node root) {
        if (root == null) return;
        root.swapChildren();
        mirror(root.getLeft());
        mirror(root.getRight());
    }

    private int size(Node root) {
        if (root == null) return 0;
        else return 1 + size(root.getLeft()) + size(root.getRight());
    }

    protected class Node {
        private E _data;
        private Node _left;
        private Node _right;

        public Node(E data) {
            _data = data;
        }

        public E getData() {
            return _data;
        }

        public void setData(E data) {
            this._data = data;
        }

        public Node getLeft() {
            return _left;
        }

        public void setLeft(Node left) {
            this._left = left;
        }

        public Node getRight() {
            return _right;
        }

        public void setRight(Node right) {
            this._right = right;
        }

        public String toString() {
            return _data == null ? "" : _data.toString();
        }

        public boolean isLeaf() {
            return _left == null && _right == null;
        }

        public void swapChildren() {
            Node temp = _left;
            _left = _right;
            _right = temp;
        }
    }

}
