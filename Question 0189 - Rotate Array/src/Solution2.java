import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public void rotate(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            q.addLast(nums[i]);
        }

        while (k > 0) {
            q.addFirst(q.pollLast());
            k--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = q.pollFirst();
        }
    }
}
