import java.util.*;

class Solution {
    public int minJumps(int[] arr)
    {
        int n = arr.length;
        if(n == 1) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();


        for(int i = 0; i < n; i++)
        {
            graph.putIfAbsent(arr[i], new ArrayList<>());
            graph.get(arr[i]).add(i);
        }


        boolean[] vis = new boolean[n];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty())
        {
            count++;
            int s = q.size();

            for(int i = 0; i < s; i++)
            {
                int index = q.poll();

                if(index == n-1) return count-1;

                if(index -1 >= 0 && !vis[index-1])
                {
                    q.add(index-1);
                    vis[index-1] = true;
                }


                if(index + 1 < n && !vis[index+1])
                {
                    q.add(index+1);
                    vis[index+1] = true;
                }

                for(int idx : graph.get(arr[index]))
                {
                    if(idx != index && !vis[idx])
                    {
                        q.add(idx);
                        vis[idx] = true;
                    }
                }

                graph.get(arr[index]).clear;
            }

        }

        return -1;
    }
}