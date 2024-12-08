public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    public void insert(E value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (current.getData().compareTo(value) >= 0) {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    return;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(node);
                    return;
                }
                current = current.getRight();
            }
        }
    }

    public int levelOf(E value) {
        Node current = root;
        int level = 0;
        while (current != null) {
            if (current.getData().compareTo(value) == 0)
                return level;
            else if (current.getData().compareTo(value) < 0) {
                current = current.getRight();
                level++;
            } else {
                current = current.getLeft();
                level++;
            }
        }
        return -1;
    }

    public E max() {
        if (root == null) return null;
        Node current = root;
        while (current.getRight() != null)
            current = current.getRight();
        return current.getData();
    }

    public E min() {
        return min(root);
    }

    private E min(Node root) {
        if (root == null) return null;
        if (root.getLeft() == null)
            return root.getData();
        return min(root.getLeft());
    }

    public void remove(E value) {
        root = remove(value, root);
    }


    private Node remove(E value, Node root) {
        if (root == null) return null;
        int cmp = value.compareTo(root.getData());
        if (cmp < 0) // باید از زیردرخت چپ حذف شود
            root.setLeft(remove(value, root.getLeft()));
        else if (cmp > 0) //باید از زیردرخت راست حذف شود
            root.setRight(remove(value, root.getRight()));
        else // فقط فرزند چپ دارد
            // فرزند چپ ندارد
            if (root.getLeft() != null && root.getRight() != null) { //دو فرزند دارد
                E min = min(root.getRight());// مینیموم زیر درخت راست
                root.setData(min);
                root.setRight(remove(min, root.getRight())); // حذف مینیموم از زیردرخت راست
            } else return root.getLeft() != null ? root.getLeft() : root.getRight();
        return root;
    }

}
