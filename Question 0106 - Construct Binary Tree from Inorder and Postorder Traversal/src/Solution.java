import java.util.HashMap;

class Solution {
    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map)
    {
        if(ps>pe || is>ie) return null;


        TreeNode root = new TreeNode(postorder[pe]);

        int val = map.get(postorder[pe]);

        root.left = build(inorder, is, val-1, postorder, ps, ps+val-is-1, map);
        root.right = build(inorder, val+1, ie, postorder, ps+val-is, pe-1, map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder,0,inorder.length-1, postorder,0,postorder.length-1, map);
    }
}