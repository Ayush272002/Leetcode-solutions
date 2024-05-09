import java.util.Arrays;

class OptimisedSol
{
    public long maximumHappinessSum(int[] happiness, int k)
    {
        long ans = 0L;
        Arrays.sort(happiness);

        int diff = 0, n = happiness.length;
        for(int i = n-1; i >= n-k; i--)
        {
            int val = Math.max(happiness[i] + diff, 0);
            diff--;
            ans += val;
        }

        return ans;
    }
}