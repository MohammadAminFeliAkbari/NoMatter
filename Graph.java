import java.util.*;

public class Graph {
    private boolean directed;

    public Graph(boolean isDirected){
        directed = isDirected;
    }
    
    private Map<String, Node> nodes = new HashMap<>();
    //private Map<Node, List<Node>> adjList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        //node.adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.adjList.add(toNode);
        if(!directed)
            toNode.adjList.add(fromNode);
        //adjList.get(toNode).add(fromNode);
    }

    public String toString() {
        String str = "";
        for (var source : nodes.values()) {
            str += source + ":" + source.adjList +"\n";
        }
        return str;
    }

    public void removeNode(String label){
        var node = nodes.get(label);
        if(node==null)
            return;

        for (var n : nodes.values()) {
            n.adjList.remove(node);
        }

        nodes.remove(label);
    }

    public void removeEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode==null || toNode==null)
            return;
        fromNode.adjList.remove(toNode);
        if(!directed)
            toNode.adjList.remove(fromNode);
    }

    public void dfsRec(String root){
        var node = nodes.get(root);
        if(node==null)
            return;

        dfsRec(node,new HashSet<>());
    }

    private void dfsRec(Node root,Set<Node> visited){
        System.out.print(root);
        visited.add(root);
        for(var node:root.adjList)
            if(!visited.contains(node))
                dfsRec(node,visited);
    }

    public void dfs(String root){
        Node node = nodes.get(root);
        if(node==null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            Node current = stack.pop();
            if(!visited.contains(current)){
                System.out.print(current);
                visited.add(current);
                for(Node n:current.adjList)
                    if(!visited.contains(n))
                        stack.push(n);
            }
        }
    }
    public void bfs(String root){
        Node node = nodes.get(root);
        if(node==null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(!visited.contains(current)){
                System.out.print(current);
                visited.add(current);
                for(Node n:current.adjList)
                    if(!visited.contains(n))
                        queue.add(n);
            }
        }
    }


    private class Node {
        private String label;
        private List<Node> adjList = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public String toString() {
            return label;
        }
    }
}
