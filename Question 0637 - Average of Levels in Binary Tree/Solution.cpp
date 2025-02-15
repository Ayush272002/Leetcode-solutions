#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
public:
    vector<double> averageOfLevels(TreeNode *root)
    {
        vector<double> ans;

        if (!root)
            return ans;

        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty())
        {
            int sz = q.size();

            double avg = 0;

            for (int i = 0; i < sz; i++)
            {
                TreeNode *tmp = q.front();
                q.pop();

                avg += tmp->val;

                if (tmp->left)
                    q.push(tmp->left);

                if (tmp->right)
                    q.push(tmp->right);
            }

            avg /= sz;
            ans.push_back(avg);
        }

        return ans;
    }
};