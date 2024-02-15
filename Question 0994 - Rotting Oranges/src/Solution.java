import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid)
    {
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        int row = grid.length;
        int col = grid[0].length;
        int time = 0, max = 0;

        Queue<Trio> q = new LinkedList<>();
        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 2)
                    q.add(new Trio(i,j,0));
            }
        }


        while(!q.isEmpty())
        {
            Trio temp = q.poll();
            vis[temp.row][temp.col] = true;

            for(int[] di : dir)
            {
                int i = temp.row + di[0];
                int j = temp.col + di[1];

                if(isValid(i,j,grid) && grid[i][j] == 1 && !vis[i][j])
                {
                    grid[i][j] = 2;
                    q.add(new Trio(i,j, temp.time+1));
                }
            }

            max = Math.max(max, temp.time);
        }

        for(int[] rows: grid)
        {
            for(int cols : rows)
            {
                if(cols ==1) time++;
            }
        }

        return time>0 ? -1 : max;
    }

    private boolean isValid(int i, int j, int[][] grid)
    {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}