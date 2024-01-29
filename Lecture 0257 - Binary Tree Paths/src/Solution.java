import java.util.ArrayList;
import java.util.List;

class Solution {

    private void solve(TreeNode root, List<String> ans, StringBuilder path)
    {
        if(root ==null) return;

        int original = path.length();
        path.append(root.val);


        if(root.left == null && root.right == null)
            ans.add(path.toString());


        else
        {
            path.append("->");
            solve(root.left, ans, path);
            solve(root.right, ans, path);
            path.delete(path.lastIndexOf("->"),path.length());
        }

        path.setLength(original);
    }
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        solve(root, ans, path);
        return ans;
    }
}