import java.util.ArrayList;

class Solution
{

    void inOrder(ArrayList<Integer> nums, TreeNode root, int low, int high)
    {
        if(root == null) return;

        inOrder(nums, root.left, low, high);
        if(root.val >= low && root.val <= high) nums.add(root.val);
        inOrder(nums, root.right, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high)
    {
        ArrayList<Integer> nums = new ArrayList<>();
        inOrder(nums, root, low , high);

        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }

        return sum;
    }
}