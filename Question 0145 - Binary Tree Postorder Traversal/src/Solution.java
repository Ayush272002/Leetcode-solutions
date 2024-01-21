import java.util.ArrayList;
import java.util.List;

class Solution {
    static void postorderTraversalBuilder(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;

        postorderTraversalBuilder(root.left, ans);
        postorderTraversalBuilder(root.right, ans);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) //LRN
    {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalBuilder(root, ans);
        return ans;
    }
}