#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    bool dfs(int node, unordered_map<int, bool> &visited, unordered_map<int, bool> &dfsVisited, unordered_map<int, list<int>> &adj)
    {
        visited[node] = true;
        dfsVisited[node] = true;

        for (int nbr : adj[node])
        {
            if (!visited[nbr])
            {
                if (dfs(nbr, visited, dfsVisited, adj))
                    return true;
            }
            else if (visited[nbr] && dfsVisited[nbr])
                return true;
        }

        dfsVisited[node] = false;
        return false;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites)
    {
        unordered_map<int, list<int>> adj;

        for (auto &pre : prerequisites)
        {
            int u = pre[0];
            int v = pre[1];

            adj[v].push_back(u);
        }

        unordered_map<int, bool> visited;
        unordered_map<int, bool> dfsVisited;
        for (int i = 0; i < numCourses; i++)
        {
            if (!visited[i])
            {
                if (dfs(i, visited, dfsVisited, adj))
                    return false;
            }
        }

        return true;
    }
};