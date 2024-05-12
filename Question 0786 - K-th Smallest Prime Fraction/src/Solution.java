import java.util.Comparator;
import java.util.PriorityQueue;

class Solution
{
    private static class Tuple
    {
        double val;
        int i, j;

        Tuple(double val, int i, int j)
        {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k)
    {
        int n = arr.length;
        PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingDouble((Tuple t) -> t.val));

        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                double val = (double) arr[i] /arr[j];
                q.add(new Tuple(val, arr[i], arr[j]));
            }
        }

        int[] ans = new int[2];
        for(int i = 1; i < k; i++) q.poll();

        if(!q.isEmpty())
        {
            Tuple t = q.poll();
            ans[0] = t.i;
            ans[1] = t.j;
        }

        return ans;
    }
}