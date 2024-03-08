import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int maxi = 0;
        for(Map.Entry<Integer,Integer> mp : map.entrySet())
        {
            maxi = Math.max(maxi,mp.getValue());
        }

        int k = maxi;
        maxi = 0;
        for(Map.Entry<Integer,Integer> mp : map.entrySet())
        {
            if(mp.getValue() == k) maxi += mp.getValue();
        }

        return maxi;
    }
}