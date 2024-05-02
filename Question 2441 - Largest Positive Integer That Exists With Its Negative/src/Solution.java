import java.util.HashSet;
import java.util.Set;

class Solution
{
    public int findMaxK(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        int maxi = Integer.MIN_VALUE;

        for(int n : nums)
        {
            if(set.contains(n*-1)) maxi = Math.max(maxi, Math.abs(n));
            else set.add(n);
        }

        return maxi == Integer.MIN_VALUE ? -1 : maxi;
    }
}