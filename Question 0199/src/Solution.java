import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans = solveRight(root, ans, 0);
        return ans;
    }
    ArrayList<Integer> solveRight(TreeNode root, ArrayList<Integer> ans, int level)
    {
        //base case
        if(root==null) return ans;

        //we entered into a new level
        if(level == ans.size()) ans.add(root.val);

        //recursive call
        ans= solveRight(root.right, ans, level+1);
        ans = solveRight(root.left, ans, level+1);

        return ans;
    }
}