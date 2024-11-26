class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] nodes = new int[n];

        for (int[] edge : edges)
            nodes[edge[1]]++;

        int count = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nodes[i] == 0) {
                count++;
                ans = i;
            }

            if (count > 1)
                return -1;
        }

        return ans;
    }
}