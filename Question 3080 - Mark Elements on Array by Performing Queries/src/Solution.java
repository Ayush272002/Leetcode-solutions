import java.util.HashSet;
import java.util.PriorityQueue;

class Solution
{
    public long[] unmarkedSumArray(int[] nums, int[][] queries)
    {
        int n = nums.length;
        int m = queries.length;

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->nums[a] == nums[b] ? a-b : nums[a] - nums[b]);
        long[] ans = new long[m];

        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            q.add(i);
        }

        for(int idx = 0; idx < m; idx++)
        {
            int[] query = queries[idx];
            int i = query[0];
            int count = query[1];

            if(!set.contains(i))
            {
                sum -= nums[i];
                set.add(i);
            }

            while(count > 0 && !q.isEmpty())
            {
                int temp = q.poll();
                if(!set.contains(temp))
                {
                    sum -= nums[temp];
                    set.add(temp);
                    count--;
                }
            }

            ans[idx] = sum;
        }

        return ans;
    }
}