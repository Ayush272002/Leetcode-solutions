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
    vector<int> rightSideView(TreeNode *root)
    {
        vector<int> ans;
        if (!root)
            return ans;

        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty())
        {
            int sz = q.size();
            int right;

            for (int i = 0; i < sz; i++)
            {
                TreeNode *tmp = q.front();
                q.pop();

                right = tmp->val;

                if (tmp->left)
                    q.push(tmp->left);

                if (tmp->right)
                    q.push(tmp->right);
            }

            ans.push_back(right);
        }

        return ans;
    }
};