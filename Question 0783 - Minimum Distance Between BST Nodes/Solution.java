import java.util.ArrayList;
import java.util.List;

class Solution {
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        traverse(root, inorder);

        int diff = Integer.MAX_VALUE;

        for (int i = 1; i < inorder.size(); i++) {
            diff = Math.min(diff, Math.abs(inorder.get(i) - inorder.get(i - 1)));
        }

        return diff;
    }
}