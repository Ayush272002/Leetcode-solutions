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
    bool solve(TreeNode *root, long long max, long long min)
    {
        if(!root)
            return true;

        if(root->val <= min || root->val >= max)
            return false;

        return solve(root->left, root->val, min) && solve(root->right, max, root->val);
    }

public:
    bool isValidBST(TreeNode *root)
    {
        return solve(root, LLONG_MAX, LLONG_MIN);
    }
};