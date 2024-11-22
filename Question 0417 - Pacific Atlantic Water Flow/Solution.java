import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private void dfs(int r, int c, int prev, int[][] heights, boolean[][] vis, int[][] dir) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || vis[r][c] || prev > heights[r][c]) return;

        vis[r][c] = true;

        for (int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];

            dfs(x, y, heights[r][c], heights, vis, dir);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int n = heights.length, m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            dfs(0, i, heights[0][i], heights, pac, dir);
            dfs(n - 1, i, heights[n - 1][i], heights, atl, dir);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights[i][0], heights, pac, dir);
            dfs(i, m - 1, heights[i][m - 1], heights, atl, dir);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j]) result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }
}
