import java.util.ArrayList;
import java.util.List;

class Solution {
    private void solve(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans, int curSum)
    {
        if(root == null) return;
        path.add(root.val);
        curSum += root.val;
        if(root.left == null && root.right == null && targetSum == curSum) ans.add(new ArrayList<>(path));


        if(root.left != null)solve(root.left, targetSum, path, ans, curSum);
        if(root.right != null) solve(root.right, targetSum, path, ans, curSum);

        path.remove(path.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        solve(root, targetSum, path, ans, 0);
        return ans;
    }
}