class Solution {
    private void solve(int[][] arr, int i, int j, int color, int init, int[][] dir) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != init)
            return;

        arr[i][j] = color;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            solve(arr, x, y, color, init, dir);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;

        int init = image[sr][sc];
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        solve(ans, sr, sc, color, init, dir);

        return ans;
    }
}