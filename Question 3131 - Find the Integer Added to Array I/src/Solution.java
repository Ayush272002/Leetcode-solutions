import java.util.Arrays;

class Solution
{
    public int addedInteger(int[] nums1, int[] nums2)
    {
        int n1 = nums1[0], n2 = nums2[0];

        for(int n : nums1) n1 = Math.min(n1, n);
        for(int n : nums2) n2 = Math.min(n2, n);

        return n2-n1;
    }
}