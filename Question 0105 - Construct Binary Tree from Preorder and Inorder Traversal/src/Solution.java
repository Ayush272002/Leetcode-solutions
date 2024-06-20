class Solution
{
    private int findIndex(int[] inorder, int start , int target)
    {
        int i = 0;
        while(inorder[start+i] != target) i++;
        return i;
    }
    private TreeNode buildUtil(int[] preorder, int[] inorder, int inStart, int preStart, int n)
    {
        if(n ==0) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int i = findIndex(inorder, inStart, preorder[preStart]);
        root.left = buildUtil(preorder, inorder, inStart, preStart+1, i);
        root.right = buildUtil(preorder, inorder, inStart+i+1, preStart+i+1, n-i-1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int n = inorder.length;
        return buildUtil(preorder, inorder, 0 , 0, n);
    }
}