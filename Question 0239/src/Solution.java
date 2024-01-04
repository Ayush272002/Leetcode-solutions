import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();  //will contain the indices

        for (int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
                dq.removeLast();

            dq.addLast(i);
        }

        if(!dq.isEmpty())
            ans.add(nums[dq.peek()]);

        //process the remaining window
        for (int i = k; i < nums.length; i++) {
            while(!dq.isEmpty() && i-dq.peek() >= k)
                dq.removeFirst();

            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
                dq.removeLast();

            dq.addLast(i);

            if(!dq.isEmpty()) ans.add(nums[dq.peek()]);
        }


        int[] Ans = new int[ans.size()];
        for (int i = 0; i < Ans.length; i++)
            Ans[i] = ans.get(i);

        return Ans;
    }
}