import java.util.ArrayList;
import java.util.List;

class SolUsingRecursion
{
    private void solve(List<Integer> ans, int curr, int n)
    {
        //base case
        if(curr > n) return;

        ans.add(curr);
        for(int i = 0; i < 10; i++)
        {
            solve(ans, curr * 10 + i, n);
        }
    }

    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= 9; i++)
        {
            solve(ans, i, n);
        }

        return ans;

    }
}