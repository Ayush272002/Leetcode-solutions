#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool dfs(int node, vector<bool> &visited, vector<bool> &pathVis, vector<bool> &safeNode, vector<vector<int>> &graph)
    {
        visited[node] = true;
        pathVis[node] = true;

        for (int nbr : graph[node])
        {
            if (pathVis[nbr])
                return true;

            else if (!visited[nbr])
            {
                if (dfs(nbr, visited, pathVis, safeNode, graph))
                    return true;
            }
        }

        safeNode[node] = true;
        pathVis[node] = false;
        return false;
    }

public:
    vector<int> eventualSafeNodes(vector<vector<int>> &graph)
    {
        int v = graph.size();
        vector<bool> visited(v, false);
        vector<bool> pathVis(v, false);
        vector<bool> safeNodes(v, false);

        for (int i = 0; i < v; i++)
        {
            if (!visited[i])
                dfs(i, visited, pathVis, safeNodes, graph);
        }

        vector<int> ans;
        for (int i = 0; i < safeNodes.size(); i++)
        {
            if (safeNodes[i])
                ans.push_back(i);
        }

        return ans;
    }
};