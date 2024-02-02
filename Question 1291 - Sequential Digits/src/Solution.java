import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution
{
    public List<Integer> sequentialDigits(int low, int high)
    {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            int num = i;
            int next = i+1;

            while(num <= high && next <= 9)
            {
                num = 10*num + next;
                if(num >= low && num <= high) ans.add(num);
                next++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}