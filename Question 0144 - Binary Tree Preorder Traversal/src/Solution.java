import java.util.ArrayList;
import java.util.List;

class Solution {
    static void preorderTraversalBuilder(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;

        ans.add(root.val);
        preorderTraversalBuilder(root.left, ans);
        preorderTraversalBuilder(root.right, ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) //NLR
    {
        List<Integer> ans = new ArrayList<>();
        preorderTraversalBuilder(root, ans);
        return ans;
    }
}