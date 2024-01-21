import java.util.ArrayList;
import java.util.List;

public class Solution2
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode current, pre;

        current=root;

        while(current != null)
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
                    ans.add(current.val);
                    pre.right = current;
                    current = current.left;
                }
                else
                {
                    pre.right = null;
                    current = current.right;
                }
            }
        }

        return ans;
    }
}
