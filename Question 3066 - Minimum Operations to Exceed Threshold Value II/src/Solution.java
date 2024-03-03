import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k)
    {
        int n = nums.length;
        Arrays.sort(nums);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add((long) nums[i]);
        }

        int count = 0;

        while(!pq.isEmpty() && pq.size() >= 2 && pq.peek() < k)
        {
            long x = pq.poll();
            long y = pq.poll();

            long val = Math.min(x,y)*2+Math.max(x,y);
            pq.add(val);
            count++;
        }
        return count;
    }
}