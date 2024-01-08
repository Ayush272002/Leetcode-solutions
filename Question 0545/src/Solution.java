import java.util.ArrayList;

class Solution
{
    ArrayList<Integer> traverseLeft(TreeNode root, ArrayList<Integer> ans)
    {
        //base case
        if(root == null) return ans;
        if(root.left == null && root.right == null) return ans;

        ans.add(root.val);
        if(root.left != null) ans = traverseLeft(root.left , ans);
        else ans= traverseLeft(root.right, ans);

        return ans;
    }

    ArrayList<Integer> traverseLeaf(TreeNode root, ArrayList<Integer> ans)
    {
        //base case
        if(root==null) return ans;

        //leaf node
        if(root.left == null && root.right == null) ans.add(root.val);

        ans = traverseLeaf(root.left, ans);
        ans = traverseLeaf(root.right , ans);

        return ans;
    }

    ArrayList<Integer> traverseRight(TreeNode root, ArrayList<Integer> ans)
    {
        //base case
        if(root == null) return ans;
        if(root.left == null && root.right == null) return ans;

        if(root.right != null) ans = traverseRight(root.right, ans);
        else ans = traverseRight(root.left , ans);

        //adding ans
        ans.add(root.val);

        return ans;
    }
    ArrayList<Integer> boundaryOfBinaryTree(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        ans.add(root.val);

        //left part
        ans = traverseLeft(root.left,ans);

        //traverse leaf node

        //left subtree
        ans = traverseLeaf(root.left , ans);

        //right subtree
        ans= traverseLeaf(root.right , ans);

        //traverse right
        ans = traverseRight(root.right, ans);

        return ans;
    }
}