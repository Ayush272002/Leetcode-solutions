import java.util.*;

class Solution
{
    public int minimumAddedInteger(int[] nums1, int[] nums2)
    {
        int mini = Integer.MAX_VALUE;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i = 0; i < nums1.length-1; i++)
        {
            for(int j = i+1; j < nums1.length; j++)
            {
                List<Integer> nums3 = new ArrayList<>();
                for(int k = 0; k < nums1.length; k++)
                {
                    if(k == i || k == j) continue;
                    else nums3.add(nums1[k]);
                }

                Set<Integer> diff = new HashSet<>();
                for(int k = 0; k < nums3.size(); k++)
                {
                    diff.add(nums2[k] - nums3.get(k));
                }

                if(diff.size() == 1) mini = Math.min(mini, nums2[0] - nums3.getFirst());

            }
        }

        return mini;
    }
}