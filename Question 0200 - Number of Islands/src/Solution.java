import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    private static class Pair {
        int first, second;
        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    private void bfs(int r, int c, boolean[][] visited, char[][] grid, int[][] direction)
    {
        visited[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            int row = temp.first;
            int col = temp.second;

            //traverse the neighbours and find that if its a land
            for(int[] dir : direction) {
                int newRow = row+dir[0];
                int newCol = col+dir[1];

                if(newRow >= 0 && newRow < n && newCol >=0 && newCol <m)
                {
                    if(!visited[newRow][newCol] && grid[newRow][newCol] == '1')
                    {
                        visited[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid)
    {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] direction = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    count++;
                    bfs(i,j,visited,grid,direction);
                }
            }
        }
        return count;
    }
}