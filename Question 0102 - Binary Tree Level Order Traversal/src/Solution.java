import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private void solve(TreeNode root, List<List<Integer>> ans)
    {
        if(root == null) return;


        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode temp = q.poll();
                if(temp != null)
                {
                    level.add(temp.val);
                    if(temp.left != null) q.add(temp.left);
                    if(temp.right != null) q.add(temp.right);
                }
            }

            ans.add(level);
        }

    }
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }
}