class Solution
{
    public TreeNode addOneRow(TreeNode root, int val, int depth)
    {
        if(root == null) return root;

        if(depth == 1)
        {
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            root = temp;
        }

        if(depth - 1 == 1)
        {
            TreeNode temp = new TreeNode(val);
            temp.left = root.left;
            root.left = temp;

            TreeNode tmp = new TreeNode(val);
            tmp.right = root.right;
            root.right = tmp;
        }

        addOneRow(root.left, val, depth-1);
        addOneRow(root.right, val, depth-1);

        return root;
    }
}