import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public void rotate(int[] nums, int k)
    {
        Queue<Integer> front = new LinkedList<>();
        Queue<Integer> rear = new LinkedList<>();

        int n = nums.length;
        k = k % n; // Handle the case when k is greater than the array length
        
        for (int i = 0; i < n - k; i++) {
            front.add(nums[i]);
        }

        for (int i = n-k; i < n; i++) {
            rear.add(nums[i]);
        }

        int count = 0;
        while(!rear.isEmpty())
        {
            nums[count] = rear.poll();
            count++;
        }
        while(!front.isEmpty())
        {
            nums[count] = front.poll();
            count++;
        }
    }
}
