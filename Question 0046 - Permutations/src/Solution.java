import java.util.ArrayList;
import java.util.List;

class Solution {
    private void solve(int[] nums,List<Integer> permutations, List<List<Integer>> ans)
    {
        if(permutations.size() == nums.length)
        {
            ans.add(new ArrayList<>(permutations));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(permutations.contains(nums[i])) continue;

            permutations.add(nums[i]);
            solve(nums,permutations, ans);
            permutations.remove(permutations.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permutations = new ArrayList<>();
        solve(nums,permutations,  ans);
        return ans;
    }
}