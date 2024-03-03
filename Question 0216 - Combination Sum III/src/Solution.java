import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void solve(List<List<Integer>> ans, List<Integer> combi, int k, int n, int curr)
    {
        //base case
        if(k == 0 && n ==0)
        {
            ans.add(new ArrayList<>(combi));
            return;
        }

        for (int i = curr; i < 10; i++)
        {
            if(i <= n)
            {
                combi.add(i);
                solve(ans, combi, k-1, n-i, i+1);
                combi.removeLast();
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();
        solve(ans,combi,k, n, 1);
        return ans;
    }
}