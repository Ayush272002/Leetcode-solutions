import java.util.*;

class Solution2 {
    public int maxFrequencyElements(int[] nums)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int maxi = 0;
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
            maxi = Math.max(maxi,map.get(num));
        }

        int count = 0;
        for(int freq : map.values())
        {
            if(freq == maxi) count += freq;
        }

        return count;
    }
}