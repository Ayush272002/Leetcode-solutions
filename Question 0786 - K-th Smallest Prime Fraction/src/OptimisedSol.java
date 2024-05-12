import java.util.Comparator;
import java.util.PriorityQueue;

class OptimisedSol
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
        PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingDouble((Tuple t) -> t.val).reversed());

        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                double val = (double) arr[i] /arr[j];
                q.add(new Tuple(val, arr[i], arr[j]));
                if(q.size() > k) q.poll();
            }
        }

        assert q.peek() != null;
        return new int[]{q.peek().i, q.peek().j};
    }
}