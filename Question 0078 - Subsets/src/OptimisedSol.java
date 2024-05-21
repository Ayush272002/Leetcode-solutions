import java.util.ArrayList;
import java.util.List;

class OptimisedSol
{
    private void solve(int[] nums, List<List<Integer>> ans, List<Integer> curr, int idx)
    {
        if(idx >= nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        //take
        curr.add(nums[idx]);
        solve(nums, ans, curr, idx+1);
        curr.remove(curr.size()-1);

        //skip
        solve(nums, ans, curr, idx+1);
    }

    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(nums, ans, curr, 0);
        return ans;
    }
}