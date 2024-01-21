public class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode temp = root;

        while(temp != null)
        {
            if(temp.val == val) return temp;

            if(val > temp.val) temp = temp.right;
            else  temp = temp.left;
        }

        return null;
    }
}
