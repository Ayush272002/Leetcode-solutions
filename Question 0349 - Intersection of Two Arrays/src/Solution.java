import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pt1 = 0, pt2 = 0;
        Set<Integer> ans = new HashSet<>();

        while (pt1 < nums1.length && pt2 < nums2.length) {
            if (nums1[pt1] == nums2[pt2])
            {
                ans.add(nums1[pt1]);
                pt1++;
                pt2++;
            }
            else if (nums1[pt1] > nums2[pt2]) pt2++;
            else pt1++;
        }
        if(ans.isEmpty()) return new int[0];

        int[] res = new int[ans.size()];
        int i = 0;
        for(int n : ans)
            res[i++] = n;

        return res;
    }
}
