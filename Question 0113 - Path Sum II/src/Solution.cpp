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
private:
    void solve(TreeNode *root, vector<vector<int>> &ans, vector<int> &curr, int targetSum)
    {
        if (!root)
            return;

        curr.push_back(root->val);
        if (!root->left && !root->right && targetSum == root->val)
        {
            ans.push_back(curr);
        }
        else
        {
            if (root->left)
            {
                solve(root->left, ans, curr, targetSum - root->val);
            }

            if (root->right)
            {

                solve(root->right, ans, curr, targetSum - root->val);
            }
        }
        curr.pop_back();
    }

public:
    vector<vector<int>> pathSum(TreeNode *root, int targetSum)
    {
        vector<vector<int>> ans;
        vector<int> curr;
        solve(root, ans, curr, targetSum);
        return ans;
    }
};