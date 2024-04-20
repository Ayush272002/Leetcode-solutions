import java.util.ArrayList;
import java.util.List;

class Solution
{
    private void dfs(int[][] land, List<int[]> ans, int[][] dir, int r, int c)
    {
        //base case
        if(r < 0 || c < 0 || r >= land.length || c >= land[0].length || land[r][c] == 0) return;

        land[r][c] = 0;
        int[] coord = ans.get(ans.size()-1);
        coord[2] = Math.max(coord[2], r);
        coord[3] = Math.max(coord[3], c);

        for(int[] d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            dfs(land, ans, dir, x, y);
        }
    }

    public int[][] findFarmland(int[][] land)
    {
        List<int[]> ans = new ArrayList<>();

        int n = land.length;
        int m = land[0].length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(land[i][j] == 1)
                {
                    ans.add(new int[]{i, j, -1, -1});
                    dfs(land, ans, dir, i, j);
                }
            }
        }

        return ans.toArray(new int[0][]);
    }
}