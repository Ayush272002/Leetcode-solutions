import java.util.HashSet;
import java.util.Set;

class Solution3
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums1) set.add(n);

        for(int n : nums2)
        {
            if(set.contains(n)) ans.add(n);
        }

        // Convert List<Integer> to int[]
        int[] result = new int[ans.size()];
        int i = 0;
        for (int n : ans)
        {
            result[i++] = n;
        }

        return result;
    }
}