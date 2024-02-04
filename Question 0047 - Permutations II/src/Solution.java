import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private void solve(int[] nums, List<Integer> permutations, List<List<Integer>> ans, boolean[] visited)
    {
        if(permutations.size() == nums.length)
        {
            ans.add(new ArrayList<>(permutations));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i] ||(i>0 && !visited[i-1] && nums[i] == nums[i-1])) continue;

            visited[i] = true;
            permutations.add(nums[i]);
            solve(nums, permutations, ans, visited);
            visited[i] = false;
            permutations.remove(permutations.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permutations = new ArrayList<>();
        Arrays.sort(nums);

        solve(nums, permutations, ans, new boolean[nums.length]);

        return ans;
    }
}