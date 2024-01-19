import java.util.Deque;
import java.util.LinkedList;

class Solution2 {
    public int removeDuplicates(int[] nums) {
        Deque<Integer> ans = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (ans.isEmpty() || ans.peekLast() != nums[i]) {
                ans.add(nums[i]);
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            if(ans.peekFirst() != null) nums[i] = ans.poll();
        }

        return count;
    }
}