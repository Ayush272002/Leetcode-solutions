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
    int solve(TreeNode *root, int &len)
    {
        if (root == NULL)
            return 0;

        int left = solve(root->left, len);
        int right = solve(root->right, len);

        len = max(len, left + right);
        return max(left, right) + 1;
    }

    int diameterOfBinaryTree(TreeNode *root)
    {
        int len = 0;
        solve(root, len);
        return len;
    }
};