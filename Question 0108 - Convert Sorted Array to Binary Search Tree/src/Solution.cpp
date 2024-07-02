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
    TreeNode *solve(vector<int> &nums, int start, int end)
    {
        if (start == end)
            return NULL;

        int idx = start + (end - start) / 2;
        TreeNode *root = new TreeNode(nums[idx]);
        root->left = solve(nums, start, idx);
        root->right = solve(nums, idx + 1, end);

        return root;
    }

public:
    TreeNode *sortedArrayToBST(vector<int> &nums)
    {
        return solve(nums, 0, nums.size());
    }
};