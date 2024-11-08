class Solution {
    public int findJudge(int n, int[][] trust)
    {
        int[] peopleTrust = new int[trust.length+1];

        for (int[] nbr : trust) {
            peopleTrust[nbr[0]]++;
        }

        for (int i = 0; i < peopleTrust.length; i++) {
            if (peopleTrust[i] == 0)
                return peopleTrust[i];
        }

        return -1;
    }
}