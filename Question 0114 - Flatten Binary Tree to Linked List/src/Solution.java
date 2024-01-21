class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode current, prev;
        current = root;

        while(current != null)
        {
            if(current.left != null)
            {
                prev = current.left;

                while(prev.right != null && prev != current)
                    prev = prev.right;

                if(prev.right ==null)
                {
                    prev.right = current.right;
                    current.right = current.left;
                    current.left = null;
                }
            }
            current = current.right;
        }
    }
}