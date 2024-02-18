import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    private Node dfs(Node node, HashMap<Node,Node> visited)
    {
        if(visited.containsKey(node)) return visited.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node,clone);
        for(Node temp : node.neighbors)
            clone.neighbors.add(dfs(temp,visited));
        return clone;
    }
    public Node cloneGraph(Node node)
    {
        if(node == null) return null;
        HashMap<Node,Node> visited = new HashMap<>();
        return dfs(node,visited);
    }
}