import java.util.LinkedList;
import java.util.Queue;

class OptimisedSolution {
    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int prev; // Variable to keep track of previous value

        while (!q.isEmpty()) {
            int sz = q.size();
            prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE; // Initialize prev based on level parity
            for (int i = 0; i < sz; i++)
            {
                TreeNode temp = q.poll();
                if(temp != null)
                {
                    int val = temp.val;

                    // Checking parity of level and comparing with previous value
                    if ((level % 2 == 0 && (val % 2 != 0 && val > prev)) || (level % 2 != 0 && (val % 2 == 0 && val < prev)))
                    {
                        prev = val; // Update prev
                        if (temp.left != null) q.add(temp.left);
                        if (temp.right != null) q.add(temp.right);
                    }
                    else return false;
                }
            }
            level++;
        }
        return true;
    }
}