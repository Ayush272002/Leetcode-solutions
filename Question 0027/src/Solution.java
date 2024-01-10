import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int removeElement(int[] nums, int val) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            int x = q.poll();
            if(x==val) continue;
            else
            {
                ans.add(x);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            nums[i] = ans.get(i);
        }

        return ans.size();
    }
}