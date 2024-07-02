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
    bool solve(TreeNode *root, int currSum, int targetSum)
    {
        if (!root)
            return false;
            
        currSum += root->val;
        if (currSum == targetSum && !root->left && !root->right)
            return true;


        return solve(root->left, currSum, targetSum) || solve(root->right, currSum, targetSum);
    }

public:
    bool hasPathSum(TreeNode *root, int targetSum)
    {
        return solve(root, 0, targetSum);
    }
};