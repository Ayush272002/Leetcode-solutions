class Solution {
    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int[][] dir) {
        // base case
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0' || visited[i][j])
            return;

        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            dfs(grid, visited, x, y, dir);
        }
    }

    public int numIslands(char[][] grid) {
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    dfs(grid, visited, i, j, dir);
                }
            }
        }

        return ans;
    }
}