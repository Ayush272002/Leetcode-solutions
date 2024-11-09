import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private void solve(TreeNode root, List<List<Integer>> ans) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int sz = q.size();

            List<Integer> sub = new LinkedList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode tmp = q.poll();
                sub.add(tmp.val);

                if (tmp.left != null)
                    q.add(tmp.left);

                if (tmp.right != null)
                    q.add(tmp.right);
            }

            ans.add(sub);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        solve(root, ans);
        return ans;
    }
}