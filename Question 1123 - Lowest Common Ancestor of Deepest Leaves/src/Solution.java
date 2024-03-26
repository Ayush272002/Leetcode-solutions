class Solution
{
    private class Pair
    {
        TreeNode node;
        int depth;
        public Pair(TreeNode root, int depth)
        {
            this.node = root;
            this.depth = depth;
        }
    }
    private Pair postOrder(TreeNode root)
    {
        if(root == null) return new Pair(null,0);

        Pair left = postOrder(root.left);
        Pair right = postOrder(root.right);

        int maxD = 1 + Math.max(left.depth, right.depth);

        if(left.depth == right.depth) return new Pair(root, maxD);
        else if(left.depth > right.depth) return new Pair(left.node, maxD);
        else return new Pair(right.node, maxD);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root)
    {
        return postOrder(root).node;
    }
}