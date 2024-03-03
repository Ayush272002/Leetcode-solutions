import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int deepestLeavesSum(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;

        while(!q.isEmpty())
        {
            int sz = q.size();
            sum = 0;

            for (int i = 0; i < sz; i++) {
                TreeNode temp = q.poll();
                if(temp != null) sum += temp.val;
                if(temp != null && temp.left != null) q.add(temp.left);
                if(temp != null && temp.right != null) q.add(temp.right);
            }
        }


        return sum;
    }
}