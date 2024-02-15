import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private void bfs(Node root)
    {
        Queue<Node> q  = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                node.next = prev;
                prev = node;

                if(node.right != null) q.add(node.right);
                if(node.left != null) q.add(node.left);
            }
            prev = null;
        }
    }
    public Node connect(Node root)
    {
        if(root == null) return null;
        bfs(root);
        return root;
    }
}