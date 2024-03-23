class Solution {
    public int findDuplicate(int[] nums)
    {
        boolean[] vis = new boolean[nums.length];

        for(int num : nums)
        {
            if(vis[num]) return num;
            vis[num] = true;
        }

        return -1;
    }
}