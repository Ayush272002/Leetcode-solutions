import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> ans = new ArrayList<>(size);

            //level process
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();

                if(front != null)
                {
                    //normal insert or reverse insert
                    if(leftToRight) ans.add(front.val);
                    else ans.add(0,front.val);

                    if(front.left != null) q.add(front.left);
                    if(front.right != null) q.add(front.right);
                }
            }

            //direction change
            result.add(ans);
            leftToRight = !leftToRight;
        }
        return result;
    }
}