import java.util.Arrays;

class Solution
{
    private int solve(int[] arr, int d, int idx, int[] dp)
    {
        //base case
        if(idx < 0 || idx >= arr.length) return 0;
        int max = 1;
        if(dp[idx] != -1) return dp[idx];

        for(int i = 1; i <= d; i++)
        {
            if(i + idx < arr.length && arr[i + idx] < arr[idx]) max = Math.max(max,1+ solve(arr,d, i + idx, dp));
            else break;
        }

        for(int i = 1; i <= d; i++)
        {
            if(idx - i >=0 && arr[idx-i] < arr[idx]) max = Math.max(max,1+ solve(arr,d, idx-i, dp));
            else break;
        }

        return dp[idx] = max;
    }
    public int maxJumps(int[] arr, int d)
    {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length+1];

        for(int i = 0; i < arr.length; i++)
        {
            Arrays.fill(dp,-1);
            max = Math.max(max, solve(arr,d,i, dp));
        }

        return max;
    }
}