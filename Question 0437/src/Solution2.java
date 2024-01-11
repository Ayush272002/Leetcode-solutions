import java.util.HashMap;

class Solution2 {
    long solve(TreeNode root, long targetSum, long currentSum, HashMap<Long, Long> prefixSums) {
        if (root == null) return 0;

        currentSum += root.val;
        long count = prefixSums.getOrDefault(currentSum - targetSum, 0L);

        prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0L) + 1);

        count += solve(root.left, targetSum, currentSum, prefixSums) + solve(root.right, targetSum, currentSum, prefixSums);

        prefixSums.put(currentSum, prefixSums.get(currentSum) - 1);

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Long> prefixSums = new HashMap<>();
        prefixSums.put(0L, 1L); // Initialize with 0 to handle cases where the sum matches at the root
        return (int) solve(root, (long) targetSum, 0L, prefixSums);
    }
}