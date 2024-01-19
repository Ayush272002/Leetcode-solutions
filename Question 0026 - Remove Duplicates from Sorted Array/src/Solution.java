import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int removeDuplicates(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        int count = 0;


        while(!q.isEmpty())
        {
            int x = q.poll();
            if(!ans.isEmpty() && ans.peekLast() == x) continue;
            else
            {
                ans.add(x);
                count++;
            }
        }

        ArrayList<Integer> ar = new ArrayList<>();
        while(!ans.isEmpty())
        {
            ar.add(ans.poll());
        }

        for (int i = 0; i < ar.size(); i++) {
            nums[i] = ar.get(i);
        }
        return count;
    }
}