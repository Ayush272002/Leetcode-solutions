import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int end = nums.length-1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }


        for (int i = k; i <= end; i++) {
            if(!pq.isEmpty() && nums[i] > pq.peek())
            {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        if(!pq.isEmpty()) return pq.peek();
        else return -1;
    }
}