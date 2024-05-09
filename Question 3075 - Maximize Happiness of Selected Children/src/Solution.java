import java.util.Comparator;
import java.util.PriorityQueue;

class Solution
{
    public long maximumHappinessSum(int[] happiness, int k)
    {
        long ans = 0L;

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : happiness) q.add(n);

        int diff = 0;
        for(int i = 0; i < k && !q.isEmpty(); i++)
        {
            int val = Math.max(q.poll() + diff, 0);
            diff--;
            ans += val;
        }

        return ans;
    }
}