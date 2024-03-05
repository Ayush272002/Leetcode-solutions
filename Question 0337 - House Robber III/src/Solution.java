import java.util.HashMap;
import java.util.Map;

public class Solution
{
    private int solve(TreeNode root, Map<TreeNode, Integer> map)
    {
        //base case
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int include = root.val;
        if(root.left != null)
        {
            include += solve(root.left.left, map) + solve(root.left.right, map);
        }
        if(root.right != null)
        {
            include += solve(root.right.left, map) + solve(root.right.right, map);
        }
        int exclude = solve(root.left, map) + solve(root.right, map);
        int max = Math.max(include, exclude);
        map.put(root, max);
        return max;
    }
    public int rob(TreeNode root)
    {
        Map<TreeNode, Integer> map = new HashMap<>();
        return solve(root, map);
    }
}
