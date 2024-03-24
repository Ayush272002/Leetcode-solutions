import java.util.Arrays;

class Solution
{
    private int solve(int num, int max, int k, int[] dp)
    {
        //base case
        if(num >= k) return 0;
        if(dp[max] != -1) return dp[max];

        //add 1
        int add = 1 + solve(num+1, max+1, k, dp);

        //multiply
        int mul = 1 + solve(num + max, max, k, dp);

        return dp[max] = Math.min(add,mul);
    }
    public int minOperations(int k)
    {
        int num = 1;
        int max = 1;
        int[] dp = new int[k+1];
        Arrays.fill(dp,-1);
        return solve(num,max,k, dp);
    }
}