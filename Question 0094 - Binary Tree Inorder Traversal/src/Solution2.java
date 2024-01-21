import java.util.ArrayList;
import java.util.List;

class Solution2 //LNR
{
    static void inorderTraversalHelper(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;

        inorderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(root, ans);
        return ans;
    }
}