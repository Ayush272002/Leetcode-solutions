public class Codec {

    // Encodes a tree to a single string.
    private void preOrderFinder(TreeNode root, StringBuilder preOrder)
    {
        if(root == null)
        {
            preOrder.append("null,");
            return;
        }

        preOrder.append(root.val).append(",");
        preOrderFinder(root.left,preOrder);
        preOrderFinder(root.right,preOrder);
    }
    public String serialize(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        preOrderFinder(root,sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    private int index = 0;
    private TreeNode solve(String[] preOrder)
    {
        if(index >= preOrder.length) {
            index++;
            return null;
        }
        String curr = preOrder[index++];
        if(curr.equals("null")) return null;

        int val = Integer.parseInt(curr);
        TreeNode root = new TreeNode(val);
        root.left = solve(preOrder);
        root.right = solve(preOrder);
        return root;
    }
    public TreeNode deserialize(String data)
    {
        index = 0;
        String[] preOrder = data.split(",");
        return solve(preOrder);

    }
}
