import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) //LRN
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeNode current, pre;
        current= root;

        while(current != null)
        {
            if(current.right == null)
            {
                ans.add(current.val);
                current = current.left;
            }
            else
            {
                pre = current.right;
                while (pre.left != null && pre.left != current)
                    pre = pre.left;

                if(pre.left == null)
                {
                    ans.add(current.val);
                    pre.left = current;
                    current = current.right;
                }
                else
                {
                    pre.left = null;
                    current = current.left;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
