import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode leftmost = null;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            leftmost = queue.peek();
            for (int i = 0; i < size; i++)
            {
                TreeNode temp = queue.poll();
                if (temp != null && temp.left != null) queue.add(temp.left);
                if (temp != null && temp.right != null) queue.add(temp.right);
            }
        }
        return leftmost.val;
    }
}
