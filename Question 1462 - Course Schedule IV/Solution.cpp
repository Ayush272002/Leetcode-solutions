#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>> &prerequisites, vector<vector<int>> &queries)
    {
        unordered_map<int, list<int>> adj;

        for (auto &V : prerequisites)
        {
            int u = V[0];
            int v = V[1];

            adj[u].push_back(v);
        }

        vector<int> inDegree(numCourses, 0);
        for (auto &node : adj)
        {
            for (auto &nbr : node.second)
                inDegree[nbr]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++)
        {
            if (inDegree[i] == 0)
                q.push(i);
        }

        vector<int> topo;
        while (!q.empty())
        {
            int front = q.front();
            q.pop();

            topo.push_back(front);

            for (auto &nbr : adj[front])
            {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0)
                    q.push(nbr);
            }
        }

        vector<unordered_set<int>> prerequisitesMap(numCourses);
        for (int c : topo)
        {
            for (int nbr : adj[c])
            {
                prerequisitesMap[nbr].insert(c);
                prerequisitesMap[nbr].insert(prerequisitesMap[c].begin(), prerequisitesMap[c].end());
            }
        }

        vector<bool> ans;
        for (auto &q : queries)
        {
            ans.push_back(prerequisitesMap[q[1]].count(q[0]) > 0);
        }

        return ans;
    }
};