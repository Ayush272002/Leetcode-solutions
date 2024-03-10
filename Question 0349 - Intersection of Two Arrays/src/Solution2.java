import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length)
        {
            if(nums1[p1] == nums2[p2] && !ans.contains(nums1[p1]))
            {
                ans.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] > nums2[p2]) p2++;
            else p1++;
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}