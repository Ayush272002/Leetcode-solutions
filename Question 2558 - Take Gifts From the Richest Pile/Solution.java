import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }

        long ans = 0;
        while (k-- > 0) {
            pq.add((int) Math.sqrt(pq.poll()));
        }

        while (!pq.isEmpty())
            ans += pq.poll();

        return ans;
    }
}