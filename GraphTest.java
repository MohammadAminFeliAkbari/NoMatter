import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    Graph g;

    @BeforeEach
    void setUp(){
        g = new Graph(false);
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addNode("E");
        g.addNode("F");
        g.addNode("G");
        g.addNode("H");
        g.addEdge("A","B");
        g.addEdge("A","C");
        g.addEdge("A","D");
        g.addEdge("B","F");
        g.addEdge("B","E");
        g.addEdge("F","H");
        g.addEdge("D","G");
        g.addEdge("D","B");
    }

    @Test
    void addNode() {
        System.out.println(g);
    }

    @Test
    void addEdge() {
        System.out.print(g);
    }

    @Test
    void removeNode() {
        System.out.println(g);
        g.removeNode("B");
        System.out.println(g);
    }

    @Test
    void removeEdge() {
        System.out.println(g);
        g.removeEdge("A","B");
        System.out.println(g);

    }

    @Test
    void dfsRec() {
        System.out.println(g);
        g.dfsRec("A");
    }
    @Test
    void dfs() {
        System.out.println(g);
        g.dfs("A");
    }

    @Test
    void bfs() {
        System.out.println(g);
        g.bfs("A");
    }

}