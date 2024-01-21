import java.util.ArrayList;
import java.util.List;

//Using Morris Traversal
class Solution
{
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current, pre;
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        current = root;
        while (current != null)
        {
            if(current.left == null)
            {
                ans.add(current.val);
                current = current.right;
            }

            else
            {
                pre = current.left;
                while(pre.right != null && pre.right != current)
                    pre = pre.right;

                if(pre.right == null)
                {
                    pre.right = current;
                    current = current.left;
                }
                else
                {
                    pre.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }
        return ans;
    }
}