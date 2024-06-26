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
    int maxDepth(TreeNode *root)
    {
        if(!root)
            return 0;

        if(!root->left && !root->right)
            return 1;

        int left = 0, right = 0;
        if(root->left)
            left = 1 + maxDepth(root->left);

        if(root->right)
            right = 1 + maxDepth(root->right);

        return max(left, right);
    }
};