import java.util.ArrayList;
import java.util.List;

class Solution {

    private void solve(List<List<Integer>> ans , List<Integer> path, int[][] graph, int node)
    {
        if(node == graph.length-1)
        {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i< graph[node].length; i++)
        {
            int temp = graph[node][i];
            path.add(temp);
            solve(ans,path,graph,temp);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        solve(ans,path,graph,0);
        return ans;
    }
}