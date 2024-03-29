class Solution {

    private TreeNode minVal(TreeNode root)
    {
        TreeNode temp = root;
        while (temp.left != null)
            temp = temp.left;

        return temp;
    }
    public TreeNode deleteNode(TreeNode root, int key)
    {
        //base case
        if(root == null) return root;

        if(root.val == key)
        {
            //0 child
            if(root.left == null && root.right == null)
            {
                root = null;
                return null;
            }

            //1 child ->left

            if(root.left != null && root.right == null)
            {
                TreeNode temp = root.left;
                root = null;
                return temp;
            }

            //right child
            if(root.left == null && root.right != null)
            {
                TreeNode temp = root.right;
                root = null;
                return temp;
            }

            //2 child
            if(root.left != null && root.right != null)
            {
                int min = minVal(root.right).val;

                root.val = min;
                root.right = deleteNode(root.right, min);
                return root;
            }
        }

        else if(root.val > key)
        {
            root.left = deleteNode(root.left, key);
            return root;
        }
        else
        {
            root.right = deleteNode(root.right, key);
            return root;
        }

        return root;
    }
}