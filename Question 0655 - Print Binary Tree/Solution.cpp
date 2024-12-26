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
    int getHeight(TreeNode *root)
    {
        if (!root)
            return 0;

        return 1 + max(getHeight(root->left), getHeight(root->right));
    }

    void fillTree(TreeNode *root, vector<vector<string>> &ans, int level, int left, int right)
    {
        if (!root)
            return;

        int mid = left + (right - left) / 2;
        ans[level][mid] = to_string(root->val);

        fillTree(root->left, ans, level + 1, left, mid - 1);
        fillTree(root->right, ans, level + 1, mid + 1, right);
    }

public:
    vector<vector<string>> printTree(TreeNode *root)
    {
        if (!root)
            return {};

        int height = getHeight(root);

        int width = (1 << height) - 1;

        vector<vector<string>> ans(height, vector<string>(width, ""));

        fillTree(root, ans, 0, 0, width - 1);
        return ans;
    }
};