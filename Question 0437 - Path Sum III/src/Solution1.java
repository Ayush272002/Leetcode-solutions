import java.util.ArrayList;

class Solution1 {
    int count;

    void solve(TreeNode root, long k, ArrayList<Integer> path) {
        // base case
        if (root == null) return;

        path.add(root.val);

        // left
        solve(root.left, k, path);

        // right
        solve(root.right, k, path);

        // check for k sum
        int size = path.size();
        long sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) this.count++;
        }

        path.remove(path.size() - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        // code here
        ArrayList<Integer> path = new ArrayList<>();
        this.count = 0; // Initialize count here
        solve(root, targetSum, path);
        return this.count;
    }
}