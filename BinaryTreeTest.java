import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree<String> b;

    @Test
    public void buildTree(){
        List<String> list = buildList("ab@@c@@");
        b = new BinaryTree<>(list);
        list = buildList("ab@c@@@");
        b = new BinaryTree<>(list);

        list = buildList("CEF@H@@B@@GA@@NJ@@K@@");
        b = new BinaryTree<>(list);

        list = buildList("@@");
        b = new BinaryTree<>(list);


    }

    public List<String> buildList(String tree){
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < tree.length(); i++) {
            if(tree.substring(i,i+1).equals("@"))
                list.add(null);
            else
                list.add(tree.substring(i,i+1));
        }
        return list;
    }

    @Test
    void inOrder() {
        List<String> list = buildList("ab@@c@@");
        b = new BinaryTree<>(list);
        List<String> order = b.inOrder();
        assertEquals("b",order.get(0));
        assertEquals("a",order.get(1));
        assertEquals("c",order.get(2));

        list = buildList("ab@c@@@");
        b = new BinaryTree<>(list);
        order = b.inOrder();
        assertEquals("b",order.get(0));
        assertEquals("c",order.get(1));
        assertEquals("a",order.get(2));

        list = buildList("CEF@H@@B@@GA@@NJ@@K@@");
        b = new BinaryTree<>(list);
        order = b.inOrder();
        assertEquals("F",order.get(0));
        assertEquals("H",order.get(1));
        assertEquals("E",order.get(2));
        assertEquals("B",order.get(3));
        assertEquals("C",order.get(4));
    }

    @Test
    void preOrder() {
        List<String> list = buildList("ab@@c@@");
        b = new BinaryTree<>(list);
        List<String> order = b.preOrder();
        assertEquals("a",order.get(0));
        assertEquals("b",order.get(1));
        assertEquals("c",order.get(2));

        list = buildList("ab@c@@@");
        b = new BinaryTree<>(list);
        order = b.preOrder();
        assertEquals("a",order.get(0));
        assertEquals("b",order.get(1));
        assertEquals("c",order.get(2));

        list = buildList("CEF@H@@B@@GA@@NJ@@K@@");
        b = new BinaryTree<>(list);
        order = b.preOrder();
        assertEquals("C",order.get(0));
        assertEquals("E",order.get(1));
        assertEquals("F",order.get(2));
        assertEquals("H",order.get(3));
        assertEquals("B",order.get(4));

    }

    @Test
    void postOrder() {
        List<String> list = buildList("ab@@c@@");
        b = new BinaryTree<>(list);
        List<String> order = b.postOrder();
        assertEquals("b",order.get(0));
        assertEquals("c",order.get(1));
        assertEquals("a",order.get(2));

        list = buildList("ab@c@@@");
        b = new BinaryTree<>(list);
        order = b.postOrder();
        assertEquals("c",order.get(0));
        assertEquals("b",order.get(1));
        assertEquals("a",order.get(2));

        list = buildList("CEF@H@@B@@GA@@NJ@@K@@");
        b = new BinaryTree<>(list);
        order = b.postOrder();
        assertEquals("H",order.get(0));
        assertEquals("F",order.get(1));
        assertEquals("B",order.get(2));
        assertEquals("E",order.get(3));
        assertEquals("A",order.get(4));
    }

    @Test
    void size() {
        List<String> list = buildList("ab@@c@@");
        b = new BinaryTree<>(list);
        assertEquals(3,b.size());

        list = buildList("ab@c@@@");
        b = new BinaryTree<>(list);
        assertEquals(3,b.size());

        list = buildList("CEF@H@@B@@GA@@NJ@@K@@");
        b = new BinaryTree<>(list);
        assertEquals(10,b.size());

    }
}