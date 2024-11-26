import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int sz = q.size();

            double avg = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode tmp = q.poll();

                avg += tmp.val;

                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }

            ans.add(avg / sz);
        }

        return ans;
    }
}