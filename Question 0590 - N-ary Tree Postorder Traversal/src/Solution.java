import java.util.ArrayList;
import java.util.List;

class Solution {
    private void postOrderUtil(Node root, List<Integer> ans)
    {
        if(root == null) return;

        for(Node child : root.children)
        {
            postOrderUtil(child,ans);
        }
        ans.add(root.val);
    }
    public List<Integer> postorder(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        postOrderUtil(root,ans);
        return ans;
    }
}