import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();

        TreeNode targetNode = createParentMapping(root, start, nodeToParent);
        if(targetNode == null) return 0;

        return burnTree(targetNode, nodeToParent);
    }

    private static TreeNode createParentMapping(TreeNode root, int target, Map<TreeNode, TreeNode> nodeToParent)
    {
        TreeNode res = null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //root doesnt have any parent
        nodeToParent.put(root,null);

        //level order traversal
        while(!q.isEmpty())
        {
            TreeNode front = q.poll();

            if(front.val == target) res = front;

            if(front.left != null)
            {
                nodeToParent.put(front.left, front);
                q.add(front.left);
            }

            if(front.right != null)
            {
                nodeToParent.put(front.right, front);
                q.add(front.right);
            }
        }
        return res;
    }

    static int burnTree(TreeNode root, Map<TreeNode, TreeNode> nodeToParent)
    {
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        visited.put(root,true);

        int ans = 0;
        while(!q.isEmpty())
        {
            boolean flag = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //process neighbouring node

                TreeNode front = q.poll();

                if(front == null) continue;

                if (front.left != null && visited.get(front.left) == null) {
                    flag = true;
                    q.add(front.left);
                    visited.put(front.left, true);
                }

                if (front.right != null && visited.get(front.right) == null) {
                    flag = true;
                    q.add(front.right);
                    visited.put(front.right, true);
                }

                if (nodeToParent.get(front) != null) {
                    TreeNode parent = nodeToParent.get(front);
                    if (visited.get(parent) == null) {
                        flag = true;
                        q.add(parent);
                        visited.put(parent, true);
                    }
                }

            }
            if(flag) ans++;
        }
        return ans;
    }
}