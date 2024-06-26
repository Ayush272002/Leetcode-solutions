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
    vector<vector<int>> zigzagLevelOrder(TreeNode *root)
    {
        vector<vector<int>> ans;
        if (!root)
            return ans;

        queue<TreeNode *> q;
        q.push(root);
        bool leftToRight = true;

        while (!q.empty())
        {
            int sz = q.size();
            vector<int> curr;
            for (int i = 0; i < sz; i++)
            {
                TreeNode *temp = q.front();
                q.pop();

                curr.push_back(temp->val);
                if (temp->left)
                    q.push(temp->left);
                if (temp->right)
                    q.push(temp->right);
            }

            if (leftToRight)
                ans.push_back(curr);
            else
            {
                reverse(curr.begin(), curr.end());
                ans.push_back(curr);
            }

            leftToRight = !leftToRight;
        }

        return ans;
    }
};