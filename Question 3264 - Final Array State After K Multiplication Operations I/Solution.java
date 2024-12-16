import java.util.PriorityQueue;

class Solution {
    class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.first != b.first) {
                return a.first - b.first;
            }

            return a.second - b.second;
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }

        while (k > 0) {
            Pair temp = pq.poll();

            temp.first *= multiplier;

            pq.add(temp);
            k--;
        }

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            nums[temp.second] = temp.first;
        }

        return nums;
    }
}