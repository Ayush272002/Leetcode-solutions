import java.util.*;

class Solution {
    private void solve(List<List<Integer>> ans, List<Integer> subset, int[] nums, int start)
    {
        ans.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            solve(ans, subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        solve(ans,subset, nums, 0);
        return ans;
    }
}