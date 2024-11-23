class Solution {
    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !visited[r][c]) {
            visited[r][c] = true;
            int up = dfs(grid, visited, r + 1, c);
            int down = dfs(grid, visited, r - 1, c);
            int right = dfs(grid, visited, r, c + 1);
            int left = dfs(grid, visited, r, c - 1);
            return 1 + up + down + right + left;
        }
        return 0;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null)
            return 0;
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] == 1)
                    ans = Math.max(ans, dfs(grid, visited, i, j));
            }
        }

        return ans;
    }
}