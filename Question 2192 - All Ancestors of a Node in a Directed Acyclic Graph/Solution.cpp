#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>> &edges)
    {
        unordered_map<int, list<int>> adj;

        for (auto &e : edges)
        {
            int u = e[0], v = e[1];
            adj[u].push_back(v);
        }

        vector<int> inDegree(n);
        for (auto &node : adj)
        {
            for (auto &nbr : node.second)
                inDegree[nbr]++;
        }

        queue<int> q;
        for (int i = 0; i < n; i++)
        {
            if (inDegree[i] == 0)
                q.push(i);
        }

        vector<vector<int>> ancestors(n);
        while (!q.empty())
        {
            int front = q.front();
            q.pop();

            for (auto &nbr : adj[front])
            {
                vector<int> &ancestor_nbr = ancestors[nbr];
                ancestor_nbr.push_back(front);
                ancestor_nbr.insert(ancestor_nbr.end(), ancestors[front].begin(), ancestors[front].end());

                sort(ancestor_nbr.begin(), ancestor_nbr.end());

                int start = 1, end = ancestor_nbr.size();
                for (int i = 1; i < end; i++)
                {
                    if (ancestor_nbr[i] != ancestor_nbr[i - 1])
                    {
                        ancestor_nbr[start++] = ancestor_nbr[i];
                    }
                }

                ancestor_nbr.resize(start);

                if (--inDegree[nbr] == 0)
                    q.push(nbr);
            }
        }

        return ancestors;
    }
};