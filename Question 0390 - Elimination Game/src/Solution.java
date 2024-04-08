import java.util.ArrayList;
import java.util.List;

class Solution
{
    public int lastRemaining(int n)
    {
        boolean flag = true; // left is true;
        int step = 1;
        int head = 1;

        while(n > 1)
        {
            if(flag || (n&1) == 1) head += step;

            n /= 2;
            step *= 2;
            flag = !flag;
        }

        return head;
    }
}