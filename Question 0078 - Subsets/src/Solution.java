import java.util.*;

class Solution {
    public void solve(List<Integer> subset, List<List<Integer>> ans, Deque<Integer> q)
    {
        if(q.isEmpty())
        {
            ans.add(new ArrayList<>(subset));
            return;
        }

        int temp = q.poll();
        solve(subset, ans, q);
        subset.add(temp);
        solve(subset, ans, q);
        subset.remove(subset.size()-1);
        q.addFirst(temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        solve(subset, ans, q);
        return ans;
    }
}