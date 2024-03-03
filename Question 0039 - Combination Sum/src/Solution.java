import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combi, int index)
    {
        //base case
        if(target == 0)
        {
            ans.add(new ArrayList<>(combi));
            return;
        }

        if(index < 0 || target<0) return;

        //include
        combi.add(candidates[index]);
        solve(candidates, target-candidates[index], ans, combi, index);
        combi.removeLast();

        //exclude
        solve(candidates, target, ans, combi, index-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();
        solve(candidates,target,ans,combi, candidates.length-1);
        return ans;
    }
}