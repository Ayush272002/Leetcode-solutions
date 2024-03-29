import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void solve(List<List<Integer>> ans,List<Integer> list, int n, int k, int start)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            solve(ans,list,n,k-1,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(ans,list,n,k, 1);
        return ans;
    }
}