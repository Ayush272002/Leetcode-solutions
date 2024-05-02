class Solution
{
    public int maxArea(int[] height)
    {
        int n = height.length;
        int left = 0, right = n-1, ans = Integer.MIN_VALUE;

        while(left < right)
        {
            int minHeight = Math.min(height[left], height[right]);
            ans = Math.max(ans, minHeight*(right-left));

            while(left < right && height[left] <= minHeight) left++;
            while(left < right && height[right] <= minHeight) right--;
        }

        return ans;
    }
}