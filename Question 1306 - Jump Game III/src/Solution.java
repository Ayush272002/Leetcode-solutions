class Solution
{
    private void dfs(int[] arr, boolean[] vis, int idx)
    {
        //base case
        if(idx < 0 || idx >= arr.length  || vis[idx]) return;

        vis[idx] = true;

        dfs(arr,vis,idx+arr[idx]);
        dfs(arr,vis,idx-arr[idx]);
    }
    public boolean canReach(int[] arr, int start)
    {
        boolean[] vis = new boolean[arr.length];

        dfs(arr,vis, start);

        for(int i = 0; i < vis.length; i++)
        {
            if(vis[i] && arr[i] == 0) return true;
        }

        return false;
    }
}