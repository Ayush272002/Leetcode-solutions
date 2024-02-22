class Solution {
    public int findJudge(int n, int[][] trust)
    {
        int[] trustCount = new int[n+1]; //starting from 1

        for(int[] t : trust)
        {
            int personWhoTrust = t[0];
            int personWhoIsGettingTrusted = t[1];

            trustCount[personWhoTrust]--;
            trustCount[personWhoIsGettingTrusted]++;
        }

        for(int i = 1; i<=n ; i++)
        {
            if(trustCount[i] == n-1) return i; //max n-1, excluding the judge
        }

        return -1;
    }
}