import java.util.PriorityQueue;

class Solution {
    class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public long findScore(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.first == b.first ? a.second - b.second : a.first - b.first);

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }

        long ans = 0;
        boolean[] marked = new boolean[n];

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int val = temp.first;
            int idx = temp.second;

            if (marked[idx])
                continue;

            ans += val;
            marked[idx] = true;

            if (idx + 1 < n)
                marked[idx + 1] = true;

            if (idx - 1 >= 0)
                marked[idx - 1] = true;
        }

        return ans;
    }
}